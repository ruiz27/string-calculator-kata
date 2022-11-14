package katas;


public class StringCalculator {
	public static final String REGEX = "\n";
	public static final String PREFIX = "//";

	public Integer add(String input) {
		if(input.isEmpty()){
			return 0;
		}
		String[] numbersArray = extractNumbersArray(input);
		return sum(numbersArray);
	}

	private String[] extractNumbersArray(String input){
		String delimiter = ",";
		if(input.startsWith(PREFIX)){
			String[] arrayNumbers = input.split(REGEX);
			delimiter = extractDelimiter(arrayNumbers[0]);
			return arrayNumbers[1].split(delimiter);
		}else{
			input = input.replace(REGEX, delimiter);
			return input.split(delimiter);
		}
	}

	private String extractDelimiter(String input) {
		return input.substring(2,3);
	}

	private int sum(String[] numbersArray) {
		int result = 0;
		for (String s : numbersArray) {
			result = result + Integer.parseInt(s);
		}
		return result;
	}

}
