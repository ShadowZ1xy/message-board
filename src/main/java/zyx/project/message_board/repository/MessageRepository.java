package zyx.project.message_board.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import zyx.project.message_board.entity.Message;

public interface MessageRepository extends JpaRepository<Message, Long> {
    @Query(value = "SELECT * FROM message as m WHERE " +
            "(?1 IS NULL OR m.text LIKE %?1%) AND " +
            "(?2 IS NULL OR m.tag LIKE %?2%) AND " +
            "(?3 IS NULL OR m.message_id = ?3) ORDER BY m.message_id DESC",
            nativeQuery = true)
    Iterable<Message> findByManyParams(String text,
                                       String tag,
                                       Long id
    );

    Iterable<Message> findAllByOrderByIdDesc();
}
