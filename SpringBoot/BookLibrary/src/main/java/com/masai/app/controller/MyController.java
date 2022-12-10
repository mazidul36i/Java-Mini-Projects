package com.masai.app.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.masai.app.model.Book;

import jakarta.annotation.PostConstruct;

@RestController()
@RequestMapping("/bookservice")
public class MyController {
	
	List<Book> bookList = new ArrayList<>();
	
	@PostConstruct
	public void onLoad() {
		bookList.add(new Book(101, "C++", "Nitesh", "Rajput Publication", "Computer Programming", "G452", 1500, 240));
		bookList.add(new Book(102, "Java", "Ratan", "Masai Publication", "Computer Programming", "G454", 1455, 3000));
		bookList.add(new Book(103, "Atomic Habits", "James Clear", "James Clear", "Knowledge", "G455", 319, 988));
	}

	@GetMapping("/books")
	public List<Book> getBookListHandler() {
		return bookList;
	}
	
	@GetMapping("/books/{bookId}")
	public Book getBookHandler(@PathVariable("bookId") Integer bookId) {
		Book book = null;
		for (Book b : bookList) {
			if (b.getBookId() == bookId) {
				book = b;
			}
		}
		if (book != null) return book;
		throw new IllegalArgumentException("No book exists with id: " + bookId);
	}
	
	@PostMapping("/books")
	public String addBookHandler(@RequestBody Book book) {
		
		for (Book b : bookList) {
			if (b.getBookId() == book.getBookId()) {
				throw new IllegalArgumentException("A book already exists with Id: " + book.getBookId());
			}
		}
		
		bookList.add(book);
		return "Book added successfully";
	}
	
	@DeleteMapping("/books/{bookId}")
	public String deleteBookHandler(@PathVariable Integer bookId) {
		
		for (int i = 0; i < bookList.size(); i++) {
			if (bookList.get(i).getBookId() == bookId) {
				bookList.remove(i);
				return "Book deleted successfully";
			}
		}
		
		throw new IllegalArgumentException("No book exists with id: " + bookId);
	}
	
	@PutMapping("/books/{bookId}")
	public String updateBookHandler(@PathVariable Integer bookId, @RequestBody Book book) {
		
		for (int i = 0; i < bookList.size(); i++) {
			if (bookList.get(i).getBookId() == bookId) {
				bookList.set(i, book);
				return "Book updated successfully";
			}
		}
		
		throw new IllegalArgumentException("No book exists with id: " + bookId);
	}
	
	@PutMapping("/updateprice/{bookId}")
	public String updatePriceHandler(@PathVariable Integer bookId, @RequestParam("price") Integer price) {
		
		for (int i = 0; i < bookList.size(); i++) {
			if (bookList.get(i).getBookId() == bookId) {
				bookList.get(i).setPrice(price);
				return "Book price updated successfully";
			}
		}
		
		throw new IllegalArgumentException("No book exists with id: " + bookId);
	}
}
