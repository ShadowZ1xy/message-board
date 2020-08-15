package zyx.project.message_board.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import zyx.project.message_board.entity.Message;

public interface MessageRepository extends JpaRepository<Message, Long> {
    Iterable<Message> findByTag(String tag);

    Iterable<Message> findByAuthor_UsernameOrTagOrTextContainsOrId(String author_username, String tag, String text, Long id);
}
