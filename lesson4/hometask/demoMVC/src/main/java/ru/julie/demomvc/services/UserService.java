package ru.julie.demomvc.services;

import org.springframework.stereotype.Service;
import ru.julie.demomvc.models.User;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    List<User> users = new ArrayList<>();

    public void addUser(User user) {
        users.add(user);
    }

    public List<User> getAllUsers() {
        return users;
    }
}
