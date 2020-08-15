package zyx.project.message_board.service;

import org.springframework.stereotype.Service;
import zyx.project.message_board.entity.Message;
import zyx.project.message_board.entity.WebUser;
import zyx.project.message_board.repository.MessageRepository;

@Service
public class MessageService {
    private final MessageRepository messageRepository;

    public MessageService(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }


    public Iterable<Message> getAll() {
        return messageRepository.findAll();
    }

    public boolean addMessage(Message message, WebUser user) {
        message.setAuthor(user);
        messageRepository.save(message);
        return true;
    }

    public Iterable<Message> findByTag(String filter) {
        return messageRepository.findByTag(filter);
    }
}
