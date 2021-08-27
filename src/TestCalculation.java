import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import static org.testng.Assert.assertEquals;



@Test
public class TestCalculation {
	
	private Calculator calculator;
	
	@BeforeTest
	public void init() {
		calculator = new Calculator();
	}

	public void emptyString() {
		assertEquals(calculator.Add(""), 0);
	}
	
	public void stringContainsOnlySpace() {
		assertEquals(calculator.Add("\n"), 0);
	}
	
	public void stringContainsOneValue() {
		assertEquals(calculator.Add("1"), 1);
	}
	
	public void stringContainsOneValueWithSpace() {
		assertEquals(calculator.Add("   1   "), 1);
	}
	
	public void stringContainsTwoValueCommaDelimited() {
		assertEquals(calculator.Add("1,2"), 3);
	}
	
	public void stringContainsTwoValueCommaDelimitedWithLeadTrailSpace() {
		assertEquals(calculator.Add("   1,2   "), 3);
	}
	
	public void stringContainsTwoValueCommaDelimitedWithSpaceInBetween() {
		assertEquals(calculator.Add("1  ,  2"), 3);
	}
	
	public void stringContainsTwoValueCommaDelimitedWithSpaceInBetweenAndLeadTrailSpace() {
		assertEquals(calculator.Add("   1  ,  2   "), 3);
	}
	
	public void stringContainsThreeValueCommaDelimited() {
		assertEquals(calculator.Add("1,2,3"), 6);
	}
	
	public void stringContainsThreeValueCommaDelimitedWithLeadTrailSpace() {
		assertEquals(calculator.Add("   1,2,3   "), 6);
	}
	
	public void stringContainsThreeValueCommaDelimitedWithSpaceInBetween() {
		assertEquals(calculator.Add("1  ,  2  ,  3"), 6);
	}
	
	public void stringContainsThreeValueCommaDelimitedWithSpaceInBetweenAndLeadTrailSpace() {
		assertEquals(calculator.Add("   1  ,  2  ,  3   "), 6);
	}
	
	public void stringContainsTwoValueNewLineDelimited() {
		assertEquals(calculator.Add("1\n2"), 3);
	}
	
	public void stringContainsTwoValueNewLineDelimitedWithLeadTrailSpace() {
		assertEquals(calculator.Add("   1\n2   "), 3);
	}
	
	public void stringContainsTwoValueNewLineDelimitedWithSpaceInBetween() {
		assertEquals(calculator.Add("1  \n  2"), 3);
	}
	
	public void stringContainsTwoValueNewLineDelimitedWithSpaceInBetweenAndLeadTrailSpace() {
		assertEquals(calculator.Add("   1  \n  2   "), 3);
	}
	
	public void stringContainsThreeValueNewLineOrCommaDelimited() {
		assertEquals(calculator.Add("1\n2,3"), 6);
	}
	
	public void stringContainsThreeValueNewLineOrCommaDelimitedWithLeadTrailSpace() {
		assertEquals(calculator.Add("   1\n2,3   "), 6);
	}
	
	public void stringContainsThreeValueNewLineOrCommaDelimitedWithSpaceInBetween() {
		assertEquals(calculator.Add("1  \n  2  ,  3"), 6);
	}
	
	public void stringContainsThreeValueNewLineOrCommaDelimitedWithSpaceInBetweenAndLeadTrailSpace() {
		assertEquals(calculator.Add("   1  \n  2  ,  3   "), 6);
	}
	
	public void stringContainsTwoConsecutiveCommaDelimiters() {
		assertEquals(calculator.Add("1,,2"), -1);
	}
	
	public void stringContainsTwoConsecutiveNewLineDelimiters() {
		assertEquals(calculator.Add("1\n\n2"), -1);
	}
	
	public void stringContainsTwoConsecutiveNewLineOrCommaDelimiters() {
		assertEquals(calculator.Add("1\n,2"), -1);
	}
	
	public void stringContainsMoreThanTwoConsecutiveCommaDelimiters() {
		assertEquals(calculator.Add("1,,,,,2,,,3"), -1);
	}
	
	public void stringContainsMoreThanTwoConsecutiveNewLineDelimiters() {
		assertEquals(calculator.Add("1\n\n\n\n\n2\n\n\n3"), -1);
	}
	
	public void stringContainsMoreThanTwoConsecutiveNewLineOrCommaDelimiters() {
		assertEquals(calculator.Add("1\n,,\n\n\n,2"), -1);
	}
	
	public void stringWithOneCharOneDynamicDelimiterSemicolonAndTwoValue() {
		assertEquals(calculator.Add("//;\n1;2"), 3);
	}
	
	public void stringWithOneCharOneDynamicDelimiterHashTagAndFourValue() {
		assertEquals(calculator.Add("//#\n1#2#3#4"), 10);
	}
	
	public void stringWithOneCharOneDynamicDelimiterHashTagAndNumberHaveConsecutiveDynamicDelimiters() {
		assertEquals(calculator.Add("//#\n1##2###3####4"), -1);
	}
	
	public void negativeInputThrowExceptionOneValue() throws Exception {
		try {
			calculator.Add("-100");
		}
		catch(IllegalArgumentException e) {
			assertEquals(e.getMessage(), "negatives not allowed: -100");
		}
	}
	
	public void negativeInputThrowExceptionMoreThanOneCommaDelimitedValue() throws Exception {
		try {
			calculator.Add("10,5,4,0,-12,100,-2,-0,5");
		}
		catch(IllegalArgumentException e) {
			assertEquals(e.getMessage(), "negatives not allowed: -12 -2");
		}
	}
	
	public void negativeInputThrowExceptionMoreThanOneNewLineDelimitedValue() throws Exception {
		try {
			calculator.Add("10\n-12\n-100\n-2\n5");
		}
		catch(IllegalArgumentException e) {
			assertEquals(e.getMessage(), "negatives not allowed: -12 -100 -2");
		}
	}
	
	public void negativeInputThrowExceptionMoreThanOneNewLineOrCommaDelimitedValue() throws Exception {
		try {
			calculator.Add("10\n-12,-100\n-2\n5,-1");
		}
		catch(IllegalArgumentException e) {
			assertEquals(e.getMessage(), "negatives not allowed: -12 -100 -2 -1");
		}
	}
	
	public void negativeInputThrowExceptionMoreThanOneConsecutiveNewLineOrCommaDelimitedValue() {
		assertEquals(calculator.Add("-10\n,,,\n-12,,,-100\n\n-2\n5,-1"), -1);
	}
	
	public void negativeInputThrowExceptionWithDynamicDelimiter() throws Exception {
		try {
			calculator.Add("//#\n10#-12#-100#-2#5#-1");
		}
		catch(IllegalArgumentException e) {
			assertEquals(e.getMessage(), "negatives not allowed: -12 -100 -2 -1");
		}
	}
	
	public void negativeInputThrowExceptionWithConsecutiveDynamicDelimiter() {
		assertEquals(calculator.Add("//#\n10#-12###-100##-2#5##-1"), -1);
	}
	
	public void oneNumberMoreThan1000CommaDelimited() {
		assertEquals(calculator.Add("1234"), 0);
	}
	
	public void oneNumberMoreThan1000FromAllNumberCommaDelimited() {
		assertEquals(calculator.Add("1,1001,2"), 3);
	}
	
	public void allThreeNumberMoreThan1000NewLineDelimited() {
		assertEquals(calculator.Add("1100\n1200\n1300"), 0);
	}
	
	public void twoNumberMoreThan1000WithNegativeNumberNewLineOrCommaDelimited() throws Exception {
		try {
			calculator.Add("1100\n-1200\n-50,1300");
		}
		catch(IllegalArgumentException e) {
			assertEquals(e.getMessage(), "negatives not allowed: -1200 -50");
		}
	}
	
	public void someNumbersMoreThan1000WithDynamicDelimiter() {
		assertEquals(calculator.Add("//%\n1010%4%3%9999%2%1%1234"), 10);
	}
	
	public void stringWithMultiCharOneDynamicDelimiter3AstricAndFourValue() {
		assertEquals(calculator.Add("//[***]\n1***2***3***4"), 10);
	}
	
	public void stringWithMultiCharOneDynamicDelimiter2Dollar2ColonAndFourValueOneMoreThan1000() {
		assertEquals(calculator.Add("//[$<.*>]\n1$<.*>1002$<.*>3$<.*>6"), 10);
	}
	
	public void stringWithMultiCharOneDynamicDelimiterLessThanAstricGreaterThanConsecutiveAndThreeValue() {
		assertEquals(calculator.Add("//[<*>]\n1<*>2<*><*>3"), -1);
	}
	
	public void stringWithMultiCharOneDynamicDelimiterPlusMinusMinusPlusAndFourValueTwoNegative() throws Exception {
		try {
			calculator.Add("//[+--+]\n1100+--+-1200+--+-50+--+1300");
		}
		catch(IllegalArgumentException e) {
			assertEquals(e.getMessage(), "negatives not allowed: -1200 -50");
		}
	}

	
	public void stringWithOneCharMultiDynamicDelimiterAstricPercentageAndThreeValue() {
		assertEquals(calculator.Add("//[*][%]\n1*2%3"), 6);
	}
	
	public void stringWithOneCharMultiDynamicDelimiterAstricLessThanQuestionAndSixValueTwoMoreThan1000() {
		assertEquals(calculator.Add("//[*][<][?]\n1*2<3?1234?5678*4"), 10);
	}
	
	public void stringWithOneCharMultiDynamicDelimiterColonPipiConsecutiveAndFourValue() {
		assertEquals(calculator.Add("//[:][|]\n1:2|3|:4"), -1);
	}
	
	public void stringWithOneCharMultiDynamicDelimiterHashDotAndFourValueTwoNegative() throws Exception {
		try {
			calculator.Add("//[#][.]\n1100#-1200.-50.1300");
		}
		catch(IllegalArgumentException e) {
			assertEquals(e.getMessage(), "negatives not allowed: -1200 -50");
		}
	}
	
	public void stringWithMultiCharMultiDynamicDelimiter3Astric3PlusAndFourValue() {
		assertEquals(calculator.Add("//[***][+++]\n1***2***3+++4"), 10);
	}
	
	public void stringWithMultiCharMultiDynamicDelimiter1Hash1Dollar1Colon1Semicolon1Dot1CaretAndSixValueTwoMoreThan1000() {
		assertEquals(calculator.Add("//[#$][:;.^]\n1#$2:;.^3:;.^1234:;.^5678#$4"), 10);
	}
	
	public void stringWithMultiCharMultiDynamicDelimiterPipe2Attherate3ExclamationConsecutiveAndFourValue() {
		assertEquals(calculator.Add("//[|@@][!!!]\n1|@@2!!!3!!!|@@4"), -1);
	}
	
	public void stringWithMultiCharMultiDynamicDelimiterCaretAstricCaretLessthanGreaterThanAndFourValueTwoNegative() throws Exception {
		try {
			calculator.Add("//[^*^][<>]\n1100^*^-1200^*^-50<>1300");
		}
		catch(IllegalArgumentException e) {
			assertEquals(e.getMessage(), "negatives not allowed: -1200 -50");
		}
	}
	
	@AfterTest
	public void printCountOfAddMethodInvoked() {
		System.out.println("Count of Add Method Invoked : " + calculator.getCountAdd());
	}
	
}