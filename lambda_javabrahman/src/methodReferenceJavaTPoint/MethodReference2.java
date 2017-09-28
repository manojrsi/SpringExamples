package methodReferenceJavaTPoint;

//Reference to a Static Method
public class MethodReference2 {

	public static void main(String[] args) {
		
		//Lambda way
		Thread threadLambda = new Thread(() -> runImplementation());
		threadLambda.start();
		
		//Method Reference way
		Thread threadMethodReference = new Thread(MethodReference2 :: runImplementation);
		threadMethodReference.start();
		
		//No use but this can be a way
		Thread threadMethodReference2 = new Thread(System.out :: println);
		threadMethodReference2.start();
	}
	
	private static void runImplementation(){
		System.out.println("Thread run is running...");
	}

}
