package thisexample;

public class A5 {
	void m() {
		System.out.println(this);// in ra cung tham chieu ID
	}

	public static void main(String args[]) {
		A5 obj = new A5();
		System.out.println(obj);// in tham chieu ID

		obj.m();
	}

}
