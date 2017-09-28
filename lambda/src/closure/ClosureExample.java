package closure;

public class ClosureExample {

	public static void main(String[] args) {
		int j = 20;// In jdk 1.7, i value should be final
		process(5, (i) -> System.out.println(i+j));
	}
	
	private static void process(int a, Process p){
		p.process(a);
	}
}

interface Process{
	
	void process(int i);
	
}
