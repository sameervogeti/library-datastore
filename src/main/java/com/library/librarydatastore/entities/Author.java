package com.library.librarydatastore.entities;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "AUTHOR")
public class Author {
    private int authorId;
    private String firstName;
    private String lastName;
    private Date dateOfBirth;
    private String gender;
    private Collection<BookAuthor> bookAuthorsByAuthorId;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "author_generator")
    @SequenceGenerator(name = "author_generator", sequenceName = "AUTHOR_SEQUENCE")
    @Column(name = "Author_Id", updatable = false, nullable = false)
    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    @Basic
    @Column(name = "First_Name", nullable = false, length = 50)
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Basic
    @Column(name = "Last_Name", nullable = false, length = 50)
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Basic
    @Column(name = "Date_Of_Birth", nullable = false)
    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    @Basic
    @Column(name = "Gender", nullable = false)
    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Author author = (Author) o;
        return authorId == author.authorId &&
                Objects.equals(firstName, author.firstName) &&
                Objects.equals(lastName, author.lastName) &&
                Objects.equals(dateOfBirth, author.dateOfBirth) &&
                Objects.equals(gender, author.gender);
    }

    @Override
    public int hashCode() {
        return Objects.hash(authorId, firstName, lastName, dateOfBirth, gender);
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "bookAuthorId.author")
    public Collection<BookAuthor> getBookAuthorsByAuthorId() {
        return bookAuthorsByAuthorId;
    }

    public void setBookAuthorsByAuthorId(Collection<BookAuthor> bookAuthorsByAuthorId) {
        this.bookAuthorsByAuthorId = bookAuthorsByAuthorId;
    }
}
