package com.vmc.interview;

public class LogicalPrograms {
	public static void main(String[] args) {
		LogicalPrograms logicalPrograms = new LogicalPrograms();
		// logicalPrograms.executeLogic("com.interview.deloitte.RemoveAnElement");
		// logicalPrograms.executeLogic("com.interview.deloitte.ListOfListToList");
		// logicalPrograms.executeLogic("com.interview.infosys.AverageSalaryGroupByDepartment");
		 logicalPrograms.executeLogic("com.interview.DepartmentWiseEmployeeList");
	}

	private void executeLogic(String string) {
		try {
			Class<?> cls = Class.forName(string);
			// Using the new way since newInstance() is deprecated from Java 9 onwards
			Object obj = cls.getDeclaredConstructor().newInstance();

			// Now, if you're sure about the type, you can cast and call its methods
			if (obj instanceof Logic) {
				((Logic) obj).execute();
				((Logic) obj).executeWithSoultion2();
				((Logic) obj).executeWithSoultion3();
				((Logic) obj).executeUsingJava8();
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
