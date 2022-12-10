package com.masai.app.model;

public class Book {

	/*
	 * Book Id : 101,
name: "C++",
author: "Nitesh",
publication: "Rajput Publication",
category: "Computer Programming",
pages: 1500,
price: 240,
author_no : G452
	 */
	private Integer bookId;
	private String name, author, publication, category, author_no;
	private Integer pages, price;
	
	public Book() {
		super();
	}

	public Book(Integer bookId, String name, String author, String publication, String category, String author_no,
			Integer pages, Integer price) {
		super();
		this.bookId = bookId;
		this.name = name;
		this.author = author;
		this.publication = publication;
		this.category = category;
		this.author_no = author_no;
		this.pages = pages;
		this.price = price;
	}

	public Integer getBookId() {
		return bookId;
	}

	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPublication() {
		return publication;
	}

	public void setPublication(String publication) {
		this.publication = publication;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getAuthor_no() {
		return author_no;
	}

	public void setAuthor_no(String author_no) {
		this.author_no = author_no;
	}

	public Integer getPages() {
		return pages;
	}

	public void setPages(Integer pages) {
		this.pages = pages;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}
	
}
