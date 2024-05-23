package com.ssu.intercalendar.group.domain;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class Group {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String group_name;

    @Builder
    public Group(Long id, String group_name) {
        this.id = id;
        this.group_name = group_name;
    }
}
