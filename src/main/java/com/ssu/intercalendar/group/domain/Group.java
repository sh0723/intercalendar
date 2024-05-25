package com.ssu.intercalendar.group.domain;

import com.ssu.intercalendar.user.domain.User;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

//일정 CRUD
//그룹 CRUD => 장소 기능 (추가, 조회(DB에 있는 것))
//가능한 시간 찾는 알고리즘

@Entity
@Getter
@NoArgsConstructor
@Table(name = "team")
public class Group {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 날짜 + 시간 LocalDateTime
    // 날짜 LocalDate
    // 시간 LocalTime
    // 도메인에서는(DB에서)는 항상 null이 가능하기 때문에, 모두 클래스형 타입으로 써줘야해
    // 0 = 박스 안에 물건이 하나도 없다, null = 박스도 없다..


    private String groupName;
    private Integer targetMeetingTime;
    private LocalDate startDate;
    private LocalDate endDate;
    private Integer memberCount;
    private Integer maximumMember;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "owner_user_id")
    private User user;


    @Builder
    public Group(String groupName) {
        this.groupName = groupName;
    }

    @Builder
    public Group(String groupName, Integer targetMeetingTime, LocalDate startDate, LocalDate endDate, Integer memberCount, Integer maximumMember, User user) {
        this.groupName = groupName;
        this.targetMeetingTime = targetMeetingTime;
        this.startDate = startDate;
        this.endDate = endDate;
        this.memberCount = memberCount;
        this.maximumMember = maximumMember;
        this.user = user;
    }
}
