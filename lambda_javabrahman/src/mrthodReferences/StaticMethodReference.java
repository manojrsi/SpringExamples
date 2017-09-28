package mrthodReferences;

import java.util.function.Function;

public class StaticMethodReference {

	public static void main(String[] args) {
		
		Function<String, Double> doubleConverterLambda = (s) -> Double.parseDouble(s);
		Function<String, Integer> integerConverterLambda = (s) -> Integer.parseInt(s);
		
		System.out.println("Double value converter using lambda : "+doubleConverterLambda.apply("0.0125"));
		System.out.println("Integer value converter using lambda : "+integerConverterLambda.apply("15"));
		
		Function<String, Double> doubleConverterMethodReference = Double :: parseDouble;
		System.out.println("Double value converter using MethodReference : "+doubleConverterMethodReference.apply("25.6"));
		
	}
}
