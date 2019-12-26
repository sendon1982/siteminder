package com.mjiang.email.util;

import org.joda.time.DateTimeZone;
import org.joda.time.LocalDate;
import org.joda.time.LocalDateTime;
import org.joda.time.LocalTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

public class DateUtil {

    public static final DateTimeZone jodaTzUTC = DateTimeZone.forID("UTC");
    public static final DateTimeZone SHANGHAI_TZ = DateTimeZone.forID("Asia/Shanghai");

    public static final DateTimeFormatter TIME_FORMATTER = DateTimeFormat.forPattern("HHmmss");

    // from  java.sql.Date  to LocalDate:
    public static LocalDate dateToLocalDate(java.sql.Date d) {
        if (d == null) {
            return null;
        }
        return new LocalDate(d.getTime(), jodaTzUTC);
    }

    // from  LocalDate to java.sql.Date:
    public static java.sql.Date localDateToDate(LocalDate localDate) {
        if (localDate == null) {
            return null;
        }
        return new java.sql.Date(localDate.toDateTimeAtStartOfDay(jodaTzUTC).getMillis());
    }

    public static LocalDateTime timeToCurrentLocalDateTime(String time) {
        return LocalDate.now().toLocalDateTime(LocalTime.parse(time, TIME_FORMATTER));
    }
}
