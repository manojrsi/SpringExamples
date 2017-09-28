package functionalInterface;

@FunctionalInterface
public interface WorkerInterface {
	
	void doSomething();
	default void doSomething2(){};

}
