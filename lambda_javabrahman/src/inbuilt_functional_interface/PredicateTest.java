package inbuilt_functional_interface;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class PredicateTest {

	private static List<String> names = null;

	public static void main(String[] args) {
		System.out.println("New Functional Interface : 'Predicate' with examples...\n");
		names = addNames();
		System.out.println("All the added names are : "+names);
		checkNames();
		checkNamesStartsWithAUsingLambda();
		checkNamesStartWithAAndEndWithTUsingLambda();
		checkStartWithAOrStartsWithRUsingLambda();
	}

	private static void checkNames() {
		System.out.println("++ checkNames: Predicate to check Names start with A using Anonymous method");
		System.out.println("Names start with A are :");
		for(String name : names){
			if(isStringStartsWithA(name)){
				System.out.println("Name '"+name);
			} 
		}
	}

	private static void checkNamesStartsWithAUsingLambda() {
		System.out.println("++ checkNamesStartsWithAUsingLambda: Predicate to check Names start with A using Lambda");
		System.out.println("Names start with A using Lambda are :");
		for(String name : names){
			if(isStringStartsWithAUsingLambda(name)){
				System.out.println("Name '"+name);
			} 
		}
	}

	private static void checkNamesStartWithAAndEndWithTUsingLambda() {
		System.out.println("++ checkNamesStartWithAAndEndWithTUsingLambda: Predicate to check Names start with A 'AND' ends with T using Lambda");
		System.out.println("Names start with A 'AND' ends with T using Lambda are :");
		for(String name : names){
			if(isStringStartsWithAandEndsWithT(name)){
				System.out.println("Name '"+name);
			} 
		}
	}

	private static void checkStartWithAOrStartsWithRUsingLambda() {
		System.out.println("++ checkStartWithAOrStartsWithRUsingLambda: Predicate to check Names start with A 'OR' starts with R using Lambda");
		System.out.println("Names start with A 'OR' starts with R using Lambda are :");
		for(String name : names){
			if(isStringStartsWithAorStartsWithR(name)){
				System.out.println("Name '"+name);
			} 
		}
	}

	private static List<String> addNames() {
		List<String> names = new ArrayList<String>();
		names.add("Amit");
		names.add("Manoj");
		names.add("Raghav");
		return names;
	}

	private static boolean isStringStartsWithA(String str){
		Predicate<String> startsWithA = new Predicate<String>() {

			@Override
			public boolean test(String t) {
				return t.startsWith("A");
			}
		};

		return startsWithA.test(str);

	}

	private static boolean isStringStartsWithAUsingLambda(String str){
		Predicate<String> startsWithA = (t) -> t.startsWith("A");

		return startsWithA.test(str);
	}

	private static boolean isStringStartsWithAandEndsWithT(String str){
		Predicate<String> startsWithA = t -> t.startsWith("A");
		Predicate<String> endsWithT = t -> t.endsWith("t");

		return startsWithA.and(endsWithT).test(str);
	}

	private static boolean isStringStartsWithAorStartsWithR(String str){
		Predicate<String> startsWithA = t -> t.startsWith("A");
		Predicate<String> startsWithR = t -> t.startsWith("R");

		return startsWithA.or(startsWithR).test(str);
	}

}
