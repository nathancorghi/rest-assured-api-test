package com.automation.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {

    private static SimpleDateFormat formatter;

    public static String getActualDateAndTime() {

        formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");

        return formatter.format(new Date());
    }

    public static String formattedDateTimeWithoutSeconds(Date date) {

        formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");

        return formatter.format(date);
    }
}