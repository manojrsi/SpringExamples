package inbuilt_functional_interface;

import java.util.function.BiPredicate;

public class BiPredicateTest {

	public static void main(String[] args) {
		System.out.println("Functional Interface 'BiPredicate': takes two argument and the result is boolean.");
		int a =10, b=5;
		BiPredicate<Integer, Integer> divisible =
				new BiPredicate<Integer, Integer>() {
			@Override
			public boolean test(Integer t, Integer u) {
				return t % u == 0;
			}
		};
		
		boolean result = divisible.test(a, b);
		System.out.println("Using Anonymous :");
		System.out.println("Is "+a+" is divisible by "+b+" : "+result);

		BiPredicate<Integer, Integer> divisibleL = (f1,f2) -> f1%f2 == 0;
		
		System.out.println("Using lambda :");
		boolean resultL = divisibleL.test(a, b);
		System.out.println("Is "+a+" is divisible by "+b+" : "+resultL);

	}

}
