package ru.julie.crudremaster.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.julie.crudremaster.models.User;
import ru.julie.crudremaster.repositories.UserRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public void deleteById(int id) {
        userRepository.deleteById(id);
    }

    public User getUserById(int id) {
        return userRepository.getUserById(id);
    }

    public User update(User user) {
        return userRepository.update(user);
    }

}