public class Calculator {
	
	// Define delimiters as final so we can not change delimiters value
	private final String delimiters = ",|\n";
	// Define dynamicDelimiters variable to maintain Dynamic Delimiters
	private String dynamicDelimiters = "";
	// Define string before dynamicDelimiters
	private final String stringBeforeDynamicDelimiter = "//";
	
	public int Add(String numbers) {
		// Remove leading and trailing spaces
		numbers = numbers.trim();
		
		// If number String is Empty then return 0
		if(numbers.isEmpty())
			return 0;
		
		// String number Array reference Defined
		String[] number;
		
		if(numbers.matches("(//).(\n).*")) {
			// Find index of New Line
			int newLineIndex = numbers.indexOf("\n");
			// Find index of string before dynamicDelimiters
			int delimiterIndex = numbers.indexOf(stringBeforeDynamicDelimiter) + stringBeforeDynamicDelimiter.length();
			// Find dynamicDelimiter from Original String
			dynamicDelimiters = numbers.substring(delimiterIndex, delimiterIndex+1);
			// Separates numbers String from Original String 
			numbers = numbers.substring(newLineIndex+1);
			// Split separated number String with dynamicDelimiters 
			number = numbers.split(dynamicDelimiters);
		}
		else {
			// Split number String with default delimiters
			number = numbers.split(delimiters);
		}
		
		// If only one number is there then simply return that number as Integer
		if(number.length == 1) {
			if( str2num(number[0]) < 0 )
				throw new IllegalArgumentException("negatives not allowed: " + str2num(number[0]));
			else if( str2num(number[0]) <= 1000)
				return str2num(number[0]);
			else
				return 0;
		}
		// If more than one number are there then return sum of those all numbers as Integer
		else
			return getSum(number);
	}
	
	private int getSum(String []number) {
		// sumNumber that contains sum of all number in String array
		int sumNumber = 0;
		String negativeNumbers = "";
		// for-each loop that iterates all the values in String array of number
		for(String num : number) {
			// Remove leading and trailing spaces
			num = num.trim();
			
			// More than one consecutive delimiters exist then num is empty so return -1
			if(num.isEmpty()) {
				return -1;
			}
			
			if( str2num(num) >= 0 ) {
				if( str2num(num) <= 1000 ) {
					// Add num to sumNumber variable
					sumNumber += str2num(num);
				}
			}
			else {
				// Adding negative number into negativeNumbers String
				negativeNumbers += ( num + " " );
			}
		}
		
		if(!negativeNumbers.isEmpty()) {
			// Remove Leading and Trailing Space
			// Last Space added in Negative Numbers so we need to remove this
			negativeNumbers = negativeNumbers.trim();
			throw new IllegalArgumentException("negatives not allowed: " + negativeNumbers);
		}
		
		return sumNumber;
	}
	
	private int str2num(String num) {
		// Converting String to Integer
		// Return Integer Value of passed String Number
		return Integer.parseInt(num);
	}
	
}