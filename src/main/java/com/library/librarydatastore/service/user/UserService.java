package com.library.librarydatastore.service.user;

import com.library.librarydatastore.entities.User;
import com.library.librarydatastore.model.request.UserRequest;

import java.util.List;

public interface UserService {
    Integer addUser(UserRequest userRequest);

    User findUserById(Integer userId);

    User updateUser(UserRequest userRequest);

    void deleteUser(Integer userId);

    List<User> findAllUsers(UserRequest userRequest);

    Integer issueBookToUser(UserRequest userRequest);

    void returnBookfromUser(UserRequest userRequest);

}
