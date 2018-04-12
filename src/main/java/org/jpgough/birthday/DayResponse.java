package org.jpgough.birthday;

import java.time.DayOfWeek;

public class DayResponse {

    private DayOfWeek dayOfWeek;

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

}
