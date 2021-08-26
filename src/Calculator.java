public class Calculator {
	
	public int Add(String numbers) {
		if(numbers.trim().isEmpty()) {
			return 0;
		}
		return Integer.parseInt(numbers);
	}
	
}