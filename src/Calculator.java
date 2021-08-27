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
		else
			return getSum(number);
	}
	
	private int getSum(String []number) {
		int sumNumber = 0;
		for(String num : number) {
			num = num.trim();
			sumNumber += Integer.parseInt(num);
		}
		return sumNumber;
	}

}