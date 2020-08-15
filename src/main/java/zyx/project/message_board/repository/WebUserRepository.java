package zyx.project.message_board.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import zyx.project.message_board.entity.WebUser;

public interface WebUserRepository extends JpaRepository<WebUser, Long> {
    WebUser findByUsername(String username);
}
