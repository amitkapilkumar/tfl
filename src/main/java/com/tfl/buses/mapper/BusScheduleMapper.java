package com.tfl.buses.mapper;

import com.tfl.buses.entity.Prediction;
import com.tfl.buses.entity.Schedule;

import java.text.ParseException;
import java.util.List;

public interface BusScheduleMapper {
    List<Schedule> map(List<Prediction> predictions) throws ParseException;
}
