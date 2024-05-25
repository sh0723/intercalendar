package com.ssu.intercalendar.user.domain;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor

public class User {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String userName;
    private String password;
    private String email;

    @Builder
    public User(String userName, String password, String email){
        this.userName = userName;
        this.password = password;
        this.email = email;
    }

    public void updatePassword(String userName, String password, String email) {
        this.userName = userName;
        this.password = password;
        this.email = email;
    }
}
