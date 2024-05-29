package com.ssu.intercalendar.group.domain;


import com.ssu.intercalendar.user.domain.User;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
@Table(name="'group'")
public class Group {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String group_name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "owner_user_id")
    private User user;


    @Builder
    public Group(Long id, String group_name) {
        this.id = id;
        this.group_name = group_name;
    }
}
