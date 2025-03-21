package com.github.dannil.codewars.humanreadabledurationformat;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TimeFormatter {

    public static String formatDuration(int seconds) {
        if (seconds == 0) {
            return "now";
        }

        Map<String, Integer> durations = new LinkedHashMap<>();

        int secondsLimit = 1;
        int minutesLimit = secondsLimit * 60;
        int hoursLimit = minutesLimit * 60;
        int daysLimit = hoursLimit * 24;
        int yearsLimit = daysLimit * 365;

        seconds = getLimitAndComputeFit(seconds, yearsLimit, "year", durations);
        seconds = getLimitAndComputeFit(seconds, daysLimit, "day", durations);
        seconds = getLimitAndComputeFit(seconds, hoursLimit, "hour", durations);
        seconds = getLimitAndComputeFit(seconds, minutesLimit, "minute", durations);
        seconds = getLimitAndComputeFit(seconds, secondsLimit, "second", durations);

        List<String> formatted = durations.entrySet().stream().map(e -> {
            String key = e.getKey();
            int value = e.getValue();
            if (value > 1) {
                key += "s";
            }
            return value + " " + key;
        }).toList();

        if (formatted.size() > 1) {
            return formatted.subList(0, formatted.size() - 1).stream().collect(Collectors.joining(", ")) + " and "
                    + formatted.get(formatted.size() - 1);
        }
        return formatted.get(0);
    }

    public static int getLimitAndComputeFit(int seconds, int limit, String key, Map<String, Integer> durations) {
        if (seconds >= limit) {
            int fits = seconds / limit;
            durations.put(key, fits);
            seconds -= limit * fits;
        }
        return seconds;
    }

}
