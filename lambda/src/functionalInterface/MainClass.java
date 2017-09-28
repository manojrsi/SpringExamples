package functionalInterface;

public class MainClass {

	public static void main(String[] args){
		
		execute(() -> {
			System.out.println("Worker Invoked using Lambda Expression.");
		});
		
		execute(new WorkerInterface() {
			@Override
			public void doSomething() {
				System.out.println("Worker Invoked using Anonymous Class.");
			}
		});	
	}
	
	public static void execute(WorkerInterface workerInterface) {
		workerInterface.doSomething();
	}
}
