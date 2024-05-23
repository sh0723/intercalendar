package com.ssu.intercalendar.user_group.domain;

import jakarta.persistence.Entity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class User_Group {
    private String user_id;
    private String group_id;

    @Builder
    public User_Group(String user_id, String group_id) {
        this.user_id = user_id;
        this.group_id = group_id;
    }

}
