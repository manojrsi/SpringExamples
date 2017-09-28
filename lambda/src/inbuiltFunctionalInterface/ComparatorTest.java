package inbuiltFunctionalInterface;

import java.util.Comparator;
import java.util.TreeSet;

public class ComparatorTest {

	public static void main(String[] args) {
		
/*		
 * Comparator using Anonymous class
 * TreeSet<String> treeSet = new TreeSet<String>(new Comparator<String>() {

			@Override
			public int compare(String s1, String s2) {
				return - s1.compareTo(s2);
			};
		});*/

// Comparator with return statement		
//		Comparator<String> comparator = (s1, s2) -> {
//			return -s1.compareTo(s2);
//		
//		};
	
//Comparator without return statement
//      Comparator<String> comparator = (s1, s2) ->  -s1.compareTo(s2);
		
		TreeSet<String> treeSet = new TreeSet<>(((s1, s2) ->  -s1.compareTo(s2)));
		
		treeSet.add("A");
		treeSet.add("B");
		treeSet.add("C");
		treeSet.add("D");
		System.out.println("TreeSet Value : "+treeSet);
	}

}

