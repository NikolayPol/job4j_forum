package ru.job4j.forum.control;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ru.job4j.forum.model.User;
import ru.job4j.forum.service.AuthorityService;
import ru.job4j.forum.service.UserService;
import ru.job4j.forum.store.AuthorityRepository;

/**
 * Класс RegControl - контроллер для регистрации.
 *
 * @author Nikolay Polegaev
 * @version 1.1 17.12.2021
 */
@Controller
public class RegControl {
    @Autowired
    private PasswordEncoder encoder;

    @Autowired
    private UserService userService;

    @Autowired
    private AuthorityRepository authorities;

    @PostMapping("/reg")
    public String regSave(@ModelAttribute User user, Model model) {
        User userRegistered = userService.findUserByName(user);
        if (userRegistered != null && user.getUsername().equals(userRegistered.getUsername())) {
            model.addAttribute("userRegistered", userRegistered);
            return "reg";
        } else {
            user.setEnabled(true);
            user.setPassword(encoder.encode(user.getPassword()));
            user.setAuthority(authorities.findByAuthority("ROLE_USER"));
            userService.save(user);
            return "redirect:/login";
        }
    }

    @GetMapping("/reg")
    public String regPage() {
        return "reg";
    }
}
