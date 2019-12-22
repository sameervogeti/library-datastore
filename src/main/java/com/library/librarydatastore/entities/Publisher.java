package com.library.librarydatastore.entities;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "PUBLISHER")
public class Publisher {
    private int publisherId;
    private String name;
    private String emailId;
    private String phoneNumber;
    private Collection<Book> booksByPublisherId;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "publisher_generator")
    @SequenceGenerator(name = "publisher_generator", sequenceName = "PUBLISHER_SEQUENCE")
    @Column(name = "Publisher_Id", updatable = false, nullable = false)
    public int getPublisherId() {
        return publisherId;
    }

    public void setPublisherId(int publisherId) {
        this.publisherId = publisherId;
    }

    @Basic
    @Column(name = "Name", nullable = false, length = 50)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "Email_Id", nullable = true, length = 50)
    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    @Basic
    @Column(name = "Phone_Number", nullable = true, length = 11)
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Publisher publisher = (Publisher) o;
        return publisherId == publisher.publisherId &&
                Objects.equals(name, publisher.name) &&
                Objects.equals(emailId, publisher.emailId) &&
                Objects.equals(phoneNumber, publisher.phoneNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(publisherId, name, emailId, phoneNumber);
    }

    @OneToMany(mappedBy = "publisherByPublisherId")
    public Collection<Book> getBooksByPublisherId() {
        return booksByPublisherId;
    }

    public void setBooksByPublisherId(Collection<Book> booksByPublisherId) {
        this.booksByPublisherId = booksByPublisherId;
    }
}
