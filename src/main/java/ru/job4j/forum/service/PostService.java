package ru.job4j.forum.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.job4j.forum.model.Post;
import ru.job4j.forum.store.PostRepository;

import java.util.ArrayList;
import java.util.List;

/**
 * Класс PostService
 *
 * @author Nikolay Polegaev
 * @version 2.0 17.12.2021
 */
@Service
@AllArgsConstructor
public class PostService {

    private final PostRepository posts;

    public List<Post> getAll() {
        List<Post> rsl = new ArrayList<>();
        posts.findAll().forEach(rsl::add);
        return rsl;
    }

    public Post findById(int id) {
        return posts.findById(id).get();
    }

    public void saveOrUpdate(Post post) {
        posts.save(post);
    }

    public void delete(int id) {
        posts.delete(posts.findById(id).get());
    }
}
