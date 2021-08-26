public class Calculator {
	
	public int Add(String numbers) {
		// Remove leading and trailing spaces
		numbers = numbers.trim();
		
		// If number String is Empty then return 0
		if(numbers.isEmpty())
			return 0;
		  
		// Split String with comma(,) delimiter
		String[] number = numbers.split(",");
		
		// If only one number is there then simply return that number as Integer
		if(number.length == 1)
			return Integer.parseInt(number[0]);
		// If two numbers are there then return sum of that two numbers as Integer
		else if(number.length == 2)
			return getSum(number[0], number[1]);
		else
			return -1;
	}
	
	private int getSum(String strNum1, String strNum2) {
		// return sum of passed Two String Values
		return Integer.parseInt(strNum1) + Integer.parseInt(strNum2);
	}

}