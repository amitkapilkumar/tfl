package com.tfl.buses.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.tfl.buses.entity.Schedule;

import java.text.ParseException;
import java.util.List;

public interface BusScheduleService {
    List<Schedule> fetchSchedule(String stop) throws JsonProcessingException, ParseException;
}
