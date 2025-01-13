package ru.gb.example3_sem3_hometask.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.gb.example3_sem3_hometask.domain.User;
import ru.gb.example3_sem3_hometask.services.additional_services.*;

import java.util.List;

@Service
public class RegistrationService {
    @Autowired
    private DataProcessingService dataProcessingService;

    @Autowired
    private UserService userService;

    @Autowired
    private NotificationService notificationService;

    public List<User> getUsersList() {
        return dataProcessingService.getUsers();
    }

    public void processRegistration(String name, String email, int age) {
        User user = userService.createUser(name, email, age);
        dataProcessingService.addUserToRepository(user);
        notificationService.notifyAboutUserCreating(user);
    }
}
