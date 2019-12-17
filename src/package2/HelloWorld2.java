/**
 * 
 */
package package2;
import com.nittsu.HelloWorld;

/**
 * @author hoangdc
 *
 */
public class HelloWorld2  extends HelloWorld{

	HelloWorld2() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		System.out.println(this.test);
		System.out.println("tda");
//		HelloWorld helloWorld2 = new HelloWorld();
//		helloWorld2.main(args);
//		System.out.println(helloWorld2.name);
//		helloWorld2.demo();
	}
	
	public void demo() {
		// TODO Auto-generated method stub
		System.out.println(this.test);
		System.out.println("tda");
		this.sout();
	}
	
	public void demo2() {
		// TODO Auto-generated method stub
		demo();
		System.out.println("tda");
		HelloWorld helloWorld = new HelloWorld();
//		System.out.println(helloWorld.flt);
	}

	public void sout() {
		System.out.println("11111");
	}
}
