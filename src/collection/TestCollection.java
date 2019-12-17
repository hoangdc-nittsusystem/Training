package collection;
import java.util.*;


public class TestCollection {
	public class Person {
		public Person (String name){
			this.name = name;
		}
		public String name;
	}
	
	public static void main(String[] args) {
//		String test1 = "qer123";
//		String test2 = new String(test1);
//		System.out.println(test1.equals(test2));
		
		List<Person> listPerson = new ArrayList<Person>();
		
		listPerson.add(new TestCollection().new Person("Hoang"));
		listPerson.add(new TestCollection().new Person("Dao"));
		listPerson.add(new TestCollection().new Person("Cong"));
		
		System.out.println(listPerson);
		
		HashSet<String> hs = new HashSet<String>();
		hs.add("Hoang");
		hs.add("Dao");
		hs.add("Cong");
		hs.add(null);
		
		System.out.println(hs.contains(null));
		
		TreeSet<String> ts = new TreeSet<String>();
//		ts.add(null);
		ts.add("Dao");
		ts.add("Cong");
		ts.add("Hoang");
		
		System.out.println(ts.contains("Dao"));
		
		HashMap<Integer, String> hm = new HashMap<Integer, String>();
		hm.put(0, "Hoang");
		hm.put(1, "Dao");
		hm.put(-1, "Cong");
		hm.put(null, "Hoang");
		
		System.out.println(hm);
		
		TreeMap<Integer, String> tm = new TreeMap<Integer, String>();
//		tm.put(null, "Hoang");
	}
}
