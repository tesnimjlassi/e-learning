package com.securityModel.service;

import com.securityModel.models.User;

import java.util.List;

public interface UserService {
    User createuser(User user);
    List<User> allUsers();
    User userById(Long id);
    User updateuser(Long id,User user);
    void deleteUser(Long id);
}
