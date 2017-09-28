package inbuilt_functional_interface;

import java.util.function.IntConsumer;

public class IntConsumerTest {

	public static void main(String[] args) {
		System.out.println("Below, Functional Interface 'Consumer' is used using lambda way.");
		int[] a = {1,2,3,4};
		intConsumerUsingLambda(a);
	}


	private static void intConsumerUsingLambda(int[] arr){
		IntConsumer consumer = intValue -> System.out.println(intValue);
		for(int i: arr) {	
			consumer.accept(i);
		}
	}

}
