package ru.gb.example3_sem3_hometask.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.gb.example3_sem3_hometask.services.RegistrationService;
import ru.gb.example3_sem3_hometask.domain.User;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private RegistrationService service;

    @GetMapping
    public List<User> userList() {
        return service.getUsersList();
    }

    @PostMapping("/body")
    public String userAddFromBody(@RequestBody Map<String, Object> request) {
        service.processRegistration(
                (String) request.get("name"),
                (String) request.get("email"),
                (Integer) request.get("age")
        );
        return "User added from body!";
    }
}
