package com.tfl.buses.entity;

import com.fasterxml.jackson.annotation.JsonSetter;

public class Prediction {
    private String type;
    private String id;
    private int operationType;
    private String vehicleId;
    private String naptanId;
    private String stationName;
    private String lineId;
    private String lineName;
    private String platformName;
    private String direction;
    private String bearing;
    private String destinationNaptanId;
    private String destinationName;
    private String timestamp;
    private long timeToStation;
    private String currentLocation;
    private String towards;
    private String expectedArrival;
    private String timeToLive;
    private String modeName;
    private Timing timing;

    public String getType() {
        return type;
    }

    @JsonSetter("$type")
    public void setType(String type) {
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getOperationType() {
        return operationType;
    }

    public void setOperationType(int operationType) {
        this.operationType = operationType;
    }

    public String getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(String vehicleId) {
        this.vehicleId = vehicleId;
    }

    public String getNaptanId() {
        return naptanId;
    }

    public void setNaptanId(String naptanId) {
        this.naptanId = naptanId;
    }

    public String getStationName() {
        return stationName;
    }

    public void setStationName(String stationName) {
        this.stationName = stationName;
    }

    public String getLineId() {
        return lineId;
    }

    public void setLineId(String lineId) {
        this.lineId = lineId;
    }

    public String getLineName() {
        return lineName;
    }

    public void setLineName(String lineName) {
        this.lineName = lineName;
    }

    public String getPlatformName() {
        return platformName;
    }

    public void setPlatformName(String platformName) {
        this.platformName = platformName;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public String getBearing() {
        return bearing;
    }

    public void setBearing(String bearing) {
        this.bearing = bearing;
    }

    public String getDestinationNaptanId() {
        return destinationNaptanId;
    }

    public void setDestinationNaptanId(String destinationNaptanId) {
        this.destinationNaptanId = destinationNaptanId;
    }

    public String getDestinationName() {
        return destinationName;
    }

    public void setDestinationName(String destinationName) {
        this.destinationName = destinationName;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public long getTimeToStation() {
        return timeToStation;
    }

    public void setTimeToStation(long timeToStation) {
        this.timeToStation = timeToStation;
    }

    public String getCurrentLocation() {
        return currentLocation;
    }

    public void setCurrentLocation(String currentLocation) {
        this.currentLocation = currentLocation;
    }

    public String getTowards() {
        return towards;
    }

    public void setTowards(String towards) {
        this.towards = towards;
    }

    public String getExpectedArrival() {
        return expectedArrival;
    }

    public void setExpectedArrival(String expectedArrival) {
        this.expectedArrival = expectedArrival;
    }

    public String getTimeToLive() {
        return timeToLive;
    }

    public void setTimeToLive(String timeToLive) {
        this.timeToLive = timeToLive;
    }

    public String getModeName() {
        return modeName;
    }

    public void setModeName(String modeName) {
        this.modeName = modeName;
    }

    public Timing getTiming() {
        return timing;
    }

    public void setTiming(Timing timing) {
        this.timing = timing;
    }
}
