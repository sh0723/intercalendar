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


    private String username;
    private String password;



    @Builder
    public User(String username, String password){
        this.username = username;
        this.password = password;
    }


    public void updatePassword(String password) {
        this.password = password;
    }


}
