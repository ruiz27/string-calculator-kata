package katas;

public class StringCalculator {

	public Integer add(String input) {
		if(input.isEmpty()){
			return 0;
		}
		return Integer.parseInt(input);
	}

}
