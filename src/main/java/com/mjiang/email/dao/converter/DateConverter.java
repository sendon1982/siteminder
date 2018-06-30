package com.mjiang.email.dao.converter;

import java.sql.Date;

import com.mjiang.email.util.DateUtil;
import org.joda.time.LocalDate;
import org.jooq.Converter;

public class DateConverter implements Converter<Date, LocalDate> {

    @Override
    public LocalDate from(Date date) {
        return date == null ? null : LocalDate.fromDateFields(date);
    }

    @Override
    public Date to(LocalDate ld) {
        return ld == null ? null : DateUtil.localdateToDate(ld);
    }

    @Override
    public Class<Date> fromType() {
        return Date.class;
    }

    @Override
    public Class<LocalDate> toType() {
        return LocalDate.class;
    }
}
