/**
 * 
 */
package com.nittsu;

/**
 * @author hoangdc
 *
 */
public class HelloWorld extends Hello1{
	protected int test = 0;
	public String name = "12312421";
	private String sameClass = "123";
	float flt = 0.3F;
	
	public HelloWorld() {
		
	}
	
	HelloWorld(int test, float flt) {
		this.test = test;
		this.flt = flt;
	}
	
	protected void sout() {
		System.out.println(test);
		System.out.println(this.sameClass);
	}
	
	
	public int sum( int a, int b) {
		return a + b;
	}
	
	public static void main(String[] args) {
		System.out.println("123123213");
		HelloWorld hl = new HelloWorld(1, 1.23F);
		System.out.println(hl.test);
		hl.run();
		hl.b = 1;
//		hl.sum(1, null);
	}
}


class Hello1 {
	public static int a;
	int b;
	public static void run() {
		System.out.println("hello1");
	}
	
	final void test() {
		
	}
}