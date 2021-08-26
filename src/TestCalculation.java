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
		// Equals Empty String with 0
		assertEquals(calculator.Add(""), 0);
	}
	
}