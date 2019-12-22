package com.library.librarydatastore.model.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.library.librarydatastore.entities.Book;
import lombok.Data;

import java.util.Collection;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class PublisherRequest {

    private Integer publisherId;
    private String name;
    private String emailId;
    private String phoneNumber;
    private Collection<Book> booksByPublisherId;
}
