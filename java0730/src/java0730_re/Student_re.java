package java0730_re;

public class Student_re {
	private String name;
	private int score;
	
	public Student_re(String name, int score) {
		super();
		this.name = name;
		this.score = score;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getScore() {
		return score;
	}
	
	public void setScore(int score) {
		this.score = score;
	}
	
	@Override
	public String toString() {
		return "Student_re [name=" + name + ", score=" + score + "]";
	}
	
}
