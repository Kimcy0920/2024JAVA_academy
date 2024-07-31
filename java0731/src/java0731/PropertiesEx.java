package java0731;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URLDecoder;
import java.util.Properties;

public class PropertiesEx {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		Properties properties = new Properties(); // HashMap의 하위 클래스
		String path = PropertiesEx.class.getResource("database.properties").getPath(); // PropertiesEx.class.getResource() 
		path = URLDecoder.decode(path, "utf-8");
		System.out.println(path);
		properties.load(new FileReader(path)); // FileReader: 캐릭터 단위의 IO
		String driver = properties.getProperty("driver");
		System.out.println("드라이버: " + driver);
		String username = properties.getProperty("username"); // username키의 값 가져오기
		System.out.println("사용자명: " + username);
	}

}

/*
	p.506 예제 대체
	
	database.properties 파일 내용
	
	[Key = value]
	driver=oracle.jdbc.OracleDirver
	url=jdbc:oracle:thin:@localhost:1521:orcl
	username=aaa
	password=tiger
 */