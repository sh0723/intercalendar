package com.ssu.intercalendar.location.domain;

import jakarta.persistence.Entity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class Location {
    private String group_id;
    private String user_id;
    private String location_name;

    @Builder
    public Location(String group_id, String user_id, String location_name) {
        this.group_id = group_id;
        this.user_id = user_id;
        this.location_name = location_name;
    }
}
