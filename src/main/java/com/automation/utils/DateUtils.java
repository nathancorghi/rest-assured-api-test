package com.automation.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {

    private static SimpleDateFormat formatter;

    public static String getActualDate() {

        formatter = new SimpleDateFormat("yyyy-MM-dd");

        return formatter.format(new Date());
    }

    public static String removeDateTime(Date date) {

        formatter = new SimpleDateFormat("yyyy-MM-dd");

        return formatter.format(date);
    }
}