package com.library.librarydatastore.entities;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "USER_BOOK")
public class UserBook {
    private int userBookId;
    private Integer userId;
    private Integer bookId;
    private Date issuedDate;
    private Date returnDate;
    private int numberOfTimesIssued;
    private User userByUserId;
    private Book bookByBookId;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "userbook_generator")
    @SequenceGenerator(name = "userbook_generator", sequenceName = "USER_BOOK_SEQUENCE")
    @Column(name = "User_Book_Id", updatable = false, nullable = false)
    public int getUserBookId() {
        return userBookId;
    }

    public void setUserBookId(int userBookId) {
        this.userBookId = userBookId;
    }

    @Basic
    @Column(name = "User_Id", insertable = false, updatable = false, nullable = true)
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "Book_Id", insertable = false, updatable = false, nullable = true)
    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    @Basic
    @Column(name = "Issued_Date", nullable = false)
    public Date getIssuedDate() {
        return issuedDate;
    }

    public void setIssuedDate(Date issuedDate) {
        this.issuedDate = issuedDate;
    }

    @Basic
    @Column(name = "Return_Date", nullable = false)
    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    @Basic
    @Column(name = "Number_Of_Times_Issued", nullable = false)
    public int getNumberOfTimesIssued() {
        return numberOfTimesIssued;
    }

    public void setNumberOfTimesIssued(int numberOfTimesIssued) {
        this.numberOfTimesIssued = numberOfTimesIssued;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserBook userBook = (UserBook) o;
        return userBookId == userBook.userBookId &&
                numberOfTimesIssued == userBook.numberOfTimesIssued &&
                Objects.equals(userId, userBook.userId) &&
                Objects.equals(bookId, userBook.bookId) &&
                Objects.equals(issuedDate, userBook.issuedDate) &&
                Objects.equals(returnDate, userBook.returnDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userBookId, userId, bookId, issuedDate, returnDate, numberOfTimesIssued);
    }

    @ManyToOne
    @JoinColumn(name = "User_Id", referencedColumnName = "User_Id")
    public User getUserByUserId() {
        return userByUserId;
    }

    public void setUserByUserId(User userByUserId) {
        this.userByUserId = userByUserId;
    }

    @ManyToOne
    @JoinColumn(name = "Book_Id", referencedColumnName = "Book_Id")
    public Book getBookByBookId() {
        return bookByBookId;
    }

    public void setBookByBookId(Book bookByBookId) {
        this.bookByBookId = bookByBookId;
    }
}
