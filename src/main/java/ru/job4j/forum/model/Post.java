package ru.job4j.forum.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

/**
 * Класс Post - объявление.
 *
 * @author Nikolay Polegaev
 * @version 1.1 17.12.2021
 */
@Entity
@Table(name = "posts")
@Builder
@Setter
@Getter
@AllArgsConstructor
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String description;
    private LocalDateTime created;

    public Post() {
        this.created = LocalDateTime.now();
    }

    public static Post of(String name) {
        Post post = new Post();
        post.name = name;
        post.created = LocalDateTime.now();
        return post;
    }

    public static Post of(int id, String name, String description) {
        Post post = new Post();
        post.id = id;
        post.name = name;
        post.description = description;
        post.created = LocalDateTime.now();
        return post;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Post post = (Post) o;
        return id == post.id
                && Objects.equals(name, post.name)
                && Objects.equals(description, post.description)
                && Objects.equals(created, post.created);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, created);
    }
}
