package methodReferences2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class ReferenceToConstructor {

	public static void main(String[] args) {
		List<Integer> numbers = Arrays.asList(5,10,15,20,30,40,50);
		List<Double> sqRtListUsingLambda = ReferenceToConstructor.squareRoot(numbers, Double::new); 
		System.out.println("Square Root Using Lambda : "+sqRtListUsingLambda);
		List<Double> sqRtListUsingConstructorReference = ReferenceToConstructor.squareRoot(numbers, x -> new Double(x)); 
		System.out.println("Square Root Using Constructor Reference : "+sqRtListUsingConstructorReference);
		
	}
	
	private static List<Double> squareRoot(List<Integer> numbers, Function<Integer, Double> f){
		List<Double>  squareRootList = new ArrayList<Double>();
		numbers.forEach(number -> squareRootList.add(Math.sqrt(f.apply(number))));
		
		return squareRootList;
	}

}
