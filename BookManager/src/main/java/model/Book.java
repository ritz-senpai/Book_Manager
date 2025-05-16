package model;

import javax.persistence.*;

@Entity
@Table(name = "book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String bookName;

    @Column(name = "category")
    private String bookCategory;

    @Column(name = "rating")
    private float bookRating;

    public Book() {}

    public Book(String bookName, String bookCategory, float bookRating) {
        this.bookName = bookName;
        this.bookCategory = bookCategory;
        this.bookRating = bookRating;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookCategory() {
        return bookCategory;
    }

    public void setBookCategory(String bookCategory) {
        this.bookCategory = bookCategory;
    }

    public float getBookRating() {
        return bookRating;
    }

    public void setBookRating(float bookRating) {
        this.bookRating = bookRating;
    }

    @Override
    public String toString() {
        return "Book{id=" + id + ", Name='" + bookName + "', Category='" + bookCategory + "', Rating=" + bookRating + "}";
    }
}
