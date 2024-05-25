package com.ssu.intercalendar.location.domain;

import com.ssu.intercalendar.group.domain.Group;
import com.ssu.intercalendar.user.domain.User;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class Location {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; //PK는 DB가 만들어주니깐 생성자 만들 때 포함 안 시켜도 됨.

    private String locationName;
    private Double posX;
    private Double posY;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "group_id")
    private Group group;

    @Builder
    public Location(String locationName, Double posX, Double posY, User user, Group group) {
        this.locationName = locationName;
        this.posX = posX;
        this.posY = posY;
        this.user = user;
        this.group = group;
    }
}
