package lamda_functionalInterface;

public class FunctionalInterfaceTest {
	public static void main(String[] args) {
		Sayable say = (msg) -> System.out.println("Message is "+msg);
		say.say("hi");
		
		FunctionalInterfaceTest functionalInterfaceTest = new FunctionalInterfaceTest();
		functionalInterfaceTest.callSay((msg) -> System.out.println("Message is: Hi '"+msg+"'"));
		
	}
	
	void callSay(Sayable s){
		System.out.println("++ callSay method called ");
		s.say("Manoj");
	}
	
}

interface Readable {  
    // Invalid '@FunctionalInterface' annotation; doable is not a functional interface  
   // void doIt();  
	
//	default void haveIt(){
//		System.out.println("default function HaveIt() called ");
//	}
}  

@FunctionalInterface
interface Sayable extends Readable{
    // Invalid '@FunctionalInterface' annotation; Invalid is not a functional interface or Readable contains a abstract method
	
	public void say(String msg);
	
    // It can contain any number of methods of Object class.  
    int hashCode();  
    String toString();  
    boolean equals(Object obj);  
}

