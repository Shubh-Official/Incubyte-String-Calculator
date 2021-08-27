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
	
}