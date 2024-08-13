package file;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@Setter
@ToString
public class FileDTO {
	private int num;
	private String fname;
	private String ftime;
	private int fsize;
}
