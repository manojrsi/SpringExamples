package methodReferenceJavaTPoint;

import java.util.function.BiFunction;

//Predefined functional interface to refer methods
public class MethodReference3 {

	public static void main(String[] args) {

		BiFunction<Integer, Integer, Integer> add = ArithmeticAdd :: add;
		Integer sum = add.apply(10, 50);
		System.out.println("Sum is : "+sum);
	}
}

class ArithmeticAdd {
	
	static int add(int a1, int a2){
		return a1+a2;
	}
}