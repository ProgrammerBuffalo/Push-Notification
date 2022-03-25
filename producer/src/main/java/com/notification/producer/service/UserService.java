package com.notification.producer.service;

import com.notification.producer.exception.NotFoundException;
import com.notification.producer.model.entity.User;
import com.notification.producer.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private IUserRepository userRepository;

    public User register(User user) {
        return userRepository.save(user);
    }

    public User find(String uuid) throws NotFoundException {
        return userRepository.findById(uuid)
                .orElseThrow(() -> new NotFoundException("User not found"));
    }

    public void delete(User user) {
        userRepository.delete(user);
    }
}
