package com.spring.task.new_dw.service;

import com.spring.task.new_dw.entity.User;
import com.spring.task.new_dw.exception.UserNotFoundException;
import com.spring.task.new_dw.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public void addUser(User user) {
        userRepository.save(user);
    }

    public void updateUser(User userForUpdate) {
        String login = userForUpdate.getLogin();
        User user = userRepository.findByLogin(login);
        if (user == null) {
            throw new UserNotFoundException("User with login: " + login + " not found");
        }
        // нет проверки на пустое и нул, так как
        // в форме-заполнения на сайте заранее нет возможности передать пустое знаечение
        // изменять можно - логин, пароль, Фамилию, Имя, Отчество, пол
        // надо реализовать провекру на изменение логина, чтобы такого же не было в базе
        user.setLogin(userForUpdate.getLogin());
        user.setPassword(userForUpdate.getPassword());
        user.setLastName(userForUpdate.getLastName());
        user.setFirstName(userForUpdate.getFirstName());
        user.setPatronymic(userForUpdate.getPatronymic());
        user.setGender(userForUpdate.getGender());

        userRepository.save(userForUpdate);
    }

    public void deleteUser(User user) {

        if (userRepository.findByLogin(user.getLogin()) == null) {
            throw new UserNotFoundException("User with login: " + user.getLogin() + " not found");
        }

        userRepository.delete(user);
    }
}
