package methodReferences2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class ReferenceToStaticMethodExample {

	public static void main(String[] args) {

		List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9,13);

		System.out.println(" Reference to a Static Method using Lambda");
		List<Integer> primeNumbersUsingLambda= 
				ReferenceToStaticMethodExample.findPrimeNumbers(numbers, (number) ->
				ReferenceToStaticMethodExample.isPrime((int)number));
		System.out.println("Using Lambda > Prime Numbers are " + primeNumbersUsingLambda);

		List<Integer> primeNumbersUsingMethodReference = 
				ReferenceToStaticMethodExample.findPrimeNumbers(numbers,
									ReferenceToStaticMethodExample :: isPrime);
		System.out.println("Using Method Reference > Prime Numbers are " + primeNumbersUsingMethodReference);

	}

	private static boolean isPrime(int number){
		if (number == 1) {
			return false;
		}

		for(int i = 2; i < number; i++){
			if(number % i == 0){
				return false;
			}
		}
		return true;
	}

	public static List<Integer> findPrimeNumbers(List<Integer> list, Predicate<Integer> predicate) {
		List<Integer> sortedNumbers = new ArrayList<Integer>();
		list.stream().filter((i) -> (predicate.test(i))).forEach((i) -> {
			sortedNumbers.add(i);
		});
		return sortedNumbers;
	}
}
