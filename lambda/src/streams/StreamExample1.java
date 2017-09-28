package streams;

import java.util.Arrays;
import java.util.List;

import streams.Person;

public class StreamExample1 {

	public static void main(String[] args) {
		List<Person> persons = Arrays.asList (
				new Person("Rocky", "Pratap", 30),
				new Person("Ajay", "Sahoo", 25),
				new Person("Amar", "Chaudhary", 42),
				new Person("Raj", "Samal", 35));
		
		persons.stream()
		.filter(p -> p.getFirstName().startsWith("A"))
		.forEach(p -> System.out.println(p));
		//.forEach(System.out :: println);
		
		long count = persons.stream()
		.filter(p -> p.getFirstName().startsWith("A"))
		.count();
		System.out.println("Count is  : "+count);
	}

}
