package ru.job4j.forum.service;

import org.springframework.stereotype.Service;
import ru.job4j.forum.model.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Класс UserService
 *
 * @author Nikolay Polegaev
 * @version 1.0 16.12.2021
 */
@Service
public class UserService {
    private final List<User> posts = new ArrayList<>();

    public UserService() {
        posts.add(User.of("User 1"));
    }

    public List<User> getAll() {
        return posts;
    }

    public User findById(int id) {
        return posts.get(id);
    }

    public void save(User post) {
        posts.add(post);
    }
}
