package ru.gb.example3_sem3_hometask.services.additional_services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.gb.example3_sem3_hometask.domain.User;
import ru.gb.example3_sem3_hometask.repository.UserRepository;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DataProcessingService {
    @Autowired
    private UserRepository repository;

    public void addUserToRepository(User user) {
        repository.add(user);
    }

    public List<User> getSortedByAgeUsers() {
        return getUsers().stream()
                .sorted(Comparator.comparing(User::getAge))
                .collect(Collectors.toList());
    }

    public List<User> getFilteredByAgeUsers(int age) {
        return getUsers().stream()
                .filter(user -> user.getAge() > age)
                .collect(Collectors.toList());
    }

    public double getAverageAge() {
        return getUsers().stream()
                .mapToInt(User::getAge)
                .average()
                .orElse(0);
    }

    public List<User> getUsers() {
        return repository.getUsers();
    }
}
