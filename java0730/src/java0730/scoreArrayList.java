package java0730;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;

public class scoreArrayList {

	public static void main(String[] args) {
		String URL = "jdbc:mysql://localhost:3307/spring5fs";
		List<Score> list = new ArrayList<>();
		
		// 기존의 코드들을 try()안에 넣어 Close를 안해도됨
		try (Connection conn = DriverManager.getConnection(URL, "root", "mysql");
			 Statement stmt = conn.createStatement();
			 ResultSet rs = stmt.executeQuery("select * from score")) {
			while(rs.next()) {
				int num = rs.getInt("num");
				String name = rs.getString("name");
				int kor = rs.getInt("kor");
				int eng = rs.getInt("eng");
				int math = rs.getInt("math");
				int sum = kor + eng + math;
				double avg = sum / 3;
				list.add(new Score(num, name, kor, eng, math));
			}
			list.stream().forEach(System.out::println);
			
			System.out.println();
			System.out.println("*****************과목별 총점*****************");
			
			// -------------------------총점-------------------------
			
			// mapToInt - Interger값으로 매핑시켜서 sum으로 보내 더한 걸 korSum으로 보냄
			int korSum = list.stream().mapToInt(s->s.getKor()).sum(); 
			System.out.print("국어: " + korSum + "점\t");
			
			int engSum = list.stream().mapToInt(s->s.getEng()).sum();
			System.out.print("영어: " + engSum + "점\t");
			
			int mathSum = list.stream().mapToInt(s->s.getMath()).sum();
			System.out.print("수학: " + korSum + "점\n");
			
			System.out.println("******************************************");
			System.out.println();
			
			// -------------------------평균-------------------------
			
			// 
			OptionalDouble korAvg = list.stream().mapToInt(s->s.getKor()).average();
			korAvg.ifPresent(avg->System.out.println("국어 평균: " + avg));
			
			OptionalDouble engAvg = list.stream().mapToInt(s->s.getEng()).average();
			engAvg.ifPresent(avg->System.out.println("영어 평균: " + avg));
			
			OptionalDouble mathAvg = list.stream().mapToInt(s->s.getMath()).average();
			mathAvg.ifPresent(avg->System.out.println("수학 평균: " + avg));
			// average는 double형 안됨
			// ifPresent는 존재하는지 유무
			
			// mapToInt - 전체 과목별 총합을  sum - 다 더한 후 totalSum으로 보냄
			int totalSum = list.stream().mapToInt(s->s.getKor()+s.getEng()+s.getMath()).sum();
			System.out.println("총점: " + totalSum);

			OptionalDouble totalAvg = list.stream().mapToDouble(s->s.getAvg()).average();
			totalAvg.ifPresent(avg->System.out.println("전체 평균: " + avg));
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
