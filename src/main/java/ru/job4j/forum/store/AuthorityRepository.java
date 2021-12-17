package ru.job4j.forum.store;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.job4j.forum.model.Authority;

/**
 * Класс AuthorityRepository
 *
 * @author Nikolay Polegaev
 * @version 1.0 17.12.2021
 */
public interface AuthorityRepository extends JpaRepository<Authority, Integer> {
    Authority findByAuthority(String authority);
}
