package inbuilt_functional_interface;

import java.util.function.IntPredicate;
import java.util.function.Predicate;

public class PredicateIntegerTest {

	public static void main(String[] args) {
		Integer intValue = 14;
		System.out.println("Using Predicate class check '"+intValue+"' is Even :"+isEvenUsingPredicateClass(intValue));
		System.out.println("Using IntPredicate class check '"+intValue+"' is Even :"+isEvenUsingIntPredicateClass(intValue));
	}

	private static boolean isEvenUsingPredicateClass(Integer value){
		Predicate<Integer> even = t -> t % 2 == 0;

		return even.test(value);
	}
	
	private static boolean isEvenUsingIntPredicateClass(Integer value){
		IntPredicate even = t -> t % 2 == 0;
		return even.test(value);
	}

}
