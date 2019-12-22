package com.library.librarydatastore.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "BOOK_STATUS")
public class BookStatus {
    private int bookId;
    private String state;
    private int totalNumberOfCopies;
    private Integer numberOfCopiesIssued;
    private Book bookByBookId;

    @Id
    @Column(name = "Book_Id", updatable = false, nullable = false)
    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    @Basic
    @Column(name = "State", nullable = false)
    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Basic
    @Column(name = "Total_Number_Of_Copies", nullable = false)
    public int getTotalNumberOfCopies() {
        return totalNumberOfCopies;
    }

    public void setTotalNumberOfCopies(int totalNumberOfCopies) {
        this.totalNumberOfCopies = totalNumberOfCopies;
    }

    @Basic
    @Column(name = "Number_Of_Copies_Issued", nullable = true)
    public Integer getNumberOfCopiesIssued() {
        return numberOfCopiesIssued;
    }

    public void setNumberOfCopiesIssued(Integer numberOfCopiesIssued) {
        this.numberOfCopiesIssued = numberOfCopiesIssued;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookStatus that = (BookStatus) o;
        return bookId == that.bookId &&
                totalNumberOfCopies == that.totalNumberOfCopies &&
                Objects.equals(state, that.state) &&
                Objects.equals(numberOfCopiesIssued, that.numberOfCopiesIssued);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bookId, state, totalNumberOfCopies, numberOfCopiesIssued);
    }

    @OneToOne
    @JoinColumn(name = "Book_Id", referencedColumnName = "Book_Id", nullable = false)
    public Book getBookByBookId() {
        return bookByBookId;
    }

    public void setBookByBookId(Book bookByBookId) {
        this.bookByBookId = bookByBookId;
    }
}
