package ru.gb.example3_sem3_hometask.services.additional_services;

import org.springframework.stereotype.Service;
import ru.gb.example3_sem3_hometask.domain.User;

@Service
public class NotificationService {
    public void notifyAboutUserCreating(User user) {
        System.out.println("A new user has been created: " + user);
    }
}
