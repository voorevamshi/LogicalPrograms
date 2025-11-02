package com.vmc.java;

public class LogicalPrograms {
	public static void main(String[] args) {
		LogicalPrograms logicalPrograms = new LogicalPrograms();
		//1. logicalPrograms.executeLogic("com.vmc.java.ArmstrongNumberChecker");
		//2. logicalPrograms.executeLogic("com.vmc.java.FindMinimumDenomination");
		//3. logicalPrograms.executeLogic("com.vmc.java.SecondHighestNumber");
		//4. logicalPrograms.executeLogic("com.vmc.java.Sorting");
		//5. logicalPrograms.executeLogic("com.vmc.java.SortingWithSingleLoop");
		//6. logicalPrograms.executeLogic("com.vmc.java.Converging");
		//7. logicalPrograms.executeLogic("com.vmc.java.CyclicArray");
		//8. logicalPrograms.executeLogic("com.vmc.java.CyclicArray4C7R");
		//9. logicalPrograms.executeLogic("com.vmc.java.NonRepeatedNumbers");
		//10. logicalPrograms.executeLogic("com.vmc.java.MaxRepeatedCharacter");
		//11. logicalPrograms.executeLogic("com.vmc.java.Occurence");
		//12. logicalPrograms.executeLogic("com.vmc.java.ReverseNumber");
		//13. logicalPrograms.executeLogic("com.vmc.java.Palindrome");
		//14. logicalPrograms.executeLogic("com.vmc.java.EmpSalGreter10KAndUpperTheEmpName");
		//15. logicalPrograms.executeLogic("com.vmc.java.commonElementsOfArrays");
		//16. logicalPrograms.executeLogic("com.vmc.java.smallestNumber");
		//17. logicalPrograms.executeLogic("com.vmc.java.MaxSum");
		//18. logicalPrograms.executeLogic("com.vmc.java.FindMaxNumberInArray");
		//19. logicalPrograms.executeLogic("com.vmc.java.MaxCountOfVowels");
		//20. logicalPrograms.executeLogic("com.vmc.java.Fibonacci");
		//21. logicalPrograms.executeLogic("com.vmc.java.ReverseStringsInSentence");

		

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
