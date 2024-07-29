package java0729;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Ex4 {
	public static void main(String[] args) {
		Date now = new Date(); // 객체 생성, 스레드 사용시 비추천
		System.out.println(now);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd"); // 스레드 사용시 비추천
		// 대문자 MM: 몇 월, 소문자 mm: 몇 분 
		String strNow = sdf.format(now); // 문자열로 바꾸기
		System.out.println(strNow);
		
//		LocalDateTime now2 = LocalDateTime.now(); // static메소드 객체생성x
//		String strNow2 = sdf.format(now2);
//		System.out.println(now2); // SimpleDateFormat 사용 불가능
		
		LocalDateTime now1 = LocalDateTime.now(); // 스레드 사용시 추천
		String strNow1 = DateTimeFormatter.ofPattern("yyyy/MM/dd").format(now1);
		System.out.println(strNow1);
	}
}
