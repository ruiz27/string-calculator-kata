package katas;


public class StringCalculator {

	public Integer add(String input) {
		if(input.isEmpty()){
			return 0;
		}
		String[] numbersArray = extractNumbersArray(input);
		return sum(numbersArray);
	}

	private String[] extractNumbersArray(String input){
		String delimiter = ",";
		if(input.startsWith("//")){
			String[] arrayNumbers = input.split("\n");
			delimiter = extractDelimiter(arrayNumbers[0]);
			return arrayNumbers[1].split(delimiter);
		}else{
			input = input.replace("\n", delimiter);
			return input.split(delimiter);
		}
	}


	private String extractDelimiter(String input) {
		String delimiter = ",";
		if(input.startsWith("//")){
			delimiter = input.substring(2,3);
		}
		return delimiter;
	}

	private int sum(String[] numbersArray) {
		int result = 0;
		for (String s : numbersArray) {
			result = result + Integer.parseInt(s);
		}
		return result;
	}

}
