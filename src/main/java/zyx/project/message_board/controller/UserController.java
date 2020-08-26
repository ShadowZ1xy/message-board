package zyx.project.message_board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import zyx.project.message_board.entity.WebUser;
import zyx.project.message_board.entity.WebUserRole;
import zyx.project.message_board.service.WebUserService;

import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController {
    private final WebUserService userService;

    public UserController(WebUserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String userList(Model model) {
        Iterable<WebUser> users = userService.getAllUsers();
        model.addAttribute("users", users);
        return "userList";
    }

    @GetMapping("{user}")
    public String userEdit(@PathVariable WebUser user, Model model) {
        model.addAttribute("user", user);
        model.addAttribute("roles", WebUserRole.values());
        return "userEdit";
    }

    @PostMapping("saveUser")
    public String saveUser(@RequestParam WebUser user,
                           @RequestParam String username,
                           @RequestParam Map<String, String> form,
                           Model model) {
        userService.saveUser(user, username, form);
        return "userEdit";
    }
}
