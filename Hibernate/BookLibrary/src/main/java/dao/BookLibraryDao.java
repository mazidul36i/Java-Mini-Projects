package dao;

import bean.Book;

public interface BookLibraryDao {
    
    public Book getBookById(int id);
    
    public String saveBook(Book book);
    
    public String deleteBook(int id);
    
    public String doublePrice(int id);
    
}
