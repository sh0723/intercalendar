package com.ssu.intercalendar.schedule.repository;

import com.ssu.intercalendar.schedule.domain.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface ScheduleRepository extends JpaRepository<Schedule, Long> {

    //jpql로 Schedule 테이블에 날짜 between 활용해서 뽑아와야 한다.
    //JPQL (Java Persistence Query Language) -> JPQL은 엔티티 객체를 조회하는 객체지향 쿼리다.
    //SQL과 비슷한 문법을 가지며, JPQL은 결국 SQL로 변환된다.
    @Query("SELECT s FROM Schedule s WHERE s.user.id = :id AND s.date BETWEEN :startDate AND :endDate")
    List<Schedule> findScheduleByDateRange(@Param("id") Long id, @Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate);
}
