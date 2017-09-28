package inbuilt_functional_interface;

import java.util.function.BiConsumer;

public class BiConsumerTest {

	public static void main(String[] args) {
		
		System.out.println("Functional Interface 'BiConsumer': takes two argument and the response is void as per the two arguments.");
		BiConsumer<String, String> consumeStr =
				new BiConsumer<String, String>() {
			@Override
			public void accept(String t, String u) {
				System.out.println(t + " " + u);
			}
		};

		System.out.println("Using Anonymous :");
		consumeStr.accept("Hi", "there");

		System.out.println("Using Anonymous :");
		BiConsumer<String, String> consumerL =
				(t, u) -> System.out.println(t + " " + u);
				consumerL.accept("Hi", "there");
	}

}
