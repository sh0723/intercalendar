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


    //Lazy Loading과 JPA 프록시 개념을 알아야 하는 것
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;

    //DB의 관점에서 보면, 얜 진짜 객체 매핑이 아니고 그냥 FK
    // JOIN
    // Schedule FK -> User 테이블에 Select를 한 다음 합친거야
    // Schedule 조회마다 유저 정보를 항상 같이 가져올 이유가 없다
    // Schedule schedule = repo.findB~~();
    // schedule.getUser():
    // LAZY에선 JOIN하지 않았기 떄문에 아직 유저 정보가 없음
    // 근데, getUser(); 하는 순간 JPA가 DB에 쿼리를 날려서 유저 정보를 갖고오는 구조야

    //schedule.getUser();
    // 컨트롤러 -> return schedule; -> JSON

    // getUser();를 아직 호출하지 않았어, JSON으로 바뀌는 순간에도 User는 Proxy 객체야








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
