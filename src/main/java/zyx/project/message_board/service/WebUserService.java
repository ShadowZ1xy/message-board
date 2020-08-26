package zyx.project.message_board.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import zyx.project.message_board.entity.WebUser;
import zyx.project.message_board.entity.WebUserRole;
import zyx.project.message_board.repository.WebUserRepository;

import java.util.Arrays;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

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

    public Iterable<WebUser> getAllUsers() {
        return webUserRepository.findAll();
    }

    public void saveUser(WebUser user, String username, Map<String, String> form) {
        user.setUsername(username);
        Set<String> roles = Arrays.stream(WebUserRole.values())
                .map(WebUserRole::name)
                .collect(Collectors.toSet());
        user.getRoles().clear();
        for (String key : form.keySet()) {
            if (roles.contains(key)) {
                user.getRoles().add(WebUserRole.valueOf(key));
            }
        }
        webUserRepository.save(user);

    }
}
