package com.vmc.date.time;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class ZoneTimeDateFormate {

	public static void main(String[] args) {
      //  String dateStr = "20230515";  // Example date

        DateTimeFormatter inputFormat = DateTimeFormatter.ofPattern("yyyyMMdd");
        DateTimeFormatter outputFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        // Parse the date
       // LocalDate date = LocalDate.parse(dateStr, inputFormat);
        LocalDateTime date = LocalDateTime.now();
        // Convert to ZonedDateTime with a specific zone (e.g., "America/Chicago" for CST)
        //atStartOfDay
        ZonedDateTime zonedDateTime = date.atZone(ZoneId.of("America/Chicago"));

        // Format the ZonedDateTime
        String formattedDate = outputFormat.format(zonedDateTime);

        System.out.println(formattedDate);  // Output: 2023-05-15
	}
}
