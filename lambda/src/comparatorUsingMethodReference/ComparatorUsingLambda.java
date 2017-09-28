package comparatorUsingMethodReference;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class ComparatorUsingLambda {

	public static void main(String[] args) {
		System.out.println("++ ComparatorUsingLambda ++");
		List<Person> persons = Arrays.asList (
				new Person("Rocky", "Pratap", 30),
				new Person("Ajay", "Sahoo", 25),
				new Person("Amar", "Chaudhary", 42),
				new Person("Raj", "Samal", 35));

		//Comparator implementation using lambda
		Collections.sort(persons,(p1,p2) -> p1.getFirstName().compareTo(p2.getFirstName()));

		//List all the Persons whose last name starts with 'S' using Method Reference
		System.out.println("\nAll the Person Using Predicate And Consumer whose last name starts with 'S' using Method Reference are:  ");
		printPersonUsingPredicateAndConsumer(persons,
				(p) -> p.getLastName().startsWith("S"),
				 System.out :: println); //Method Reference

	}
	

	//Using Predicate And Consumer
	private static void printPersonUsingPredicateAndConsumer(List<Person> persons, Predicate<Person> predicate, Consumer<Person> consumer) {
		for(Person person: persons) {
			if(predicate.test(person)) {
				consumer.accept(person);
			}
		}

	}

}
