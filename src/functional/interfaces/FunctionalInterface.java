package functional.interfaces;

public class FunctionalInterface {
	public static void main(String args[]) {
		int a = 5;

		// lambda expression to define the calculate method
		Square s = (x, y) -> {
			int ab = 0;
			return x * x;
			};

		// parameter passed and return type must be
		// same as defined in the prototype
		int ans = s.calculate(a, a);
		System.out.println(ans);
		
		Rectangle rect = (x, y) -> "";
		
//		Supplier<>
		
	}
}

interface Square {
	int calculate(int x, int y);
}

interface Rectangle {
	String calculate(int x, int y);
}

class Person {
	int age;
	String name;
	public Person (int age, String name) {
		this.age = age;
		this.name = name;
	}
}