package ru.job4j.forum.store;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.job4j.forum.model.Post;

/**
 * Класс PostRepository
 *
 * @author Nikolay Polegaev
 * @version 1.0 17.12.2021
 */
public interface PostRepository extends JpaRepository<Post, Integer> {
}
