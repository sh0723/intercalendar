package com.ssu.intercalendar.user.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor @Getter @Setter
public class RegisterRequest {
    public String username;
    public String email;
    public String password;

}
