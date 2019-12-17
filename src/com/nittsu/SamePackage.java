package com.nittsu;
import com.nittsu.HelloWorld;

public class SamePackage {
	
	public static void main(String[] args) {
		System.out.println("fadf asfwer f ");
	}
	
	public void samePackage() {
		HelloWorld hl = new HelloWorld();
//		System.out.println( hl.sameClass);
	}

}

interface Interface1 {
	void run();
}

interface Interface2 {
	public abstract void see();
}

abstract class AbstracClass1 implements Interface1, Interface2 {
	
}