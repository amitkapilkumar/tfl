package com.tfl.buses.mapper;

import com.tfl.buses.builder.PredictionBuilder;
import com.tfl.buses.entity.Prediction;
import com.tfl.buses.entity.Schedule;
import com.tfl.buses.entity.Timing;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class BusScheduleMapperImplTest {
    @InjectMocks
    private BusScheduleMapperImpl busScheduleMapperImpl;

    @Test
    public void testMap() throws ParseException {
        List<Schedule> schedules = busScheduleMapperImpl.map(getPrediction("2020-07-05T13:57:28Z"));
        assertEquals(1, schedules.size());
        assertEquals("205", schedules.get(0).getBusNo());
        assertEquals("Baker Street Station", schedules.get(0).getDestinationName());
        assertEquals("14:57", schedules.get(0).getExpectedArrivalTime());
    }

    @Test(expected = ParseException.class)
    public void testMapWithException() throws ParseException {
        busScheduleMapperImpl.map(getPrediction("Invalid Time"));
    }

    private List<Prediction> getPrediction(String expectedTime) {
        List<Prediction> list = new ArrayList<>();

        list.add(PredictionBuilder.aPredictionBuilder().withType("Prediction")
                .withId("795338259")
                .withOperationType(1)
                .withVehicleId("SL14LNZ")
                .withNaptanId("490000091G")
                .withStationName("Great Portland Street Station")
                .withLineId("205")
                .withLineName("205")
                .withPlatformName("G")
                .withDirection("inbound")
                .withBearing("277")
                .withDestinationNaptanId("")
                .withDestinationName("Baker Street Station")
                .withTimestamp("2020-07-05T13:48:52.3521476Z")
                .withTimeToStation(516L)
                .withCurrentLocation("")
                .withTowards("Edgware Road or Marble Arch")
                .withExpectedArrival(expectedTime)
                .withTimeToLive("2020-07-05T13:57:58Z")
                .withModeName("bus")
                .withTiming(new Timing())
                .build());

        return list;
    }
}
