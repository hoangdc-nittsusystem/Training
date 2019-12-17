package functional.interfaces;

public class Test1 {
	public static String getStr(String input, int test, StringProcessor processor){
	    return processor.process(input, test);
	}

	public static void main(String[] args) {
	    System.out.println(getStr("Hello Loda!", 1, new StringProcessor() {
	        @Override
	        public String process(String input, int test) {
	            return input.toUpperCase();
	        }
	    }));


	    
	    System.out.println(getStr("Hey Loda!", 1, new StringProcessor() {
	    	private int ab = 0;
	        @Override
	        public String process(String input, int test) {
	        	
	            return input.toLowerCase();
	        }
	    }));
	    
	    System.out.println(getStr("Hello Loda!", 1, (input, id) -> { return input.toUpperCase();}));
	}
}


interface StringProcessor {
	public String process(String input, int test);
	
}