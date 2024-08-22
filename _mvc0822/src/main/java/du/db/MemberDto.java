package du.db;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@ToString
@Getter
@Setter
public class MemberDto {
	private int member_id;
	private String name;
	private String email;
	private String password;
	private String create_at;
}
