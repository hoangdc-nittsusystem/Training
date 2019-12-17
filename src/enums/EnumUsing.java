package enums;

import enums.Gender;

public class EnumUsing {
	public static void main(String[] args) {

		Gender marryGender = Gender.FEMALE;

		System.out.println("Code: " + marryGender.getCode());
		System.out.println("Text: " + marryGender.getText());

		// Gender[].
		for (Gender gender : Gender.values()) {
			System.out.println(gender);
		}

		String code = "M";
		Gender gender = Gender.getGenderByCode(code);

		System.out.println("Gender by code: " + gender);
	}
}
