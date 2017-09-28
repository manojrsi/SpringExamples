package inbuilt_functional_interface;

import java.util.function.UnaryOperator;

public class UnaryOperatorTest {

	public static void main(String[] args) {
		System.out.println("Functional Interface 'UnaryOperator': takes argument and the result are of the same type e.g. String.");
		UnaryOperator<String> unaryOperatorA = new UnaryOperator<String>() {

			@Override
			public String apply(String t) {
				return t.substring(0, 2);
			}
		};

		System.out.println("Using anonymous class : ");
		System.out.println(unaryOperatorA.apply("Hello India"));

		System.out.println("Using lambda class : ");

		UnaryOperator<String> unaryOperatorL = str -> str.substring(0,5);
		System.out.println(unaryOperatorL.apply("Hello India"));

	}

}
