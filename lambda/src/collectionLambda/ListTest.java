package collectionLambda;

import java.util.Arrays;
import java.util.List;


public class ListTest {

	public static void main(String[] args) {
		
		//Old way:
		List<Integer> list = Arrays.asList(1,2,3,4);
		System.out.println("List Value using old way - ");
		for(Integer l : list){
			System.out.println(l);
		}
		
		System.out.println("List Value using forEach loop way - ");
		list.forEach((l) -> System.out.println(l));
		
		System.out.println("List Value using lambda :: way - ");
		list.forEach(System.out :: println);
		
		
	}

}
