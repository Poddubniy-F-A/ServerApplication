package ru.gb.example3_sem3_hometask.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.gb.example3_sem3_hometask.domain.User;
import ru.gb.example3_sem3_hometask.services.additional_services.DataProcessingService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {
    @Autowired
    private DataProcessingService service;

    @GetMapping
    public static List<String> getAllTasks() {
        return new ArrayList<>(Arrays.asList("sort", "filter", "calc"));
    }

    @GetMapping("/sort")
    public List<User> sortUsersByAge() {
        return service.getSortedByAgeUsers();
    }

    @GetMapping("/filter/{age}")
    public List<User> filterUsersByAge(@PathVariable("age") int age) {
        return service.getFilteredByAgeUsers(age);
    }

    @GetMapping("/filter/calc")
    public double calculateAverageAge() {
        return service.getAverageAge();
    }
}
