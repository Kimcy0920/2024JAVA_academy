package java0725;
// p.495 equals() method

public class Member {
	String id;
	
	Member(String id) {
		this.id = id;
	}

	@Override
	public boolean equals(Object obj) { // Object -> equals 메소드를 재정의 함
		if (obj instanceof Member) { // 객체 instanceof 타입
			Member member = (Member) obj; // 강제 형 변환
			
			if (id.equals(member.id)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public int hashCode() {
//		return super.hashCode();
		return id.hashCode();
		// String은 이미 hashCode 재정의가 되어있어서 id.hashCode(); 작성
	}
	
}
