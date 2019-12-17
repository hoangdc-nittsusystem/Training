package stream;
import java.util.List;
import java.util.ArrayList;

public class StreamTest {
	
	public static void main(String[] args) {
		List<Student> studentList = new ArrayList<>();
        studentList.add(new Student("Nam", 8));
        studentList.add(new Student("Hoang", 5));
        studentList.add(new Student("Nga", 4));

//        List<Student> goodStudent = studentList.stream().filter(st -> st.getPoint() > 5).collect(Collectors.toList());

        System.out.println("Old list: " + studentList.size());
//        System.out.println("New list: " + goodStudent.size());

		// result
//		Old list: 3
//		New list: 1
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