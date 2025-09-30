/*
 * package com.vmc.date.time;
 * 
 * import java.time.DayOfWeek; import java.time.ZoneId; import
 * java.time.ZonedDateTime; import java.time.format.DateTimeFormatter;
 * 
 * public class CheckUS_BusinessDay implements DateTime {
 * 
 * @Override public void execute() {
 * 
 * }
 * 
 * @Override public void executeWithSoultion2() {
 * 
 * }
 * 
 * @Override public void executeWithSoultion3() {
 * 
 * }
 * 
 * @Override public void executeUsingJava8() { // Saturday 12 AM to Sunday 12 PM
 * is non business hours System.out.println("executeUsingJava8"); String zone =
 * "America/Chicago"; DateTimeFormatter date =
 * DateTimeFormatter.ofPattern("YYYY-MM-dd"); DateTimeFormatter time =
 * DateTimeFormatter.ofPattern("HH:mm:ss"); ZonedDateTime currentTimeInUS =
 * ZonedDateTime.now(ZoneId.of(zone)); if ((currentTimeInUS.getDayOfWeek() ==
 * DayOfWeek.SATURDAY && currentTimeInUS.getHour() > 12) ||
 * (currentTimeInUS.getDayOfWeek() == DayOfWeek.SUNDAY &&
 * currentTimeInUS.getHour() < 24)) { System.out.println( "Current US Date: " +
 * currentTimeInUS.format(date) + " time " + currentTimeInUS.format(time) +
 * " and Week " + currentTimeInUS.getDayOfWeek() + " is not a business Day"); }
 * else { System.out.println( "Current US Date: " + currentTimeInUS.format(date)
 * + " time " + currentTimeInUS.format(time) + " and Week " +
 * currentTimeInUS.getDayOfWeek() + " is not a business Day"); }
 * 
 * }
 * 
 * }
 */