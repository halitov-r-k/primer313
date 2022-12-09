package ru.kata.spring.boot_security.demo.servise;


import ru.kata.spring.boot_security.demo.model.User;

import java.util.List;

public interface UserServise {

    List<User> getAllUser();

    void add(User user);

    User getUser(Long id);

    void deleteUser(Long id);

    User findByUser(String name);


}
