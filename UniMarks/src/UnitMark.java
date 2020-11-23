import java.util.ArrayList;

public class UnitMark {
	
int coursework1;
int coursework2;


public UnitMark(int cw1, int cw2) {
	this.coursework1 = cw1;
	this.coursework2 = cw2;
}

public double calculateUniGrade() {
	double grade;
	grade = coursework1*0.5 + coursework2*0.5;
	return grade;
}
public String calculateUnitClassification() {
	String classification;
	double grade = coursework1*0.5 + coursework2*0.5;
	if(grade >= 70) {
		classification = "I";
	} else if(grade < 70 && grade >= 60) {
		classification = "II(I)";
	} else if(grade < 60 && grade >= 50) {
		classification = "II(II)";
	} else if(grade < 50 && grade >= 40) {
		classification = "III";
	} else {
		classification = "Fail";
	}
	return classification;
}
}
