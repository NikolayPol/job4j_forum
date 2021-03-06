package ru.job4j.forum.model;

import lombok.*;

import javax.persistence.*;
import java.util.Objects;

/**
 * Класс User - пользоватль.
 *
 * @author Nikolay Polegaev
 * @version 1.0 16.12.2021
 */
@Entity
@Table(name = "users")
@Builder
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String password;

    private String username;

    @ManyToOne
    @JoinColumn(name = "authority_id")
    private Authority authority;

    private boolean enabled;

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
