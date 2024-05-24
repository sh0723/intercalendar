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
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "group_id")
    private Group group;

    private String locationName;
    private Double posX;
    private Double posY;

    @Builder
    public Location(String locationName, Double posX, Double posY) {
        this.locationName = locationName;
        this.posX = posX;
        this.posY = posY;
    }
}
