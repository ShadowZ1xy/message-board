package zyx.project.message_board.entity;

import org.springframework.security.core.GrantedAuthority;

public enum WebUserRole implements GrantedAuthority {
    USER,
    ADMIN,
    MODERATOR;

    @Override
    public String getAuthority() {
        return name();
    }
}
