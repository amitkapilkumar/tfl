package com.tfl.buses.entity;

public class Schedule {
    private String busNo;
    private String destinationName;
    private String expectedArrivalTime;

    public String getBusNo() {
        return busNo;
    }

    public void setBusNo(String busNo) {
        this.busNo = busNo;
    }

    public String getDestinationName() {
        return destinationName;
    }

    public void setDestinationName(String destinationName) {
        this.destinationName = destinationName;
    }

    public String getExpectedArrivalTime() {
        return expectedArrivalTime;
    }

    public void setExpectedArrivalTime(String expectedArrivalTime) {
        this.expectedArrivalTime = expectedArrivalTime;
    }
}
