public class Calculator {
	
	public int Add(String numbers) {
		if(numbers.isEmpty()) {
			return 0;
		}
		return Integer.parseInt(numbers);
	}
	
}