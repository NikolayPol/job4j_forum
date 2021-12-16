package ru.job4j.forum.control;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.job4j.forum.service.PostService;

/**
 * Класс IndexControl - контроллер для стартовой страницы.
 * Отображает записи форума.
 *
 * @author Nikolay Polegaev
 * @version 1.0 16.12.2021
 */
@Controller
public class IndexControl {
    private final PostService posts;

    public IndexControl(PostService posts) {
        this.posts = posts;
    }

    @GetMapping({"/", "/index"})
    public String index(Model model) {
        model.addAttribute("posts", posts.getAll());
        return "index";
    }
}
