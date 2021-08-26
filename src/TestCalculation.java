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
	
}