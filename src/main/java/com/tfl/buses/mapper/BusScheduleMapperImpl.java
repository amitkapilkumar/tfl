package com.tfl.buses.mapper;

import com.tfl.buses.entity.Prediction;
import com.tfl.buses.entity.Schedule;
import com.tfl.buses.util.AppUtil;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

@Component
public class BusScheduleMapperImpl implements BusScheduleMapper {

    @Override
    public List<Schedule> map(List<Prediction> predictions) throws ParseException {
        List<Schedule> schedules = new ArrayList<>();
        for(Prediction prediction : predictions) {
            Schedule schedule = new Schedule();
            schedule.setBusNo(prediction.getLineId());
            schedule.setDestinationName(prediction.getDestinationName());
            schedule.setExpectedArrivalTime(AppUtil.convertTimeToBST(prediction.getExpectedArrival()));
            schedules.add(schedule);
        }

        return schedules;
    }
}
