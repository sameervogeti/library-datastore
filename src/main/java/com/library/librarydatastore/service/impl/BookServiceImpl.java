package com.library.librarydatastore.service.impl;

import com.library.librarydatastore.entities.Book;
import com.library.librarydatastore.model.request.BookRequest;
import com.library.librarydatastore.service.book.BookService;

public class BookServiceImpl implements BookService {
    @Override
    public Integer addBook(BookRequest bookRequest) {
        return null;
    }

    @Override
    public Book findBookById(Integer bookId) {
        return null;
    }

    @Override
    public Integer updateBook(BookRequest bookRequest) {
        return null;
    }

    @Override
    public void deleteBook(Integer bookId) {

    }

    @Override
    public Integer updateAuthorsOfBook(BookRequest bookRequest) {
        return null;
    }
}
