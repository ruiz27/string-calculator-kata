package katas;


import exceptions.NegativeNumberException;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

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
		Pattern pattern = Pattern.compile("^//(.*)");
		Matcher matcher = pattern.matcher(input);
		if (matcher.find()) {
			String delimiter = matcher.group(1);
			if (delimiter.startsWith("[")){
				pattern = Pattern.compile("\\[(.*?)\\]");
				matcher = pattern.matcher(delimiter);
				if (matcher.find()) {
					return matcher.group(1);
				}
			}else{
				return delimiter;
			}
		}
		return input;
	}

	private int sum(String[] numbersArray) {
		int result = 0;
		Predicate<Integer> majorToZero = num -> num>=0;
		Predicate<Integer> minorTo1000 = num -> num<1000;
		List<Integer> lisNegativeNumbers = getLisNegativeNumbers(numbersArray);

		if(lisNegativeNumbers!=null) {
			if (lisNegativeNumbers.isEmpty()) {
				result = Arrays.stream(numbersArray)
						.map(this::convertToNumber)
						.filter(majorToZero)
						.filter(minorTo1000)
						.reduce(0, Integer::sum);
			} else {
				String message = buildMessageNegativeNumbers(lisNegativeNumbers);
				throw new NegativeNumberException(message);
			}
		}
		return result;
	}

	private String buildMessageNegativeNumbers(List<Integer> lisNegativeNumbers) {
		return lisNegativeNumbers.stream()
				.map(String::valueOf).
				collect(Collectors.joining(" ", " ", ""));
	}

	private List<Integer> getLisNegativeNumbers(String[] numbersArray) {
		Predicate<Integer> negativeNum = num -> num<0;
		return Arrays.stream(numbersArray)
				.map(this::convertToNumber)
				.filter(negativeNum)
				.collect(Collectors.toList());
	}

	private int convertToNumber(String num){
		try{
			return Integer.parseInt(num);
		}catch(Exception e){
			// log error
		}
		return 0;
	}

}
