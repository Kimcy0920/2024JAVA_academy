package dp2;

import java.util.Vector;

import dp.Student;

public class Course {
	private Vector<Transcript> transcripts;
	private String name;

	public Course(String name) {
		super();
		this.transcripts = new Vector<Transcript>();
		this.name = name;
	}
	
	public void addTranscript(Transcript transcript) {
		transcripts.add(transcript);
	}

	
	
	public Vector<Transcript> getTranscripts() {
		return transcripts;
	}

	public void setTranscripts(Vector<Transcript> transcripts) {
		this.transcripts = transcripts;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
