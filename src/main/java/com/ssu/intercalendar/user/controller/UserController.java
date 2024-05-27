package com.ssu.intercalendar.user.controller;

import com.ssu.intercalendar.security.domain.SessionUser;
import com.ssu.intercalendar.user.domain.User;
import com.ssu.intercalendar.user.dto.LoginRequest;
import com.ssu.intercalendar.user.dto.RegisterRequest;
import com.ssu.intercalendar.user.repository.UserRepository;
import com.ssu.intercalendar.user.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    private final UserRepository userRepository;

    @PostMapping("/api/register")
    public boolean register(@RequestBody RegisterRequest registerRequest)
    {
        return userService.register(registerRequest);
    }

    @PostMapping("/api/login")
    public HttpStatus login(@RequestBody LoginRequest loginRequest)
    {
        userService.login(loginRequest);
        return HttpStatus.OK;
    }

    @GetMapping("/api/test")
    public Object test(@AuthenticationPrincipal SessionUser sessionUser)
    {
//        return sessionUser.getUser();
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return principal;

    }

    @GetMapping("/api/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null) {

            SecurityContextHolder.clearContext();

            request.getSession().invalidate();

            return "Logout successful";
        } else {

            return "Not authenticated";
        }
    }
}
