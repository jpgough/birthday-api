package org.jpgough.birthday;

import java.time.DayOfWeek;

public class DayResponse {

    private DayOfWeek dayOfWeek;

    private String nameOfMonth;

    public DayResponse() {}

    public DayResponse(DayOfWeek dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public DayOfWeek getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(DayOfWeek dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public String getNameOfMonth() {
        return nameOfMonth;
    }

    public void setNameOfMonth(String nameOfMonth) {
        this.nameOfMonth = nameOfMonth;
    }
}
