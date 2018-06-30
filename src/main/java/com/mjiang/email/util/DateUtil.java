package com.mjiang.email.util;

import org.joda.time.DateTimeZone;
import org.joda.time.LocalDate;

public class DateUtil {

    public static final DateTimeZone jodaTzUTC = DateTimeZone.forID("UTC");

    // from  java.sql.Date  to LocalDate:
    public static LocalDate dateToLocalDate(java.sql.Date d) {
        if (d == null) {
            return null;
        }
        return new LocalDate(d.getTime(), jodaTzUTC);
    }

    // from  LocalDate to java.sql.Date:
    public static java.sql.Date localdateToDate(LocalDate ld) {
        if (ld == null) {
            return null;
        }
        return new java.sql.Date(ld.toDateTimeAtStartOfDay(jodaTzUTC).getMillis());
    }
}
