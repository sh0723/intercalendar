package com.ssu.intercalendar.schedule.service;

import com.ssu.intercalendar.schedule.domain.Schedule;
import com.ssu.intercalendar.schedule.dto.CreateScheduleRequest;
import com.ssu.intercalendar.schedule.dto.GetScheduleByMonthRequest;
import com.ssu.intercalendar.schedule.dto.UpdateScheduleRequest;
import com.ssu.intercalendar.schedule.repository.ScheduleRepository;
import com.ssu.intercalendar.user.domain.User;
import com.ssu.intercalendar.user.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.List;


@Service
@Transactional
@RequiredArgsConstructor
public class ScheduleService {
    private final ScheduleRepository scheduleRepository;

    //ID는 DB가 만들어준다.
    public void createSchedule(User user, CreateScheduleRequest request) {
        Schedule schedule = Schedule.builder()
                .user(user)
                .date(request.date)
                .startTime(request.startTime)
                .endTime(request.endTime)
                .description(request.description)
                .build();
        scheduleRepository.save(schedule);
    }

    public void updateSchedule(UpdateScheduleRequest request) {
        Schedule schedule = scheduleRepository.findById(request.id).orElseThrow(() -> new RuntimeException("그런 일정 없어요."));
        schedule.updateSchedule(request.date, request.description, request.startTime, request.endTime);
    }

    public Schedule getSchedule (Long id) {
        Schedule schedule = scheduleRepository.findById(id).orElseThrow(() -> new RuntimeException("Schedule not found"));
        return schedule;
    }

    //월 별 조회
    public List<Schedule> getScheduleByMonth (GetScheduleByMonthRequest request) {
        return scheduleRepository.findScheduleByDateRange(request.id, request.startDate, request.endDate);
    }

    //일정 삭제 (캘린더)
    public void deleteSchedule(Long id) {
        Schedule schedule = getSchedule(id);
        scheduleRepository.delete(schedule);
    }
}
