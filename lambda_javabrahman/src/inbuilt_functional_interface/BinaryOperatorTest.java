package inbuilt_functional_interface;

import java.util.function.BinaryOperator;

public class BinaryOperatorTest {
//http://ocpj8.javastudyguide.com/ch10.html
	public static void main(String[] args) {
		BinaryOperator<String> binOp =  new BinaryOperator<String>() {
		     @Override
		     public String apply(String t, String u) {
		         return t.concat(u);
		     }
		};
		System.out.println(binOp.apply("Hello", " there"));
		
		BinaryOperator<String> binOp2 = (t, u) -> t.concat(u);
		System.out.println(binOp2.apply("Hello", " there"));
	}

}
