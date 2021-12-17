package ru.job4j.forum.model;

import lombok.*;

import javax.persistence.*;
import java.util.Objects;

/**
 * Класс Authority
 *
 * @author Nikolay Polegaev
 * @version 1.0 17.12.2021
 */
@Entity
@Table(name = "authorities")
@Builder
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Authority {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String authority;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Authority authority = (Authority) o;
        return id == authority.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}