package ru.job4j.forum.store;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.job4j.forum.model.User;

/**
 * Класс UserRepository
 *
 * @author Nikolay Polegaev
 * @version 1.0 17.12.2021
 */
public interface UserRepository extends JpaRepository<User, Integer> {
    User findByUsername(String username);
}
