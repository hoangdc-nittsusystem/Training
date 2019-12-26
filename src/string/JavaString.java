package string;

public class JavaString {

	public static void main(String[] args) {
		String str1 = "abc";
		String str2 = "abc";
		String str3 = new String("Dao Cong Hoang");

		str1 = "qwe";

		System.out.println(str3.substring(0, 3));
		System.out.println(str3.contains("Dao Con"));

		StringBuffer sb1 = new StringBuffer("Hello");
		sb1.replace(1, 3, "Jav");
		System.out.println(sb1);// in -> HJavalo

		StringBuffer sb = new StringBuffer();
		System.out.println(sb.capacity());// mặc định là 16
		sb.append("Hello");
		System.out.println(sb.capacity());// đến đây vẫn là 16
		sb.append("java is my favourite language");
		System.out.println(sb.capacity());// đến đây là (16*2)+2=34 i.e (dung lượng cũ*2)+2
		System.out.println(sb.toString().toLowerCase());
		System.out.println(sb.append(13));

	}

}
