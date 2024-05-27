package com.ssu.intercalendar.user.repository;

import com.ssu.intercalendar.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
