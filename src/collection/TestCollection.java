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
		
		List<String> list = new ArrayList<String>();
		
		list.add("Hoang");
		list.add("Dao");
		list.add("Cong");
		list.remove(1);
		list.contains("Cong");
		list.size();
		
		System.out.println(list);
		System.out.println(list.contains("Cong"));
		
		HashSet<String> hs = new HashSet<String>();
		hs.add("Hoang");
		hs.add("Dao");
		hs.add("Cong");
		hs.add(null);
		hs.add(null);
		hs.add("Cong");
		
		System.out.println(hs);
		
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
		hm.put(null, "Hoang1");
		
		hm.remove(null);
		hm.containsKey(0);
		hm.containsValue("Dao");
		hm.size();
		
		System.out.println(hm);
		
		TreeMap<Integer, String> tm = new TreeMap<Integer, String>();
//		tm.put(null, "Hoang");
		System.out.println(tm);
	}
}
