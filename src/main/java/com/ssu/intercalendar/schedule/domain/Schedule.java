package com.ssu.intercalendar.schedule.domain;

import com.ssu.intercalendar.user.domain.User;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Getter
@NoArgsConstructor
public class Schedule {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;
    private LocalDate date;
    private LocalTime startTime;
    private LocalTime endTime;

    @Column(columnDefinition = "TEXT")
    private String description;

    //생성자에만 @Builder를 붙인다.
    @Builder
    public Schedule(User user, LocalDate date, LocalTime startTime, LocalTime endTime, String description) {
        this.user = user;
        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
        this.description = description;
    }

    public void updateSchedule (LocalDate date, String description, LocalTime startTime, LocalTime endTime) {
        this.date = date;
        this.description = description;
        this.startTime = startTime;
        this.endTime = endTime;
    }
}
