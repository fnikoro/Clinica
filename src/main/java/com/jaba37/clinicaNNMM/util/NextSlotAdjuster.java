package com.jaba37.clinicaNNMM.util;

import java.time.DayOfWeek;
import java.time.ZonedDateTime;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalAdjuster;

public class NextSlotAdjuster implements TemporalAdjuster {

    @Override
    public Temporal adjustInto(Temporal temporal) {
        ZonedDateTime nextSlot = ZonedDateTime.from(temporal);

        do {
            nextSlot = nextSlot.plusMinutes(30).withSecond(0);
        } while (nextSlot.getHour() < 8 ||
                nextSlot.getHour() >= 18 ||
                nextSlot.getHour() == 13 ||
                nextSlot.getDayOfWeek() == DayOfWeek.SUNDAY);
        return nextSlot;
    }
}