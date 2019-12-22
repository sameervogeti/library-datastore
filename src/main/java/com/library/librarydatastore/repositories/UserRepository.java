package com.library.librarydatastore.repositories;

import com.library.librarydatastore.entities.User;
import com.library.librarydatastore.model.request.UserRequest;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Integer> {
    Integer addUser(UserRequest userRequest);

    User findUserById(Integer userId);

    User updateUser(UserRequest userRequest);

    void deleteUser(Integer userId);

    List<User> findAllUsers(UserRequest userRequest);

    Integer issueBookToUser(UserRequest userRequest);
}
