package com.tfl.buses.entity;

import com.fasterxml.jackson.annotation.JsonSetter;

public class Timing {
    private String type;
    private String countdownServerAdjustment;
    private String source;
    private String insert;
    private String read;
    private String sent;
    private String received;

    public String getType() {
        return type;
    }

    @JsonSetter("$type")
    public void setType(String type) {
        this.type = type;
    }

    public String getCountdownServerAdjustment() {
        return countdownServerAdjustment;
    }

    public void setCountdownServerAdjustment(String countdownServerAdjustment) {
        this.countdownServerAdjustment = countdownServerAdjustment;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getInsert() {
        return insert;
    }

    public void setInsert(String insert) {
        this.insert = insert;
    }

    public String getRead() {
        return read;
    }

    public void setRead(String read) {
        this.read = read;
    }

    public String getSent() {
        return sent;
    }

    public void setSent(String sent) {
        this.sent = sent;
    }

    public String getReceived() {
        return received;
    }

    public void setReceived(String received) {
        this.received = received;
    }
}
