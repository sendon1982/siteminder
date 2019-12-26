package com.mjiang.email.util;

import org.joda.time.LocalDateTime;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.MatcherAssert.assertThat;

class DateUtilTest {

    @Test
    void test_timeToCurrentLocalDateTime() {
        LocalDateTime localDateTime = DateUtil.timeToCurrentLocalDateTime("144048");
        assertThat(localDateTime, equalTo(LocalDateTime.parse("2019-12-26T14:40:48.000")));
    }
}