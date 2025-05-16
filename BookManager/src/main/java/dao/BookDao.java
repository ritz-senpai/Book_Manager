package dao;
import hibernateutil.HibernateUtil;
import model.Book;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class BookDao {
    public void saveBook(Book book) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(book);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }

    public void deleteBook(int bookId) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Book book = session.get(Book.class, bookId);

            if (book != null) {
                session.delete(book);
                transaction.commit();
                System.out.println("Book with ID " + bookId + " deleted successfully.");
            } else {
                System.out.println("Book not found with ID: " + bookId);
            }
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }

    public List<Book> getAllBooks() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("FROM Book", Book.class).list();
        }
    }
}
