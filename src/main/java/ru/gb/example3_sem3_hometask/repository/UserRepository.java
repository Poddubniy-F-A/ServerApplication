package ru.gb.example3_sem3_hometask.repository;

import org.springframework.stereotype.Repository;
import ru.gb.example3_sem3_hometask.domain.User;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository {
    private final List<User> users = new ArrayList<>();

    public List<User> getUsers() {
        return users;
    }

    public void add(User user) {
        users.add(user);
    }
}
