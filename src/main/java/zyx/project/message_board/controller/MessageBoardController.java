package zyx.project.message_board.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import zyx.project.message_board.entity.Message;
import zyx.project.message_board.entity.WebUser;
import zyx.project.message_board.service.MessageService;

import java.util.Collections;
import java.util.List;

@Controller
public class MessageBoardController {

    private final MessageService messageService;

    public MessageBoardController(MessageService messageService) {
        this.messageService = messageService;
    }


    @GetMapping("/board")
    public String homePage(Model model) {
        Iterable<Message> messages = messageService.getAll();
        Collections.reverse((List<?>) messages);
        model.addAttribute("messages", messages);
        return "board";
    }

    @PostMapping("newMessage")
    public String newMessage(@AuthenticationPrincipal WebUser user,
                             Message message,
                             Model model) {
        messageService.addMessage(message, user);
        return homePage(model);
    }

    @PostMapping("filterMessages")
    public String filterMessages(String filter, Model model) {
        if (filter == null || filter.isEmpty()) {
            return homePage(model);
        }
        Iterable<Message> messages = messageService.findByTag(filter);
        model.addAttribute("messages", messages);
        return "board";
    }
}
