package com.ssu.intercalendar.user.controller;

import com.ssu.intercalendar.user.dto.LoginRequest;
import com.ssu.intercalendar.user.dto.RegisterRequest;
import com.ssu.intercalendar.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("/api/register")
    public boolean register(@RequestBody RegisterRequest registerRequest)
    {
        return userService.register(registerRequest);
    }

    @PostMapping("/api/login")
    public Authentication login(@RequestBody LoginRequest loginRequest)
    {
        return userService.login(loginRequest);
    }


}
