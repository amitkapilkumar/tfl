package com.tfl.buses.builder;

import com.tfl.buses.entity.Prediction;
import com.tfl.buses.entity.Timing;

public class PredictionBuilder {
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

    public static PredictionBuilder aPredictionBuilder() {
        PredictionBuilder builder = new PredictionBuilder();
        return builder;
    }

    public PredictionBuilder withType(String type) {
        this.type = type;
        return this;
    }

    public PredictionBuilder withId(String id) {
        this.id = id;
        return this;
    }

    public PredictionBuilder withOperationType(int operationType) {
        this.operationType = operationType;
        return this;
    }

    public PredictionBuilder withVehicleId(String vehicleId) {
        this.vehicleId = vehicleId;
        return this;
    }

    public PredictionBuilder withNaptanId(String naptanId) {
        this.naptanId = naptanId;
        return this;
    }

    public PredictionBuilder withStationName(String stationName) {
        this.stationName = stationName;
        return this;
    }

    public PredictionBuilder withLineId(String lineId) {
        this.lineId = lineId;
        return this;
    }

    public PredictionBuilder withLineName(String lineName) {
        this.lineName = lineName;
        return this;
    }

    public PredictionBuilder withPlatformName(String platformName) {
        this.platformName = platformName;
        return this;
    }

    public PredictionBuilder withDirection(String direction) {
        this.direction = direction;
        return this;
    }

    public PredictionBuilder withBearing(String bearing) {
        this.bearing = bearing;
        return this;
    }

    public PredictionBuilder withDestinationNaptanId(String destinationNaptanId) {
        this.destinationNaptanId = destinationNaptanId;
        return this;
    }

    public PredictionBuilder withDestinationName(String destinationName) {
        this.destinationName = destinationName;
        return this;
    }

    public PredictionBuilder withTimestamp(String timestamp) {
        this.timestamp = timestamp;
        return this;
    }

    public PredictionBuilder withTimeToStation(long timeToStation) {
        this.timeToStation = timeToStation;
        return this;
    }

    public PredictionBuilder withCurrentLocation(String currentLocation) {
        this.currentLocation = currentLocation;
        return this;
    }

    public PredictionBuilder withTowards(String towards) {
        this.towards = towards;
        return this;
    }

    public PredictionBuilder withExpectedArrival(String expectedArrival) {
        this.expectedArrival = expectedArrival;
        return this;
    }

    public PredictionBuilder withTimeToLive(String timeToLive) {
        this.timeToLive = timeToLive;
        return this;
    }

    public PredictionBuilder withModeName(String modeName) {
        this.modeName = modeName;
        return this;
    }

    public PredictionBuilder withTiming(Timing timing) {
        this.timing = timing;
        return this;
    }

    public Prediction build() {
        Prediction prediction = new Prediction();
        prediction.setType(type);
        prediction.setId(id);
        prediction.setOperationType(operationType);
        prediction.setVehicleId(vehicleId);
        prediction.setNaptanId(naptanId);
        prediction.setStationName(stationName);
        prediction.setLineId(lineId);
        prediction.setLineName(lineName);
        prediction.setPlatformName(platformName);
        prediction.setDirection(direction);
        prediction.setBearing(bearing);
        prediction.setDestinationNaptanId(destinationNaptanId);
        prediction.setDestinationName(destinationName);
        prediction.setTimestamp(timestamp);
        prediction.setTimeToStation(timeToStation);
        prediction.setCurrentLocation(currentLocation);
        prediction.setTowards(towards);
        prediction.setExpectedArrival(expectedArrival);
        prediction.setTimeToLive(timeToLive);
        prediction.setModeName(modeName);
        prediction.setTiming(timing);

        return prediction;
    }
}
