package methodReferenceJavaTPoint;

public class MethodReference5 {

	public static void main(String[] args) {

		PrintSay printSay = new PrintSay();
		
		//Using predefined object printSay
		Say say = printSay :: saySomething;
		say.say();
		
		//Using new object
		Say say2 = new PrintSay() :: saySomething2;
		say2.say();
		
		//Using new object
		Say say3 = new MethodReference5() :: saying;
		say3.say();
		
	}

	
	public void saying() {
		System.out.println("Saying...");
	}
}

interface Say {
	void say();
}

class PrintSay {
	
	public void saySomething() {
		System.out.println("Saying something...");
	}
	
	public void saySomething2() {
		System.out.println("Saying something2...");
	}
	
}
