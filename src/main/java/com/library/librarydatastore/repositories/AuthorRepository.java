package com.library.librarydatastore.repositories;

import com.library.librarydatastore.entities.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Integer> {
}
