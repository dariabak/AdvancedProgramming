import java.util.ArrayList;
import java.util.Random;

public class Marks {
	static ArrayList<Student> students = new ArrayList<Student>();
	
	public static int getRandom(){
		   Random r = new Random();
		   int high = 100;
		   int result = r.nextInt(high);
		   return result;
		}

	public static void main(String[]args) {
		
		Student stu1 = new Student("John");
		Student stu2 = new Student("Will");
		Student stu3 = new Student("Georgie");
		Student stu4 = new Student("Chris");
		
		students.add(stu1);
		students.add(stu2);
		students.add(stu3);
		students.add(stu4);
		
		for(int i = 0; i < students.size(); i++) {
			ArrayList<UnitMark> marks = new ArrayList<UnitMark>();
			UnitMark unit1 = new UnitMark(getRandom(),getRandom());
			UnitMark unit2 = new UnitMark(getRandom(),getRandom());
			UnitMark unit3 = new UnitMark(getRandom(),getRandom());
			UnitMark unit4 = new UnitMark(getRandom(),getRandom());
			marks.add(unit1);
			marks.add(unit2);
			marks.add(unit3);
			marks.add(unit4);
			
			students.get(i).setMarks(marks);
		
		}
		
		for(int j = 0; j < students.size(); j++) {
			System.out.println(students.get(j).name + " " + students.get(j).calculateOverallGrade());
		}
		
	}
}
;