package com.tfl.buses.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tfl.buses.builder.ScheduleBuilder;
import com.tfl.buses.entity.Schedule;
import com.tfl.buses.mapper.BusScheduleMapper;
import com.tfl.buses.model.Stop;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import static com.tfl.buses.util.AppUtil.STOP_G_URL;
import static com.tfl.buses.util.AppUtil.STOP_H_URL;
import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class BusScheduleServiceImplTest {

    @InjectMocks
    private BusScheduleServiceImpl busScheduleServiceImpl;

    @Mock
    private RestTemplate restTemplate;

    @Mock
    private ObjectMapper objectMapper;

    @Mock
    private BusScheduleMapper busScheduleMapper;

    @After
    public void verifyAfter() {
        verifyNoMoreInteractions(restTemplate, objectMapper, busScheduleMapper);
    }

    @Test
    public void testFetchScheduleForStopG() throws JsonProcessingException, ParseException {
        ResponseEntity<String> entity = mock(ResponseEntity.class);
        String json = "[{ 'json' : 'body'}]";

        when(entity.getBody()).thenReturn(json);
        when(restTemplate.exchange(STOP_G_URL, HttpMethod.GET, null, String.class)).thenReturn(entity);
        when(objectMapper.readValue(anyString(), any(TypeReference.class))).thenReturn(new ArrayList<>());
        when(busScheduleMapper.map(anyList())).thenReturn(getSchedules());

        List<Schedule> schedules = busScheduleServiceImpl.fetchSchedule(Stop.G.toString());

        assertEquals(schedules.size(), 2);
        assertEquals(schedules.get(0).getBusNo(), "109");
        assertEquals(schedules.get(0).getDestinationName(), "London Bridge");
        assertEquals(schedules.get(0).getExpectedArrivalTime(), "14:09");
        assertEquals(schedules.get(1).getBusNo(), "60");
        assertEquals(schedules.get(1).getDestinationName(), "StreathHam");
        assertEquals(schedules.get(1).getExpectedArrivalTime(), "19:20");

        verify(restTemplate).exchange(STOP_G_URL, HttpMethod.GET, null, String.class);
        verify(objectMapper).readValue(anyString(), any(TypeReference.class));
        verify(busScheduleMapper).map(anyList());
        verify(entity).getBody();
    }

    @Test
    public void testFetchScheduleForStopH() throws JsonProcessingException, ParseException {
        ResponseEntity<String> entity = mock(ResponseEntity.class);
        String json = "[{ 'json' : 'body'}]";

        when(entity.getBody()).thenReturn(json);
        when(restTemplate.exchange(STOP_H_URL, HttpMethod.GET, null, String.class)).thenReturn(entity);
        when(objectMapper.readValue(anyString(), any(TypeReference.class))).thenReturn(new ArrayList<>());
        when(busScheduleMapper.map(anyList())).thenReturn(getSchedules());

        List<Schedule> schedules = busScheduleServiceImpl.fetchSchedule(Stop.H.toString());

        assertEquals(schedules.size(), 2);
        assertEquals(schedules.get(0).getBusNo(), "109");
        assertEquals(schedules.get(0).getDestinationName(), "London Bridge");
        assertEquals(schedules.get(0).getExpectedArrivalTime(), "14:09");
        assertEquals(schedules.get(1).getBusNo(), "60");
        assertEquals(schedules.get(1).getDestinationName(), "StreathHam");
        assertEquals(schedules.get(1).getExpectedArrivalTime(), "19:20");

        verify(restTemplate).exchange(STOP_H_URL, HttpMethod.GET, null, String.class);
        verify(objectMapper).readValue(anyString(), any(TypeReference.class));
        verify(busScheduleMapper).map(anyList());
        verify(entity).getBody();
    }

    @Test(expected = IllegalArgumentException.class)
    public void testWithException() throws JsonProcessingException, ParseException {
        busScheduleServiceImpl.fetchSchedule("E");
    }

    @Test(expected = JsonProcessingException.class)
    public void testWithJsonProcessingException() throws JsonProcessingException, ParseException {
        ResponseEntity<String> entity = mock(ResponseEntity.class);
        String json = "[{ 'json' : 'body'}]";

        when(entity.getBody()).thenReturn(json);
        when(restTemplate.exchange(STOP_H_URL, HttpMethod.GET, null, String.class)).thenReturn(entity);
        when(objectMapper.readValue(anyString(), any(TypeReference.class))).thenThrow(new JsonProcessingException("") {});

        try {
            busScheduleServiceImpl.fetchSchedule("H");
        }
        finally {
            verify(restTemplate).exchange(STOP_H_URL, HttpMethod.GET, null, String.class);
            verify(objectMapper).readValue(anyString(), any(TypeReference.class));
            verify(entity).getBody();
        }
    }

    @Test(expected = ParseException.class)
    public void testWithParseException() throws JsonProcessingException, ParseException {
        ResponseEntity<String> entity = mock(ResponseEntity.class);
        String json = "[{ 'json' : 'body'}]";

        when(entity.getBody()).thenReturn(json);
        when(restTemplate.exchange(STOP_H_URL, HttpMethod.GET, null, String.class)).thenReturn(entity);
        when(objectMapper.readValue(anyString(), any(TypeReference.class))).thenReturn(new ArrayList<>());
        when(busScheduleMapper.map(anyList())).thenThrow(new ParseException("exception", 0));

        try {
            busScheduleServiceImpl.fetchSchedule("H");
        }
        finally {
            verify(restTemplate).exchange(STOP_H_URL, HttpMethod.GET, null, String.class);
            verify(objectMapper).readValue(anyString(), any(TypeReference.class));
            verify(busScheduleMapper).map(anyList());
            verify(entity).getBody();
        }
    }

    private List<Schedule> getSchedules() {
        List<Schedule> schedules = new ArrayList<>();
        schedules.add(ScheduleBuilder.aScheduleBuilder().withBusNo("60").withDestinationName("StreathHam").withExpectedArrivalTime("19:20").build());
        schedules.add(ScheduleBuilder.aScheduleBuilder().withBusNo("109").withDestinationName("London Bridge").withExpectedArrivalTime("14:09").build());
        return schedules;
    }
}
