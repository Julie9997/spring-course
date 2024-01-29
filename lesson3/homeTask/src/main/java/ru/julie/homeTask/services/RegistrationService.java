package ru.julie.homeTask.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import ru.julie.homeTask.domain.User;

@Service
public class RegistrationService {

    @Autowired
    private UserService userService;

    @Autowired
    private DataProcessingService dataProcessingService;

    @Autowired
    private NotificationService notificationService;

    public DataProcessingService getDataProcessingService() {
        return dataProcessingService;
    }

    public void processRegistration(User user) {
        userService.createUser(user.getName(), user.getAge(), user.getEmail());
    }

}