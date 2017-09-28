package exceptionHandling;

import java.util.function.BiConsumer;

public class LambdaExceptionHandling {

	public static void main(String[] args) {
		int[] numbers = {1,2,4,6};
		int key = 0;
		
		//process(numbers,key, (v1,v2) -> System.out.println(v1/v2));
		
		process(numbers,key, exceptionWrapper((v1,v2) -> System.out.println(v1/v2)));

	}

	private static void process(int[] numbers, int key, BiConsumer<Integer, Integer> biConsumer) {
		
		for(int number : numbers) {
			biConsumer.accept(number, key);
		}
	}
	
	private static BiConsumer<Integer, Integer> exceptionWrapper(BiConsumer<Integer, Integer> biConsumer) {
		
		return (v1,v2) -> { 
			try {
				biConsumer.accept(v1, v2);
			} catch(ArithmeticException arithmeticException){
				System.out.println("Exception Occured : "+arithmeticException.getMessage());
			}
		};
		
	}

}
