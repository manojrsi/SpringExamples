package inbuilt_functional_interface;

import java.util.function.Function;

public class FunctionTest {
	// 	Link for Inbuilt Functional Interface :http://ocpj8.javastudyguide.com/ch10.html
	public static void main(String[] args) {
		double dValue = 12.56;
		Long longValueA = doubleToLongUsingFunctionUsingAnonymous(dValue);
		System.out.println("Double to Long using new Functional Interface 'Function'using Anonymous.");
		System.out.println("Long value of "+dValue+" is : "+longValueA);

		Long longValueL = doubleToLongUsingFunctionUsingLambda(dValue);
		System.out.println("Double to Long using new Functional Interface 'Function' using Lambda.");
		System.out.println("Long value of "+dValue+" is : "+longValueL);

		functionUsingComposeAndThen("Hi ");
	}

	private static Long doubleToLongUsingFunctionUsingAnonymous(Double doubleValue){
		Function<Double, Long> doubleToLong = new Function<Double, Long>() {

			public Long apply(Double d) {
				return Math.round(d);
			}
		};
		return doubleToLong.apply(doubleValue);
	}

	private static Long doubleToLongUsingFunctionUsingLambda(Double doubleValue){
		Function<Double, Long> doubleToLong = d -> Math.round(d);
		return doubleToLong.apply(doubleValue);
	}

	private static void functionUsingComposeAndThen(String str){
		Function<String, String> toUpper = s -> {
			return s.toUpperCase();
		};  

		Function<String, String> toLower = s -> {
			return s.toLowerCase();
		}; 

		System.out.println("Function output using 'andThen' : "+toUpper.andThen(toLower).apply(str));
		System.out.println("Function output using 'compose' : "+toUpper.compose(toLower).apply(str));
		System.out.println("Function output using 'identity' : "+Function.identity().apply(str));
	}
}