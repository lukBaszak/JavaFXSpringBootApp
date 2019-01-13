package com.lubaszak.utils;

import org.springframework.stereotype.Service;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@Service
public class TimeProvider {

    public static final String TIME_PATTERN = "yy-MM-dd";


    public String getCurrentDate() {

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern(TIME_PATTERN);
        LocalDate localDate = LocalDate.now();

        return dtf.format(localDate);
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
