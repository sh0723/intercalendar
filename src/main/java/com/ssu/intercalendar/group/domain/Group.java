package com.ssu.intercalendar.group.domain;


import com.ssu.intercalendar.user.domain.User;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "team")
public class Group {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "owner_user_id")
    private User user;

    private String group_name;
    private Integer timeTomeet;
    private LocalDate startDate;
    private LocalDate endDate;


    private Integer memberCount;
    private Integer maximumMember;

    @Builder

    public Group(Integer maximumMember, Integer memberCount, LocalDate endDate, LocalDate startDate, Integer timeTomeet, String group_name) {
        this.maximumMember = maximumMember;
        this.memberCount = memberCount;
        this.endDate = endDate;
        this.startDate = startDate;
        this.timeTomeet = timeTomeet;
        this.group_name = group_name;
    }
}
