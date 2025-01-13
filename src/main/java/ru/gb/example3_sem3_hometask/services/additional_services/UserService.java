package ru.gb.example3_sem3_hometask.services.additional_services;

import org.springframework.stereotype.Service;
import ru.gb.example3_sem3_hometask.domain.User;

@Service
public class UserService {
    public User createUser(String name, String email, int age) {
        User user = new User();
        user.setName(name);
        user.setEmail(email);
        user.setAge(age);
        return user;
    }
}
