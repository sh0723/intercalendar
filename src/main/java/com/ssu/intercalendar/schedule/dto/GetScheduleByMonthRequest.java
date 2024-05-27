package com.ssu.intercalendar.schedule.dto;

import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;

public class GetScheduleByMonthRequest {
    public Long id;
    public LocalDate startDate;
    public LocalDate endDate;
}
