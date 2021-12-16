package ru.job4j.forum.control;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.job4j.forum.model.Post;
import ru.job4j.forum.service.PostService;

import java.time.LocalDateTime;

/**
 * Класс PostController - контроллер для crud записей.
 *
 * @author Nikolay Polegaev
 * @version 1.0 16.12.2021
 */
@Controller
@AllArgsConstructor
public class PostControl {
    private final PostService postService;

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("post", Post.builder().created(LocalDateTime.now()).build());
        return "post";
    }

    @GetMapping("/update")
    public String update(@RequestParam("id") int id, Model model) {
        model.addAttribute("post", postService.findById(id));
        return "edit";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("id") int id) {
        postService.delete(id);
        return "redirect:/index";
    }

    @PostMapping("/saveOrUpdate")
    public String saveOrUpdate(@ModelAttribute Post post) {
        if (post.getCreated() == null) {
            post.setCreated(LocalDateTime.now());
        }
        postService.saveOrUpdate(post);
        return "redirect:/index";
    }
}
