public class Calculator {
	
	private final String delimiters = ",|\n";
	private final String stringBeforeDynamicDelimiter = "//";
	private String[] escapeRegEx = {"+", "-", "*", "/", "$", "%", "^", ".", "?", "|", ")", ")", "{", "}", "[", "]"};
	private int countAdd = 0;
	
	public int Add(String numbers) {
		countAdd++;
		numbers = numbers.trim();
		
		if(numbers.isEmpty())
			return 0;
		
		String[] number;
		
		if(numbers.matches("(//).*(\n).*")) {
			int newLineIndex = numbers.indexOf("\n");
			int delimiterIndex = numbers.indexOf(stringBeforeDynamicDelimiter) + stringBeforeDynamicDelimiter.length();
			String dynamicDelimiterString = numbers.substring(delimiterIndex, newLineIndex);
			String[] dynamicDelimiters = dynamicDelimiterString.split("\\[|\\]");
			String regEx = "";
			
			for(String dynamicDelimiter: dynamicDelimiters) {
				if(dynamicDelimiter.isEmpty());
				else {
					for(int charIndex = 0; charIndex < dynamicDelimiter.length(); charIndex++) {
						boolean inEscapeRegEx = false;
						String currentDynamicDelimiterChar = dynamicDelimiter.substring(charIndex, charIndex+1);
						for(String charEscapeRegEx: escapeRegEx) {
							if(charEscapeRegEx.equals(currentDynamicDelimiterChar)) {
                            	inEscapeRegEx = true;
                            	break;
                            }
                        }
						if(inEscapeRegEx)
                            regEx += "\\";
						regEx += currentDynamicDelimiterChar;
					}
					regEx += " ";
				}
			}
			regEx = regEx.trim();
			regEx = regEx.replaceAll(" ", "|");
			numbers = numbers.substring(newLineIndex+1);
			number = numbers.split(regEx);
		}
		else {
			number = numbers.split(delimiters);
		}
		
		if(number.length == 1) {
			if( str2num(number[0]) < 0 )
				throw new IllegalArgumentException("negatives not allowed: " + str2num(number[0]));
			else if( str2num(number[0]) <= 1000)
				return str2num(number[0]);
			else
				return 0;
		}
		else
			return getSum(number);
	}
	
	private int getSum(String []number) {
		int sumNumber = 0;
		String negativeNumbers = "";
		
		for(String num : number) {
			num = num.trim();
			
			if(num.isEmpty()) {
				return -1;
			}
			
			if( str2num(num) >= 0 ) {
				if( str2num(num) <= 1000 ) {
					sumNumber += str2num(num);
				}
			}
			else {
				negativeNumbers += ( num + " " );
			}
		}
		
		if(!negativeNumbers.isEmpty()) {
			negativeNumbers = negativeNumbers.trim();
			throw new IllegalArgumentException("negatives not allowed: " + negativeNumbers);
		}
		
		return sumNumber;
	}
	
	private int str2num(String num) {
		return Integer.parseInt(num);
	}
	
	public int getCountAdd() {
		return countAdd;
	}
	
}