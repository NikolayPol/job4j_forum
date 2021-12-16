package ru.job4j.forum.model;

import lombok.*;

import java.util.Objects;

/**
 * Класс User - пользоватль.
 *
 * @author Nikolay Polegaev
 * @version 1.0 16.12.2021
 */
@Builder
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private int id;
    private String name;

    public static User of(String name) {
        User post = new User();
        post.name = name;
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
        User user = (User) o;
        return id == user.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
