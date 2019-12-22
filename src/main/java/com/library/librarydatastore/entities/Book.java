package com.library.librarydatastore.entities;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "BOOK")
public class Book {
    private int bookId;
    private String isbn;
    private String title;
    private int publisherId;
    private int yearPublished;
    private String edition;
    private Publisher publisherByPublisherId;
    private Collection<BookAuthor> bookAuthorsByBookId;
    private BookStatus bookStatusByBookId;
    private Collection<UserBook> userBooksByBookId;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "book_generator")
    @SequenceGenerator(name = "book_generator", sequenceName = "BOOK_SEQUENCE")
    @Column(name = "Book_Id", updatable = false, nullable = false)
    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    @Basic
    @Column(name = "ISBN", nullable = false, length = 50)
    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    @Basic
    @Column(name = "Title", nullable = false, length = 50)
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Basic
    @Column(name = "Publisher_Id", nullable = false)
    public int getPublisherId() {
        return publisherId;
    }

    public void setPublisherId(int publisherId) {
        this.publisherId = publisherId;
    }

    @Basic
    @Column(name = "Year_Published", nullable = false)
    public int getYearPublished() {
        return yearPublished;
    }

    public void setYearPublished(int yearPublished) {
        this.yearPublished = yearPublished;
    }

    @Basic
    @Column(name = "Edition", nullable = true, length = 20)
    public String getEdition() {
        return edition;
    }

    public void setEdition(String edition) {
        this.edition = edition;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return bookId == book.bookId &&
                publisherId == book.publisherId &&
                yearPublished == book.yearPublished &&
                Objects.equals(isbn, book.isbn) &&
                Objects.equals(title, book.title) &&
                Objects.equals(edition, book.edition);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bookId, isbn, title, publisherId, yearPublished, edition);
    }

    @ManyToOne
    @JoinColumn(name = "Publisher_Id", referencedColumnName = "Publisher_Id", insertable = false, updatable = false, nullable = false)
    public Publisher getPublisherByPublisherId() {
        return publisherByPublisherId;
    }

    public void setPublisherByPublisherId(Publisher publisherByPublisherId) {
        this.publisherByPublisherId = publisherByPublisherId;
    }


    @OneToMany(fetch = FetchType.LAZY, mappedBy = "bookAuthorId.book")
    public Collection<BookAuthor> getBookAuthorsByBookId() {
        return bookAuthorsByBookId;
    }

    public void setBookAuthorsByBookId(Collection<BookAuthor> bookAuthorsByBookId) {
        this.bookAuthorsByBookId = bookAuthorsByBookId;
    }

    @OneToOne(mappedBy = "bookByBookId")
    public BookStatus getBookStatusByBookId() {
        return bookStatusByBookId;
    }

    public void setBookStatusByBookId(BookStatus bookStatusByBookId) {
        this.bookStatusByBookId = bookStatusByBookId;
    }

    @OneToMany(mappedBy = "bookByBookId")
    public Collection<UserBook> getUserBooksByBookId() {
        return userBooksByBookId;
    }

    public void setUserBooksByBookId(Collection<UserBook> userBooksByBookId) {
        this.userBooksByBookId = userBooksByBookId;
    }
}
