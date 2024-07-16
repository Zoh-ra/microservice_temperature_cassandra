package com.zohra.microservice_temperature.utils;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class DateTimeUtils {
    public static LocalDateTime roundMinutesToNearestTen(LocalDateTime dateTime) {
        int minutes = dateTime.getMinute();
        int roundedMinutes = (minutes / 10) * 10; // Arrondir vers le bas à la dizaine inférieure
        return dateTime.withMinute(roundedMinutes).withSecond(0).withNano(0);
    }

    public static List<LocalDateTime> findMissingDates(List<LocalDateTime> dates, int intervalMinutes) {
        List<LocalDateTime> missingDates = new ArrayList<>();
        for (int i = 1; i < dates.size(); i++) {
            LocalDateTime previousDate = dates.get(i - 1);
            LocalDateTime currentDate = dates.get(i);
            while (previousDate.plusMinutes(intervalMinutes).isBefore(currentDate)) {
                previousDate = previousDate.plusMinutes(intervalMinutes);
                missingDates.add(previousDate);
            }
        }
        return missingDates;
    }
}
