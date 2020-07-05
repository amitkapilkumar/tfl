package com.tfl.buses.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.tfl.buses.entity.Schedule;
import com.tfl.buses.service.BusScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.util.List;

@RestController
public class AppController {

    @Autowired
    private BusScheduleService busScheduleService;

    @GetMapping("/schedule/greatportlandstreet/{stop}")
    public ResponseEntity<List<Schedule>> getScheduleForStop(@PathVariable("stop") String stop) throws JsonProcessingException, ParseException {
        List<Schedule> schedules = busScheduleService.fetchSchedule(stop);
        return ResponseEntity.status(HttpStatus.OK).body(schedules);
    }
}
