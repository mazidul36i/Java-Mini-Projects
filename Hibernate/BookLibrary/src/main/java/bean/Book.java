package bean;

import javax.persistence.*;

@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int BookId;

    private String name, author, publication, category, created_timestamp;
    private  int pages, price;

    public Book() {
    }

    public Book(int bookId, String name, String author, String publication, String category, String created_timestamp, int pages, int price) {
        BookId = bookId;
        this.name = name;
        this.author = author;
        this.publication = publication;
        this.category = category;
        this.created_timestamp = created_timestamp;
        this.pages = pages;
        this.price = price;
    }

    public int getBookId() {
        return BookId;
    }

    public void setBookId(int bookId) {
        BookId = bookId;
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

    public String getCreated_timestamp() {
        return created_timestamp;
    }

    public void setCreated_timestamp(String created_timestamp) {
        this.created_timestamp = created_timestamp;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book{" +
                "BookId=" + BookId +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", publication='" + publication + '\'' +
                ", category='" + category + '\'' +
                ", created_timestamp='" + created_timestamp + '\'' +
                ", pages=" + pages +
                ", price=" + price +
                '}';
    }
}
