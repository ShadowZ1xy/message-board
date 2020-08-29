package zyx.project.message_board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import zyx.project.message_board.entity.Message;
import zyx.project.message_board.service.MessageService;

import java.util.Collection;
import java.util.stream.Collectors;

@Controller
public class HomeController {
    private final MessageService messageService;

    public HomeController(MessageService messageService) {
        this.messageService = messageService;
    }

    @GetMapping("/")
    public String homePage(Model model) {
        Collection<Message> messages = (Collection<Message>) messageService.getAll();
        messages = messages.stream()
                .limit(3)
                .collect(Collectors.toList());
        model.addAttribute("messages", messages);
        return "home";
    }
}
