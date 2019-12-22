package com.library.librarydatastore.repositories;


import com.library.librarydatastore.entities.Publisher;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public interface PublisherRepository extends CrudRepository<Publisher, Integer> {

}
