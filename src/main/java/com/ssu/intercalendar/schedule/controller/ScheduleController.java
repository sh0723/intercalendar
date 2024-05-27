package com.ssu.intercalendar.schedule.controller;

import com.fasterxml.jackson.databind.ser.Serializers;
import com.ssu.intercalendar.common.BaseResponse;
import com.ssu.intercalendar.schedule.domain.Schedule;
import com.ssu.intercalendar.schedule.dto.*;
import com.ssu.intercalendar.schedule.service.ScheduleService;
import com.ssu.intercalendar.user.domain.User;
import com.ssu.intercalendar.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class ScheduleController {
    private final ScheduleService scheduleService;


    //임시
    private final UserRepository userRepository;


    //일정 추가
    @PostMapping("/api/schedule")
    public BaseResponse createSchedule (@RequestBody CreateScheduleRequest request) {
        //임시 유저
        User user = userRepository.findById(1L).get();
        scheduleService.createSchedule(user, request);
        return new BaseResponse(true);
    }


    //일정 업데이트
    @PutMapping("/api/schedule")
    public BaseResponse updateSchedule(@RequestBody UpdateScheduleRequest request) {
        scheduleService.updateSchedule(request);
        return new BaseResponse(true);
    }


    //단건 조회할 때 유저 정보는 필요 없을 거 같은데 우리 스펙상
    //그러면 dto에서 toDto 만들어서 유저 빼고 매핑하자.
    //스케줄 도메인 객체 파라미터로 받고 DTO 리턴하는 스태틱 메서드 만들면 된다.
    //임시 단건 조회 (캘린더)
//    @GetMapping("/api/schedule")
//    public GetScheduleResponse getSchedule (@RequestParam Long id) {
//        Schedule schedule = scheduleService.getSchedule(id);
//        return new GetScheduleResponse(true, schedule);
//    }

    //월 별 조회
    @GetMapping("/api/schedule")
    public GetScheduleByMonthResponse getScheduleByMonth (@RequestBody GetScheduleByMonthRequest request) {
        List<Schedule> schedules = scheduleService.getScheduleByMonth(request);
        return new GetScheduleByMonthResponse(true, schedules);
    }

    //일정 삭제 (캘린더)
    @DeleteMapping("/api/schedule")
    public BaseResponse deleteSchedule(@RequestParam Long id) {
        scheduleService.deleteSchedule(id);
        return new BaseResponse(true);
    }
}
