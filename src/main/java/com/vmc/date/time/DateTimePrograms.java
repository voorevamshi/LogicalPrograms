package com.vmc.date.time;

public class DateTimePrograms {
	
	public static void main(String[] args) {
		DateTimePrograms dateTimePrograms=new DateTimePrograms();
		dateTimePrograms.executeLogic("com.vmc.date.time.CurrentCST_TimeIsBefore3PM");
		dateTimePrograms.executeLogic("com.vmc.date.time.CheckUS_BusinessDay");
		
	}

	private void executeLogic(String string) {
		try {
			Class<?> cls = Class.forName(string);
			// Using the new way since newInstance() is deprecated from Java 9 onwards
			Object obj = cls.getDeclaredConstructor().newInstance();

			// Now, if you're sure about the type, you can cast and call its methods
			if (obj instanceof DateTime) {
				((DateTime) obj).execute();
				((DateTime) obj).executeWithSoultion2();
				((DateTime) obj).executeWithSoultion3();
				((DateTime) obj).executeUsingJava8();
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
