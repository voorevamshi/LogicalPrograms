package com.vmc.java;

public class LogicalPrograms {
	public static void main(String[] args) {
		LogicalPrograms logicalPrograms = new LogicalPrograms();
		//logicalPrograms.executeLogic("com.vmc.java.ArmstrongNumberChecker"); .
		//logicalPrograms.executeLogic("com.vmc.java.FindMinimumDenomination"); .
		//logicalPrograms.executeLogic("com.vmc.java.SecondHighestNumber"); .
		//logicalPrograms.executeLogic("com.vmc.java.Sorting");
		//logicalPrograms.executeLogic("com.vmc.java.SortingWithSingleLoop");
		//logicalPrograms.executeLogic("com.vmc.java.Converging");
		//logicalPrograms.executeLogic("com.vmc.java.CyclicArray");
		//logicalPrograms.executeLogic("com.vmc.java.CyclicArray4C7R");
		//logicalPrograms.executeLogic("com.vmc.java.MaxRepeatedCharacter");
		//logicalPrograms.executeLogic("com.vmc.java.Occurence");
		//logicalPrograms.executeLogic("com.vmc.java.ReverseStringsInSentence");
		//logicalPrograms.executeLogic("com.vmc.java.ReverseNumber");
		//logicalPrograms.executeLogic("com.vmc.java.Palindrome");
		//logicalPrograms.executeLogic("com.vmc.java.EmpSalGreter10KAndUpperTheEmpName");
		//logicalPrograms.executeLogic("com.vmc.java.commonElementsOfArrays");
		//logicalPrograms.executeLogic("com.vmc.java.smallestNumber");
		logicalPrograms.executeLogic("com.vmc.java.Fibonacci");
		

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
