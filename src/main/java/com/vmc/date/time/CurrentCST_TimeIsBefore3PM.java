package com.vmc.date.time;

import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class CurrentCST_TimeIsBefore3PM implements DateTime {

	@Override
	public void execute() {

	}

	@Override
	public void executeWithSoultion2() {
		System.out.println("executeWithSoultion2");
		String zone = "America/Chicago";
		ZonedDateTime zdt = ZonedDateTime.now(ZoneId.of(zone));
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");
		String currentCST_Time = zdt.format(dtf);
		System.out.println("Current US Time:"+currentCST_Time);
		LocalTime currentUS_Time = LocalTime.parse(currentCST_Time, dtf);
		LocalTime threePM = LocalTime.of(15, 0, 0);
		if (currentUS_Time.isBefore(threePM)) {
			System.out.println("Current US time is before 3 PM");
		} else {
			System.out.println("Current US time is after 3 PM");
		}
	}

	@Override
	public void executeWithSoultion3() {

	}

	@Override
	public void executeUsingJava8() {
		System.out.println("executeUsingJava8");
		String zone = "America/Chicago";
		ZonedDateTime zdt = ZonedDateTime.now(ZoneId.of(zone));
		System.out.println("Current US Hour:"+zdt.getHour());
		if (zdt.getHour() < 15) {
			System.out.println("Current US time is before 3 PM");
		} else {
			System.out.println("Current US time is after 3 PM");
		}

	}

}
