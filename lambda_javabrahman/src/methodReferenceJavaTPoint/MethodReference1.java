package methodReferenceJavaTPoint;

import java.util.Arrays;
import java.util.List;

interface Car {
	
	void color();
	
}

//Reference to a Static Method
public class MethodReference1 {

	public static void main(String[] args) {

		List<String> list = Arrays.asList("A","B");
		list.stream().forEach(System.out:: println);
		
		Car car = MethodReference1 :: carColor;
		car.color();
		
	}
	
	private static void carColor() {
	 System.out.println("Car color is Blue.");
	}
	
	
}
