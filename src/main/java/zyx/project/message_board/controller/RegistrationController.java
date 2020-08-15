package zyx.project.message_board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import zyx.project.message_board.entity.WebUser;
import zyx.project.message_board.service.WebUserService;

@Controller
public class RegistrationController {
    private final WebUserService userService;

    public RegistrationController(WebUserService userService) {
        this.userService = userService;
    }

    @GetMapping("/registration")
    public String registration(Model model) {
        return "registration";
    }

    @PostMapping("/registration")
    public String newUser(WebUser user, Model model) {
        if (userService.addUser(user)) {
            model.addAttribute("ok", "ok");
            return "login";
        } else {
            model.addAttribute("warning", "warning");
            return "registration";
        }
    }
}
