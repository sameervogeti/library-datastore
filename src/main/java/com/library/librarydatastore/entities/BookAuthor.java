package com.library.librarydatastore.entities;

import javax.persistence.*;

@Entity
@Table(name = "BOOK_AUTHOR")
@AssociationOverrides({
        @AssociationOverride(name = "BOOK",
                joinColumns = @JoinColumn(name = "bookId")),
        @AssociationOverride(name = "AUTHOR",
                joinColumns = @JoinColumn(name = "authorId"))})
public class BookAuthor {

    private BookAuthorId bookAuthorId = new BookAuthorId();

    @EmbeddedId
    public BookAuthorId getBookAuthorId() {
        return bookAuthorId;
    }

    public void setBookAuthorId(BookAuthorId bookAuthorId) {
        this.bookAuthorId = bookAuthorId;
    }

    @Transient
    public Book getBook() {
        return getBookAuthorId().getBook();
    }

    public void setBook(Book book) {
        getBookAuthorId().setBook(book);
    }

    @Transient
    public Author getAuthor() {
        return getBookAuthorId().getAuthor();
    }

    public void setAuthor(Author author) {
        getBookAuthorId().setAuthor(author);
    }
}
