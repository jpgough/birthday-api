package org.jpgough.birthday;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DateMessage {

    @JsonProperty(required = true)
    private String date;

    public DateMessage() {

    }

    public DateMessage(String date) {
        this.date = date;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
