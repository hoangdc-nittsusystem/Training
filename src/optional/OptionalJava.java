package optional;
import java.awt.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Optional;
import java.util.stream.Collectors;

public class OptionalJava {
	public static void main(String[] args) {
		Optional<String> gender = Optional.of("MALE");
        String answer1 = "Yes";
        String answer2 = null;

        System.out.println("Non-Empty Optional:" + gender);
        System.out.println("Non-Empty Optional: Gender value : " + gender.get());
        System.out.println("Empty Optional: " + Optional.empty());

        System.out.println("ofNullable on Non-Empty Optional: " + Optional.ofNullable(answer1));
        System.out.println("ofNullable on Empty Optional: " + Optional.ofNullable(answer2));
//        System.out.println(Optional.of(answer2));
        
        String[] words = new String[10];   
        words[5] = "";
        if (words[5].isEmpty()) {
        	System.out.println(1);
        } else {
        	System.out.println(2);
        }
//        String word = words[5].toLowerCase();   
//        System.out.print(word); 

        Integer int1 = new Integer(1);
        Integer int2 = null;
//        System.out.println(int1 + int2);
        
        Optional<Integer> opt1 = Optional.of(int1);
        Optional<Integer> opt2 = Optional.ofNullable(int2);
        Optional<Integer> opt3 = Optional.empty();
        Optional<ArrayList<Integer>> optList = Optional.ofNullable(new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4)));
        
        System.out.println(opt3.orElse(new Integer(20)));
        
        opt1.map(value -> value + 1);
        System.out.println(opt1.filter(item -> item > 1));
        System.out.println(opt1.map(item -> item + 1));
        System.out.println(opt1);
        System.out.println(optList.map(element -> element.size()) );
        System.out.println(optList.get().stream().map(element -> element + 1).collect(Collectors.toList()));
        System.out.println(Optional.of(new Integer(1)).get());
        
        System.out.println(Optional.empty().isPresent());
        
        Optional.empty().ifPresent(value -> System.out.println(value));
        Optional.of(new Integer(1111)).ifPresent(value -> System.out.println(value));
        
        OptionalJava oj = new OptionalJava();
        System.out.println(oj.calculateAverage(1, 2, null));
        
//        System.out.println(Optional.empty().orElseThrow( () -> new ArithmeticException() ) ); 
	}
	
	public Optional<Double> calculateAverage(Integer... params) {
		System.out.println(params.length);
//		Integer a = null;
//		int a = null;
		boolean check = Arrays.asList(params).stream().allMatch(a -> a != null && a >= 0 && a <= 10);
		
		if (check) {
			return Optional.of( (double) Arrays.asList(params).stream().reduce(0, (a, b) -> a + b).intValue() / params.length);
		} else {
			return Optional.empty();
		}
		
	}
}
