package com.library.librarydatastore.service.book;

import com.library.librarydatastore.entities.Book;
import com.library.librarydatastore.model.request.BookRequest;

public interface BookService {
     Integer addBook(BookRequest bookRequest);

     Book findBookById(Integer bookId);

     Integer updateBook(BookRequest bookRequest);

     void deleteBook(Integer bookId);

     Integer updateAuthorsOfBook(BookRequest bookRequest);


}
