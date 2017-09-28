package inbuilt_functional_interface;

import java.util.function.Supplier;

public class SupplierTest {

	public static void main(String[] args) {
		System.out.println("Functional Interface 'Supplier': takes no argument and return String");
		String t = "One";
		Supplier<String> supplierA = new Supplier<String>() {
		     @Override
		     public String get() {
		         return t.toUpperCase();
		     }
		};
		
		System.out.println("Using Anonymous class : ");
		System.out.println(supplierA.get());
		
		System.out.println("Using lambda : ");
		Supplier<String> supplierL = () -> t.toUpperCase();
		System.out.println(supplierL.get());
	}

}