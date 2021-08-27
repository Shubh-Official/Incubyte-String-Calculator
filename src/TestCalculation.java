import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import static org.testng.Assert.assertEquals;



@Test
public class TestCalculation {
	
	// Declaring Reference to the Object
	private Calculator calculator;
	
	// Before Test init() function always executed
	@BeforeTest
	public void init() {
		// Allocate Calculator Object
		calculator = new Calculator();
	}

	public void emptyString() {
		// equals Empty String with 0
		assertEquals(calculator.Add(""), 0);
	}
	
	public void stringContainsOnlySpace() {
		// If String contains only Space then it was treated as an Empty String
		// equals Space Contains String with 0
		assertEquals(calculator.Add("\n"), 0);
	}
	
	public void stringContainsOneValue() {
		// If String contains only one value then it was return that same value
		// equals One Value contains String with that Same Integer Value
		assertEquals(calculator.Add("1"), 1);
	}
	
	public void stringContainsOneValueWithSpace() {
		// If String contains only one value having leading and trailing space then it was also return that same value
		// equals One Value having leading and trailing space contains String with that Same Integer Value
		assertEquals(calculator.Add("   1   "), 1);
	}
	
	public void stringContainsTwoValueCommaDelimited() {
		// If String contains two comma delimited value then it was return sum of that two values
		// equals Two Values contains String with that Integer Sum of those Two Values
		assertEquals(calculator.Add("1,2"), 3);
	}
	
	public void stringContainsTwoValueCommaDelimitedWithLeadTrailSpace() {
		// If String contains two comma delimited value having leading and trailing space then it was return sum of that two values
		// equals Two Values having leading and trailing space contains String with that Integer Sum of those Two Values
		assertEquals(calculator.Add("   1,2   "), 3);
	}
	
	public void stringContainsTwoValueCommaDelimitedWithSpaceInBetween() {
		// If String contains two comma delimited value having in between space then it was return sum of that two values
		// equals Two Values having in between space contains String with that Integer Sum of those Two Values
		assertEquals(calculator.Add("1  ,  2"), 3);
	}
	
	public void stringContainsTwoValueCommaDelimitedWithSpaceInBetweenAndLeadTrailSpace() {
		// If String contains two comma delimited value having leading, trailing and in between space then it was return sum of that two values
		// equals Two Values having leading, trailing and in between space contains String with that Integer Sum of those Two Values
		assertEquals(calculator.Add("   1  ,  2   "), 3);
	}
	
	public void stringContainsThreeValueCommaDelimited() {
		// If String contains three comma delimited value then it was return sum of that three values
		// equals Three Values contains String with that Integer Sum of those Three Values
		assertEquals(calculator.Add("1,2,3"), 6);
	}
	
	public void stringContainsThreeValueCommaDelimitedWithLeadTrailSpace() {
		// If String contains three comma delimited value having leading and trailing space then it was return sum of that three values
		// equals Three Values having leading and trailing space contains String with that Integer Sum of those Three Values
		assertEquals(calculator.Add("   1,2,3   "), 6);
	}
	
	public void stringContainsThreeValueCommaDelimitedWithSpaceInBetween() {
		// If String contains three comma delimited value having in between space then it was return sum of that three values
		// equals Three Values having in between space contains String with that Integer Sum of those Three Values
		assertEquals(calculator.Add("1  ,  2  ,  3"), 6);
	}
	
	public void stringContainsThreeValueCommaDelimitedWithSpaceInBetweenAndLeadTrailSpace() {
		// If String contains three comma delimited value having leading, trailing and in between space then it was return sum of that three values
		// equals Three Values having leading, trailing and in between space contains String with that Integer Sum of those Three Values
		assertEquals(calculator.Add("   1  ,  2  ,  3   "), 6);
	}
	
	public void stringContainsTwoValueNewLineDelimited() {
		// If String contains two \n delimited value then it was return sum of that two values
		// equals Two Values contains String with that Integer Sum of those Two Values
		assertEquals(calculator.Add("1\n2"), 3);
	}
	
	public void stringContainsTwoValueNewLineDelimitedWithLeadTrailSpace() {
		// If String contains two \n delimited value having leading and trailing space then it was return sum of that two values
		// equals Two Values having leading and trailing space contains String with that Integer Sum of those Two Values
		assertEquals(calculator.Add("   1\n2   "), 3);
	}
	
	public void stringContainsTwoValueNewLineDelimitedWithSpaceInBetween() {
		// If String contains two \n delimited value having in between space then it was return sum of that two values
		// equals Two Values having in between space contains String with that Integer Sum of those Two Values
		assertEquals(calculator.Add("1  \n  2"), 3);
	}
	
	public void stringContainsTwoValueNewLineDelimitedWithSpaceInBetweenAndLeadTrailSpace() {
		// If String contains two \n delimited value having leading, trailing and in between space then it was return sum of that two values
		// equals Two Values having leading, trailing and in between space contains String with that Integer Sum of those Two Values
		assertEquals(calculator.Add("   1  \n  2   "), 3);
	}
	
	public void stringContainsThreeValueNewLineOrCommaDelimited() {
		// If String contains three \n and comma delimited value having leading, trailing and in between space then it was return sum of that three values
		// equals Three Values contains String with that Integer Sum of those Three Values
		assertEquals(calculator.Add("1\n2,3"), 6);
	}
	
	public void stringContainsThreeValueNewLineOrCommaDelimitedWithLeadTrailSpace() {
		// If String contains three \n and comma delimited value having leading and trailing space then it was return sum of that three values
		// equals Three Values having leading and trailing space contains String with that Integer Sum of those Three Values
		assertEquals(calculator.Add("   1\n2,3   "), 6);
	}
	
	public void stringContainsThreeValueNewLineOrCommaDelimitedWithSpaceInBetween() {
		// If String contains three \n and comma delimited value having in between space then it was return sum of that three values
		// equals Three Values having in between space contains String with that Integer Sum of those Three Values
		assertEquals(calculator.Add("1  \n  2  ,  3"), 6);
	}
	
	public void stringContainsThreeValueNewLineOrCommaDelimitedWithSpaceInBetweenAndLeadTrailSpace() {
		// If String contains three \n and comma delimited value having leading, trailing and in between space then it was return sum of that three values
		// equals Three Values having leading, trailing and in between space contains String with that Integer Sum of those Three Values
		assertEquals(calculator.Add("   1  \n  2  ,  3   "), 6);
	}
	
	public void stringContainsTwoConsecutiveCommaDelimiters() {
		// If String contains Two Consecutive Comma Delimiter
		// equals Invalid Input with -1
		assertEquals(calculator.Add("1,,2"), -1);
	}
	
	public void stringContainsTwoConsecutiveNewLineDelimiters() {
		// If String contains Two Consecutive New Line Delimiter
		// equals Invalid Input with -1
		assertEquals(calculator.Add("1\n\n2"), -1);
	}
	
	public void stringContainsTwoConsecutiveNewLineOrCommaDelimiters() {
		// If String contains Two Consecutive New Line or Comma Delimiter
		// equals Invalid Input with -1
		assertEquals(calculator.Add("1\n,2"), -1);
	}
	
	public void stringContainsMoreThanTwoConsecutiveCommaDelimiters() {
		// If String contains more than Two Consecutive Comma Delimiter
		// equals Invalid Input with -1
		assertEquals(calculator.Add("1,,,,,2,,,3"), -1);
	}
	
	public void stringContainsMoreThanTwoConsecutiveNewLineDelimiters() {
		// If String contains more than Two Consecutive New Line Delimiter
		// equals Invalid Input with -1
		assertEquals(calculator.Add("1\n\n\n\n\n2\n\n\n3"), -1);
	}
	
	public void stringContainsMoreThanTwoConsecutiveNewLineOrCommaDelimiters() {
		// If String contains more than Two Consecutive New Line or Comma Delimiter
		// equals Invalid Input with -1
		assertEquals(calculator.Add("1\n,,\n\n\n,2"), -1);
	}
	
	public void stringWithOneDynamicDelimiterSemicolonAndTwoValue() {
		// String contains Dynamic Delimiter up to One character and Numbers
		// equals Two Numbers separated by Dynamic Delimiters with Sum of those Separated Numbers
		assertEquals(calculator.Add("//;\n1;2"), 3);
	}
	
	public void stringWithOneDynamicDelimiterHashTagAndFourValue() {
		// String contains Dynamic Delimiter up to One character and Numbers
		// equals Four Numbers separated by Dynamic Delimiters with Sum of those Separated Numbers
		assertEquals(calculator.Add("//#\n1#2#3#4"), 10);
	}
	
	public void stringWithOneDynamicDelimiterHashTagAndNumberHaveConsecutiveDynamicDelimiters() {
		// String contains Dynamic Delimiter up to One character and Numbers
		// equals Four Numbers separated by Dynamic Delimiters with Sum of those Separated Numbers
		assertEquals(calculator.Add("//#\n1##2###3####4"), -1);
	}
	
	public void negativeInputThrowExceptionOneValue() throws Exception {
		try {
			// String contains Single Negative Value
			calculator.Add("-100");
		}
		catch(IllegalArgumentException e) {
			// equals with Error Message along with Passed Negative Numbers
			assertEquals(e.getMessage(), "negatives not allowed: -100");
		}
	}
	
	public void negativeInputThrowExceptionMoreThanOneCommaDelimitedValue() throws Exception {
		try {
			// String contains more than One Comma Delimited Negative Value
			calculator.Add("10,5,4,0,-12,100,-2,-0,5");
		}
		catch(IllegalArgumentException e) {
			// equals with Error Message along with all Passed Negative Numbers
			assertEquals(e.getMessage(), "negatives not allowed: -12 -2");
		}
	}
	
	public void negativeInputThrowExceptionMoreThanOneNewLineDelimitedValue() throws Exception {
		try {
			// String contains more than One New Line delimited Negative Value
			calculator.Add("10\n-12\n-100\n-2\n5");
		}
		catch(IllegalArgumentException e) {
			// equals with Error Message along with all Passed Negative Numbers
			assertEquals(e.getMessage(), "negatives not allowed: -12 -100 -2");
		}
	}
	
	public void negativeInputThrowExceptionMoreThanOneNewLineOrCommaDelimitedValue() throws Exception {
		try {
			// String contains more than One New Line or Comma delimited Negative Value
			calculator.Add("10\n-12,-100\n-2\n5,-1");
		}
		catch(IllegalArgumentException e) {
			// equals with Error Message along with all Passed Negative Numbers
			assertEquals(e.getMessage(), "negatives not allowed: -12 -100 -2 -1");
		}
	}
	
	public void negativeInputThrowExceptionMoreThanOneConsecutiveNewLineOrCommaDelimitedValue() {
		// String contains more than One New Line delimited Negative Value
		// equals with -1 because if num is empty then it will return -1
		// Although Negative Numbers are there but Exception was not generated because Exception will throw at the end of the for-each loop iteration
		// We need to store all the negative numbers so first we iterate for-each loop and store all the negative values
		// But while iterating for-each loop of any empty string detected then program will simply return -1 from that point
		assertEquals(calculator.Add("-10\n,,,\n-12,,,-100\n\n-2\n5,-1"), -1);
	}
	
	public void negativeInputThrowExceptionWithDynamicDelimiter() throws Exception {
		try {
			// String contains Dynamic Delimiter more than One Negative Value
			calculator.Add("//#\n10#-12#-100#-2#5#-1");
		}
		catch(IllegalArgumentException e) {
			// equals with Error Message along with all Passed Negative Numbers
			assertEquals(e.getMessage(), "negatives not allowed: -12 -100 -2 -1");
		}
	}
	
	public void negativeInputThrowExceptionWithConsecutiveDynamicDelimiter() {
		// String contains Consecutive Dynamic Delimiter more than One Negative Value
		// equals with -1 because if num is empty then it will return -1
		// Although Negative Numbers are there but Exception was not generated because Exception will throw at the end of the for-each loop iteration
		// We need to store all the negative numbers so first we iterate for-each loop and store all the negative values
		// But while iterating for-each loop of any empty string detected then program will simply return -1 from that point
		assertEquals(calculator.Add("//#\n10#-12###-100##-2#5##-1"), -1);
	}
	
	public void oneNumberMoreThan1000CommaDelimited() {
		// String contains one Number having more than 1000 value so ignore them
		// equals with all numbers less than or equal to 1000 with its sum value
		assertEquals(calculator.Add("1234"), 0);
	}
	
	public void oneNumberMoreThan1000FromAllNumberCommaDelimited() {
		// String contains one Number having more than 1000 value so ignore them
		// equals with all numbers less than or equal to 1000 with its sum value
		assertEquals(calculator.Add("1,1001,2"), 3);
	}
	
	public void allThreeNumberMoreThan1000NewLineDelimited() {
		// String contains all the Number having more than 1000 value so ignore them
		// equals with 0 because all number having value grater than 1000 so ignored all the values 
		assertEquals(calculator.Add("1100\n1200\n1300"), 0);
	}
	
	public void twoNumberMoreThan1000WithNegativeNumberNewLineOrCommaDelimited() throws Exception {
		try {
			// If negative numbers are there then it will throw an exception with that negative values
			calculator.Add("1100\n-1200\n-50,1300");
		}
		catch(IllegalArgumentException e) {
			// equals with Error Message along with all Passed Negative Numbers
			assertEquals(e.getMessage(), "negatives not allowed: -1200 -50");
		}
	}
	
	public void someNumbersMoreThan1000WithDynamicDelimiter() {
		// String contains Dynamic Delimiter and some of the values are more than 1000
		// equals with all numbers less than or equal to 1000 with its sum value 10
		assertEquals(calculator.Add("//%\n1010%4%3%9999%2%1%1234"), 10);
	}
	
}