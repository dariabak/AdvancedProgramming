import java.util.ArrayList;


public class Student {
String name;
ArrayList<UnitMark> stuMarks;

public Student(String name) {
	this.name = name;
}

public void setMarks(ArrayList<UnitMark> arrayList) {
	stuMarks = new ArrayList<UnitMark>(arrayList);
}
public double calculateOverallGrade() {
	double overallGrade = 0;
		for(int i = 0; i < stuMarks.size(); i++) {
		overallGrade += stuMarks.get(i).calculateUniGrade();
	}
	return overallGrade/stuMarks.size();
}
}
