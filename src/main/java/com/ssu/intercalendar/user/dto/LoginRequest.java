package com.ssu.intercalendar.user.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor @Getter @Setter
public class LoginRequest {
    private String username;
    private String password;
}
