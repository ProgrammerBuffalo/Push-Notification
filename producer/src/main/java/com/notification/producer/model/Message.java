package com.notification.producer.model;

import java.sql.Timestamp;
import java.time.LocalDateTime;

public class Message<T> {

    private Timestamp timestamp = new Timestamp(System.currentTimeMillis());

    private T Data;

    public Message(T data) {
        Data = data;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public T getData() {
        return Data;
    }

    public void setData(T data) {
        Data = data;
    }
}
