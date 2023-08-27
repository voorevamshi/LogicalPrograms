package com.vmc.java8.date.time;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;

public class DateConversionExample {
    public static void main(String[] args) {
        LocalDate localDate = LocalDate.of(1993, 2, 28);

        // Convert LocalDate to ZonedDateTime
        ZonedDateTime zonedDateTime = localDate.atStartOfDay(ZoneId.systemDefault());

        System.out.println(zonedDateTime);
        // Convert ZonedDateTime to Date
        Date date = Date.from(zonedDateTime.toInstant());

        System.out.println(date);
        
        System.out.println(Date.from(LocalDate.of(1993, 2, 28).atStartOfDay(ZoneId.systemDefault()).toInstant()));
    }
}
