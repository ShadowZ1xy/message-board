package zyx.project.message_board.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import zyx.project.message_board.entity.Message;
import zyx.project.message_board.entity.WebUser;
import zyx.project.message_board.service.MessageService;

@Controller
public class MessageBoardController {

    private final MessageService messageService;

    public MessageBoardController(MessageService messageService) {
        this.messageService = messageService;
    }


    @GetMapping("/board")
    public String boardPage(Model model) {
        Iterable<Message> messages = messageService.getAll();
        model.addAttribute("messages", messages);
        return "board";
    }

    @PostMapping("newMessage")
    public String newMessage(@AuthenticationPrincipal WebUser user,
                             Message message,
                             Model model) {
        messageService.addMessage(message, user);
        return boardPage(model);
    }

    @PostMapping("filterMessages")
    public String filterMessages(Message message,
                                 Model model) {
        if (messageService.checkMessageIsEmpty(message)) {
            return boardPage(model);
        }
        Iterable<Message> messages = messageService.findByManyParams(
                message.getText(),
                message.getTag(),
                message.getId()
        );
        model.addAttribute("messages", messages);
        return "board";
    }
}
