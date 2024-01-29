package ru.julie.homeTask.services;

import org.springframework.stereotype.Service;
import ru.julie.homeTask.domain.User;

@Service
public class NotificationService {
    public void notifyUser(User user) {
        System.out.println("A new user has been created: " + user.getName());
    }

    public void sendNotification(String s) {
        System.out.println(s);
    }
}
