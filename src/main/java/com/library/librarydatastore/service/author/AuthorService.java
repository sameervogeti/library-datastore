package com.library.librarydatastore.service.author;

import com.library.librarydatastore.entities.Author;
import com.library.librarydatastore.model.request.AuthorRequest;

public interface AuthorService {
    Author findAuthorById(Integer authorId);

    Integer addAuthor(AuthorRequest authorRequest);

    void deleteAuthor(Integer authorId);

    Integer updateAuthor(AuthorRequest authorRequest);

}
