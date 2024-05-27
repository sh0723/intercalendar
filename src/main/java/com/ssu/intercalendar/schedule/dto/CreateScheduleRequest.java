package com.ssu.intercalendar.schedule.dto;

import java.time.LocalDate;
import java.time.LocalTime;

public class CreateScheduleRequest {
    public LocalDate date;
    public String description;
    public LocalTime startTime;
    public LocalTime endTime;
}
