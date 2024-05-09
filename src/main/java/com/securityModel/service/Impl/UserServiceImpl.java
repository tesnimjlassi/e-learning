package com.securityModel.service.Impl;

import com.securityModel.models.User;
import com.securityModel.repository.UserRepository;
import com.securityModel.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public User createuser(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> allUsers() {
        return userRepository.findAll();
    }

    @Override
    public User userById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new RuntimeException("user not found "));

    }

    @Override
    public User updateuser(Long id, User user) {
        User use=userRepository.findById(id).orElseThrow(null);
        if (use!= null){
            user.setId(id);
            return userRepository.save(user);
        }else {
            throw new RuntimeException("Error");
        }
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);

    }
}
