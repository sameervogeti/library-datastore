package com.library.librarydatastore.entities;

import javax.persistence.ManyToOne;
import java.io.Serializable;

public class BookAuthorId implements Serializable {
    private Book book;
    private Author author;

    @ManyToOne
    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    @ManyToOne
    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }
}
