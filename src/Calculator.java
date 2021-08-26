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
		
		return -1;
	}
	
}