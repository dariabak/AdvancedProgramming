import java.util.ArrayList;

public class Unit {
	Lecturer lecturer = new Lecturer("",0);
	ArrayList<Student> students = new ArrayList<Student>();
	String title;

	public Lecturer getLecturer() {
		return lecturer;
	}
	
	public void setLecturer(Lecturer l) {
		this.lecturer = l;
	}
	
	public void enrolStudent(Student s) {
		students.add(s);
	}
	
	public void removeStudent(Student s) {
		students.remove(s);
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String t) {
		this.title = t;
	}
}
