package com.library.librarydatastore.repositories;

import com.library.librarydatastore.entities.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Integer> {
}
