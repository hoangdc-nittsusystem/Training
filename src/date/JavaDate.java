package date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;

public class JavaDate {
	public static void main(String[] args) {
		LocalDate ld = LocalDate.now();
		System.out.println(ld.plusDays(1));
		System.out.println(LocalDate.now().plus(1, ChronoUnit.CENTURIES));
		System.out.println(LocalDate.now().getDayOfWeek());
		System.out.println(LocalDate.now().plusMonths(2).isLeapYear());
		
		System.out.println(ZoneId.getAvailableZoneIds());
		System.out.println(LocalTime.now(ZoneId.of("Asia/Ho_Chi_Minh")));
		System.out.println(LocalTime.parse("17:04"));
		System.out.println(LocalTime.of(17, 04));
		
		System.out.println(LocalDateTime.now());
		
		System.out.println(ZonedDateTime.now());
		
	}
}
