package inbuilt_functional_interface;

import java.util.function.Consumer;

public class ConsumerTest {

	public static void main(String[] args) {
		System.out.println("Below, Functional Interface 'Consumer' is used using anonymous way.");
		consumerUsingAnonymous("Manoj");
		System.out.println("Below, Functional Interface 'Consumer' is used using lambda way.");
		consumerUsingLambda("Rajesh");
		System.out.println("Below, Functional Interface 'Consumer' with andThen is used using lambda way.");
		consumerUsingLambdaAndThen("Happy");
	}
	
	private static void consumerUsingAnonymous(String value){
		Consumer<String> consumer = new Consumer<String>(){
			
			@Override
			public void accept(String str){
				System.out.println("Consumer accept using Anonymous way, String is : "+str);
			}
		};
		consumer.accept(value);
	}
	
	private static void consumerUsingLambda(String value){
		Consumer<String> consumer = str -> System.out.println("Consumer accept using Lambda way, String is : "+str);
		consumer.accept(value);
	}
	
	private static void consumerUsingLambdaAndThen(String value){
		Consumer<String> consumer1 = str -> System.out.print("Hi ");
		Consumer<String> consumer2 = str -> System.out.print(str);
		
		consumer1.andThen(consumer2).accept(value);
	}
	
}
