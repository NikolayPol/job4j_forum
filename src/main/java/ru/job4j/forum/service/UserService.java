package ru.job4j.forum.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.job4j.forum.model.User;
import ru.job4j.forum.store.AuthorityRepository;
import ru.job4j.forum.store.UserRepository;

import java.util.List;

/**
 * Класс UserService
 *
 * @author Nikolay Polegaev
 * @version 1.0 16.12.2021
 */
@Service
public class UserService {
    @Autowired
    private PasswordEncoder encoder;
    @Autowired
    private AuthorityRepository authorities;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserService userService;

    public List<User> getAll() {
        return userRepository.findAll();
    }

    public User findById(int id) {
        return userRepository.findById(id).get();
    }

    public void save(User user) {
        userRepository.save(user);
    }

    public User findUserByName(User user) {
        return userRepository.findByUsername(user.getUsername());
    }
}
