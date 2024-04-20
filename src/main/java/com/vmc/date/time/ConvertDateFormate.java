package com.vmc.date.time;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class ConvertDateFormate {

	public static void main(String[] args) {
		// 1 WAY
		LocalDate dateObj = LocalDate.now();
		LocalDate customDateObj = LocalDate.of(2020, 10, 10);
		System.out.println(customDateObj);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
		String date = dateObj.format(formatter);
		System.out.println(date);
		// 2 WAY
		LocalDateTime ldt = LocalDateTime.now();
		String dateFormate = DateTimeFormatter.ofPattern("yyyyMMdd").format(ldt);
		System.out.println(dateFormate);
		// 3 Compare Current date is Before 3 PM or After 3PM
		LocalTime now = LocalTime.now();
		LocalTime threePM = LocalTime.of(15, 0);
		if (now.isBefore(threePM)) {
			System.out.println("It's before 3 PM.");
		} else {
			System.out.println("It's after 3 PM.");
		}

	}

}
