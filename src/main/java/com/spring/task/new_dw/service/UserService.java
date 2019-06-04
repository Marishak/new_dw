package com.spring.task.new_dw.service;

import com.spring.task.new_dw.entity.User;
import com.spring.task.new_dw.entity.enums.Role;
import com.spring.task.new_dw.exception.BadRequestException;
import com.spring.task.new_dw.exception.UserNotFoundException;
import com.spring.task.new_dw.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    public User getUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User with id : " + id + " doesn't exist"));
    }

    public void addUser(User user) {
        String login = user.getUsername();
        if (userRepository.findByUsername(login) != null) {
            throw new BadRequestException("Login with name " + login + " already exist");
        }
        user.setRoles(Collections.singleton(Role.USER));
        user.setActive(true);
        userRepository.save(user);
    }

    public void updateUser(User updatedUser) {
        User userFromDB = userRepository.findById(updatedUser.getId())
                .orElseThrow(() -> new UserNotFoundException("User with id : " + updatedUser.getId() + " doesn't exist"));

        String login = updatedUser.getUsername();
        if (login != null && !login.isEmpty() && !login.equals(userFromDB.getUsername())) {
            if (userRepository.findByUsername(login) != null) {
                throw new BadRequestException("Login with name " + login + " already exist");
            }

            userFromDB.setUsername(login);
        }
        if (updatedUser.getPassword() != null) {
            userFromDB.setPassword(updatedUser.getPassword());
        }
        if (updatedUser.getFirstName() != null && !updatedUser.getFirstName().isEmpty()) {
            userFromDB.setFirstName(updatedUser.getFirstName());
        }
        if (updatedUser.getLastName() != null && !updatedUser.getLastName().isEmpty()) {
            userFromDB.setLastName(updatedUser.getLastName());
        }
        if (updatedUser.getPatronymic() != null && !updatedUser.getPatronymic().isEmpty()) {
            userFromDB.setPatronymic(updatedUser.getPatronymic());
        }
        if (updatedUser.getGender() != null) {
            userFromDB.setGender(updatedUser.getGender());
        }

        userRepository.save(updatedUser);
    }

    public void deleteUserById(Long id) {
        try {
            userRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new UserNotFoundException("User with id : " + id + " doesn't exist");
        }

    }

}
