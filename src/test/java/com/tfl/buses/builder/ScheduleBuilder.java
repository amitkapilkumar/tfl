package com.tfl.buses.builder;

import com.tfl.buses.entity.Schedule;

public class ScheduleBuilder {
    private String busNo;
    private String destinationName;
    private String expectedArrivalTime;

    public static ScheduleBuilder aScheduleBuilder() {
        return new ScheduleBuilder();
    }

    public ScheduleBuilder withBusNo(String busNo) {
        this.busNo = busNo;
        return this;
    }

    public ScheduleBuilder withDestinationName(String destinationName) {
        this.destinationName = destinationName;
        return this;
    }

    public ScheduleBuilder withExpectedArrivalTime(String expectedArrivalTime) {
        this.expectedArrivalTime = expectedArrivalTime;
        return this;
    }

    public Schedule build() {
        Schedule schedule = new Schedule();
        schedule.setBusNo(busNo);
        schedule.setDestinationName(destinationName);
        schedule.setExpectedArrivalTime(expectedArrivalTime);
        return schedule;
    }
}
