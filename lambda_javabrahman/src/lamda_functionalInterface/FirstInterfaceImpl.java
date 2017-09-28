package lamda_functionalInterface;

public class FirstInterfaceImpl {

	public static void main(String[] args) {
		
		FirstInterface firstInterface = (name) -> {
			System.out.println("Your Name is : "+name);
			return name;
		};
		
		firstInterface.displayName("Manoj");
		
		FirstInterface firstInterface2 = new FirstInterface() {
			
			@Override
			public String displayName(String name) {
				System.out.println("Your Name is : "+name); 
				return name;
				
			}
		};
		firstInterface2.displayName("Manoj");
	}

}
