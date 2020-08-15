package zyx.project.message_board.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import zyx.project.message_board.entity.WebUser;
import zyx.project.message_board.entity.WebUserRole;
import zyx.project.message_board.repository.WebUserRepository;

import java.util.Collections;

@Service
public class WebUserService implements UserDetailsService {
    private final WebUserRepository webUserRepository;

    public WebUserService(WebUserRepository webUserRepository) {
        this.webUserRepository = webUserRepository;
    }

    public boolean addUser(WebUser user) {
        WebUser userFromDatabase = webUserRepository.findByUsername(user.getUsername());
        if (userFromDatabase != null) {
            return false;
        }
        user.setActive(true);
        user.setRoles(Collections.singleton(WebUserRole.USER));
        webUserRepository.save(user);
        return true;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return webUserRepository.findByUsername(username);
    }
}
