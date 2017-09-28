package lamda_functionalInterface;

public class FirstInterfaceImplAsMethodParam {

	public static void main(String[] args) {
		FirstInterfaceImplAsMethodParam asMethodParam = new FirstInterfaceImplAsMethodParam();
		asMethodParam.printDisplayName(name -> {
			System.out.println("Name is "+name);
			return name;
		});
	}


	private String printDisplayName(FirstInterface firstInterface){
		return firstInterface.displayName("Manoj_Kumar_Singh");
	}

}
