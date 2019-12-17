/**
 * 
 */
package com.nittsu;

/**
 * @author hoangdc
 *
 */
public class HelloWorld {
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
	
	public static void main(String[] args) {
		System.out.println("123123213");
		HelloWorld hl = new HelloWorld(1, 1.23F);
		System.out.println(hl.test);
	}
}
