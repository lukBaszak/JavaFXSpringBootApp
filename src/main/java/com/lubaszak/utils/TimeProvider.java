package com.lubaszak.utils;

import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.Date;

@Service
public class TimeProvider {

    public static final String TIME_PATTERN = "yy-MM-dd";


    public String getParticularStringDate(Date date) {
       DateFormat dtf = new SimpleDateFormat(TIME_PATTERN);
        return dtf.format(date);
    }


    public Date fromStringToDate(String date) {
            Date localDate = null;
        try {
            localDate = new SimpleDateFormat(TIME_PATTERN).parse(date);

        } catch (ParseException e) {
            e.printStackTrace();
        }

        return localDate;
    }


}
