package predicateFunctionalInterface;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class PredicateTest {
	
	public static void main(String[] args) {
		
		List<Integer> list = Arrays.asList(1,2,3,5);
		System.out.println("Print all arrays list numbers: ");
		evaluate(list, (n)->true);
		
		System.out.println("Print no numbers:");
		evaluate(list, (n)->false);
		
	}
	
	private static void evaluate(List<Integer> list, Predicate<Integer> predicate) {
		list.forEach((l) ->  {
			if(predicate.test((Integer) l)){
				System.out.println(l);
			}
		});
	}

}
