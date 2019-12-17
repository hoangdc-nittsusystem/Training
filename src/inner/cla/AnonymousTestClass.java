package inner.cla;

abstract class Human {
	abstract void run();
}

interface Person {
	abstract void run();
}

public class AnonymousTestClass {
	public static void main(String[] args) {
		Human human = new Human() {
			void run() {
				System.out.println("human running");
			}
		};
		human.run();
		Person person = new Person() {
			public void run() {
				System.out.println(" person running");
			}
		};
		person.run();
	}
}
