package zyx.project.message_board.entity;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import java.util.Collection;
import java.util.Set;

@Entity
public class WebUser implements UserDetails {
    @Id
    @GeneratedValue()
    @Column(name = "webuser_id")
    private Long id;

    private String username;
    private String password;

    private boolean isActive;

    @ElementCollection(targetClass = WebUserRole.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "webuser_role", joinColumns = @JoinColumn(name = "webuser_id"))
    @Enumerated(EnumType.STRING)
    private Set<WebUserRole> roles;

    public WebUser() {
    }

    public WebUser(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return this.isActive();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.getRoles();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public Set<WebUserRole> getRoles() {
        return roles;
    }

    public void setRoles(Set<WebUserRole> roles) {
        this.roles = roles;
    }
}
