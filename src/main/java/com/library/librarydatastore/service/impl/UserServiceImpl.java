package com.library.librarydatastore.service.impl;

import com.library.librarydatastore.entities.User;
import com.library.librarydatastore.model.request.UserRequest;
import com.library.librarydatastore.service.user.UserService;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserServiceImpl implements UserService {
    @Override
    public Integer addUser(UserRequest userRequest) {
        return null;
    }

    @Override
    public User findUserById(Integer userId) {
        return null;
    }

    @Override
    public User updateUser(UserRequest userRequest) {
        return null;
    }

    @Override
    public void deleteUser(Integer userId) {

    }

    @Override
    public List<User> findAllUsers(UserRequest userRequest) {
        return null;
    }

    @Override
    public Integer issueBookToUser(UserRequest userRequest) {
        return null;
    }

    @Override
    public void returnBookfromUser(UserRequest userRequest) {

    }
}
