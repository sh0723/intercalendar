package com.ssu.intercalendar.user.domain;

import com.ssu.intercalendar.user.enumerate.Role;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor

public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;
    private String username;
    private String password;


    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"))
    @Enumerated(EnumType.STRING)
    private Collection<Role> roles = new HashSet<>();

    public User addRole(Role role) {
        this.roles.add(role);
        return this;
    }
    @Builder
    public User(String email, String username, String password) {
        this.email = email;
        this.username = username;
        this.password = password;

    }

    public Object getRole() {
        return roles;
    }
}


