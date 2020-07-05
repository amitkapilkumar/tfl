package com.tfl.buses.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.tfl.buses.builder.ScheduleBuilder;
import com.tfl.buses.entity.Schedule;
import com.tfl.buses.service.BusScheduleService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class AppControllerTest {
    @InjectMocks
    private AppController appController;

    @Mock
    private BusScheduleService busScheduleService;

    @Test
    public void test() throws JsonProcessingException, ParseException {
        when(busScheduleService.fetchSchedule("H")).thenReturn(getSchedules());

        ResponseEntity<List<Schedule>> responseEntity = appController.getScheduleForStop("H");

        assertEquals(responseEntity.getBody().size(), 2);
        assertEquals(responseEntity.getBody().get(0).getBusNo(), "60");
        assertEquals(responseEntity.getBody().get(0).getDestinationName(), "StreathHam");
        assertEquals(responseEntity.getBody().get(0).getExpectedArrivalTime(), "19:20");
        assertEquals(responseEntity.getBody().get(1).getBusNo(), "109");
        assertEquals(responseEntity.getBody().get(1).getDestinationName(), "London Bridge");
        assertEquals(responseEntity.getBody().get(1).getExpectedArrivalTime(), "14:09");

        verify(busScheduleService).fetchSchedule("H");
    }

    private List<Schedule> getSchedules() {
        List<Schedule> schedules = new ArrayList<>();
        schedules.add(ScheduleBuilder.aScheduleBuilder().withBusNo("60").withDestinationName("StreathHam").withExpectedArrivalTime("19:20").build());
        schedules.add(ScheduleBuilder.aScheduleBuilder().withBusNo("109").withDestinationName("London Bridge").withExpectedArrivalTime("14:09").build());
        return schedules;
    }
}
