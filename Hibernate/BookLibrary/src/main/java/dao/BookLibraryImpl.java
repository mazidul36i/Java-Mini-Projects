package dao;

import bean.Book;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class BookLibraryImpl implements BookLibraryDao {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("Account");
    EntityManager em = emf.createEntityManager();

    @Override
    public Book getBookById(int id) {
        return em.find(Book.class, id);
    }

    @Override
    public String saveBook(Book book) {
        em.getTransaction().begin();
        em.persist(book);
        em.getTransaction().commit();

        return "Book saved successfully!";
    }

    @Override
    public String deleteBook(int id) {
        Book book = em.find(Book.class, id);
        if (book == null) {
            return "Book not found!";
        }

        em.getTransaction().begin();
        em.remove(book);
        em.getTransaction().commit();

        return "Book deleted!";
    }

    @Override
    public String doublePrice(int id) {
        Book book = em.find(Book.class, id);
        if (book == null) {
            return "Book not found!";
        }

        em.getTransaction().begin();
        em.persist(book);
        book.setPrice(book.getPrice() * 2);
        em.getTransaction().commit();

        return "Updated";
    }
}
