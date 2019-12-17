package inner.cla;

public class InnerStaticClass {
	private static int stInt = 1;
	int norInt = 3;
	String name;
	
	public int localClassMethod() {
		int cnt = 0; 
		final int test1 = 1;
        class WelcomeMessage {
            WelcomeMessage(){
            	norInt = 2;
            	stInt = 3;
//            	cnt = 2;
//            	test1 = 2;
                System.out.println(cnt); //Only use, can't change
            }
            String getMessage() {
            	name = "werwer";
            	norInt = 2;
                return "Welcome";
            }

            void showName(){//Only valid from Java 8
                System.out.println(name);
            }
        }
        WelcomeMessage msg = new WelcomeMessage();
        return 1;
	}
	
	static class StaticNestedClass{
		void test() {
			System.out.println(++stInt);
		}
	}
	
	class NonStaticInnerClass {
		final int tadadfe = 1;
		void test() {
			System.out.println(++stInt);
		}
	}

	public static void main(String[] args) {
//		InnerStaticClass.StaticNestedClass testClass = new InnerStaticClass.StaticNestedClass();
//		testClass.test();
//		
//		NonStaticInnerClass nonStaticInnerClass = new InnerStaticClass().new NonStaticInnerClass(); // because non static class
		InnerStaticClass innerStaticClass = new InnerStaticClass();
		innerStaticClass.localClassMethod();
		
	}
}
