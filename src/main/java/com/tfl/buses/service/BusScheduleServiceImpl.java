package com.tfl.buses.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tfl.buses.entity.Prediction;
import com.tfl.buses.entity.Schedule;
import com.tfl.buses.exception.InvalidStopException;
import com.tfl.buses.mapper.BusScheduleMapper;
import com.tfl.buses.model.Stop;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.text.ParseException;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static com.tfl.buses.util.AppUtil.STOP_G_URL;
import static com.tfl.buses.util.AppUtil.STOP_H_URL;

@Service
public class BusScheduleServiceImpl implements BusScheduleService {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private BusScheduleMapper busScheduleMapper;

    @Override
    public List<Schedule> fetchSchedule(String stop) throws JsonProcessingException, ParseException {
        switch (Stop.valueOf(stop)) {
            case G:
                return getScheduleForStop(STOP_G_URL);

            case H:
                return getScheduleForStop(STOP_H_URL);

            default:
                throw new InvalidStopException("Invalid Stop : " + stop);
        }

    }

    private List<Schedule> getScheduleForStop(String url) throws JsonProcessingException, ParseException {
        ResponseEntity<String> entity = restTemplate.exchange(url, HttpMethod.GET, null, String.class);
        List<Prediction> predictions = objectMapper.readValue(entity.getBody(), new TypeReference<List<Prediction>>(){});
        List<Schedule> schedules = busScheduleMapper.map(predictions);
        Collections.sort(schedules, Comparator.comparing(Schedule::getExpectedArrivalTime));
        /*for(Schedule schedule : schedules) {
            System.out.println(schedule.getBusNo() + " : " + schedule.getDestinationName() + " : " + schedule.getExpectedArrivalTime());
        }*/

        return schedules;
    }
}
