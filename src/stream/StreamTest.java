package stream;
import java.util.List;
import java.util.OptionalInt;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.*;

public class StreamTest {
	
	public static void main(String[] args) {
		ArrayList<Integer> listInt = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5));
		System.out.println(listInt);
		
		List<Integer> listInt1 = Arrays.asList(1, 2, 3, 4, 5);
//		listInt1.add(1);
		
	
		List<Student> studentList = new ArrayList<>();
        studentList.add(new Student("Nam", 8));
        studentList.add(new Student("Hoang", 5));
        studentList.add(new Student("Nga", 4));

//        List<Student> goodStudent = studentList.stream().filter(st -> st.getPoint() > 5).collect(Collectors.toList());

        System.out.println("Old list: " + studentList.size());
//        System.out.println("New list: " + goodStudent.size());

        List<String> items = new ArrayList<String>();
        items.add("one");
        items.add("two");
        items.add("three");
        items.add("fore");
        items.add("five");
        
        Stream<String> stream = items.stream();
        
        String[] languages = { "Java", "C#", "C++", "PHP", "Javascript" };
        Stream<String> stream2 = Arrays.stream(languages);
        
        System.out.println(stream2);
        
        System.out.println(stream2.map(x -> x.toUpperCase()).collect(Collectors.toSet()));
        
        System.out.println(Arrays.stream(languages).filter(x -> x.equals("Java")).collect(Collectors.toList()));
        
        Stream<String> stream3 = Arrays.stream(languages);
        System.out.println(stream3.sorted( (item1, item2) -> {
        	return item2.compareTo(item1);
        }).collect(Collectors.toList()));
        
        System.out.println("skip and limit");
        Stream<String> stream4 = Arrays.stream(languages);
        System.out.println(stream4.skip(1).limit(10).collect(Collectors.toList()));
        
        System.out.println("forEach");
        Stream<String> stream5 = Arrays.stream(languages);
        stream5.forEach( item -> {
        	System.out.println(item);
        });
        
        System.out.println("collect");
        Stream<String> stream6 = Arrays.stream(languages);
        System.out.println(stream6.collect(Collectors.toList()));
        
        System.out.println("reduce");
        Stream<String> stream7 = Arrays.stream(languages);
        System.out.println(stream7.reduce("", (str1, str2) -> str1 + " " + str2));
        
        OptionalInt result = IntStream.of().reduce( (a, b) -> a + b);
        System.out.println(result); // 10
	}
}

class Student {
	String name;
	int age;
	
	Student (String name, int age){
		this.name = name;
		this.age = age;
	}
}