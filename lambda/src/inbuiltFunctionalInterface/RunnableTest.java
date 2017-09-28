package inbuiltFunctionalInterface;

public class RunnableTest {
	public static void main(String args[]) {

		//		Runnable runnable = () -> {
		//			System.out.print("Run Method is invoked");
		//			System.out.println("Sub Thread Name : "+Thread.currentThread().getName());
		//		};
		//		Thread thread = new Thread(runnable);
		//		thread.setName("Sub-Thread");
		//		thread.start();

		//Creating and starting thread using Lambda expression
		//new Thread(() -> System.out.println("Thread Current Name Using Lambda : "+Thread.currentThread().getName())).start();;

		new Thread(() -> {
			//Here we cannot set Thread Name, Question : Can we set using Lambda?
			System.out.println("Thread Current Name Using Lambda : "+Thread.currentThread().getName());
		}).start();;
				
		System.out.println("Current Thread Name : "+Thread.currentThread().getName());

	}

}
