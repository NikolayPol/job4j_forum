package ru.job4j.forum.service;

import org.springframework.stereotype.Service;
import ru.job4j.forum.model.Post;

import java.util.ArrayList;
import java.util.List;

/**
 * Класс PostService
 *
 * @author Nikolay Polegaev
 * @version 1.0 16.12.2021
 */
@Service
public class PostService {

    private final List<Post> posts = new ArrayList<>();

    public PostService() {
        posts.add(Post.of(0, "Продаю машину", "Продаю машину ладу 01."));
        posts.add(Post.of(1, "Продаю машину", "Продаю машину BMW."));
        posts.add(Post.of(2, "Продаю машину", "Продаю машину AUDI."));

    }

    public List<Post> getAll() {
        return posts;
    }

    public Post findById(int id) {
        return posts.get(id);
    }

    public void saveOrUpdate(Post post) {
        if (post.getId() == 0) {
            post.setId(posts.size());
            posts.add(post);
        } else {
            posts.set(post.getId(), post);
        }
    }

    public void delete(int id) {
        posts.remove(id);
    }
}
