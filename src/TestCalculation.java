import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;



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

}