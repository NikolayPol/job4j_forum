package ru.job4j.forum.control;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ru.job4j.forum.model.User;
import ru.job4j.forum.service.AuthorityService;
import ru.job4j.forum.service.UserService;

/**
 * Класс RegControl - контроллер для регистрации.
 *
 * @author Nikolay Polegaev
 * @version 1.0 15.12.2021
 */
@Controller
@AllArgsConstructor
public class RegControl {
    private final UserService userService;
    private final AuthorityService authorityService;

    @PostMapping("/reg")
    public String regSave(@ModelAttribute User user, Model model) {
        userService.save(user);
        return "redirect:/login";
    }

    @GetMapping("/reg")
    public String regPage() {
        return "reg";
    }
}
