package katas;


public class StringCalculator {

	public Integer add(String input) {
		if(input.isEmpty()){
			return 0;
		}

		input = input.replace("\n",",");

		String[] numbersArray = input.split(",");

		int result = 0;
		for (String s : numbersArray) {
			result = result + Integer.parseInt(s);
		}

		return result;
	}

}
