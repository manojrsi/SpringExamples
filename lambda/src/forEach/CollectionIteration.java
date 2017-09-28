package forEach;

import java.util.Arrays;
import java.util.List;

import forEach.Person;

public class CollectionIteration {

	public static void main(String[] args) {
		List<Person> persons = Arrays.asList (
				new Person("Rocky", "Pratap", 30),
				new Person("Ajay", "Sahoo", 25),
				new Person("Amar", "Chaudhary", 42),
				new Person("Raj", "Samal", 35));
		//Using Lambda Expressin
		System.out.println("Using Lambda Expressin");
		persons.forEach(p -> System.out.println(p));
		
		//Using Method Reference
		System.out.println("Using Method Reference");
		persons.forEach(System.out :: println);
	}

}
