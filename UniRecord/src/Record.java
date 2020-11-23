import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Record {
	ArrayList<Unit> allUnits = new ArrayList<Unit>();
	ArrayList<Student> allStudents = new ArrayList<Student>();
	
	 Lecturer lKris = new Lecturer("Kris", 1234);
	 Lecturer lDavid = new Lecturer("David", 3456);
	 Lecturer lNick = new Lecturer("Nick", 5678);
	 Lecturer lDarren = new Lecturer("Darren", 7890);
	
	 Unit unitAP = new Unit();
	 Unit unitAaDS = new Unit();
	 Unit unitP = new Unit();
	 Unit unitEP = new Unit();
	 Unit unitSEM = new Unit();
	 Unit unitItMT = new Unit();
	 
	 Student sMohammed = new Student("Mohammed",191234);
	 Student sSoufiene = new Student("Soufiene", 192345);
	 Student sMatthew = new Student("Matthew", 193456);
	 Student sMajdi = new Student("Majdi", 194567);
	 Student sHuw = new Student("Huw", 195678);
	 Student sBob = new Student("Bob", 196789);
	 Student sElaine = new Student("Elaine", 197890);
	 Student sAnnabel = new Student("Annabel", 198901);
	 Student sSusan = new Student("Susan", 199012);
 
	public Record() {
		unitAP.setTitle("Advanced Programming");
		unitAaDS.setTitle("Algorithms and Data Structures");
		unitP.setTitle("Programming");
		unitEP.setTitle("Enterprise Programming");
		unitSEM.setTitle("Software Engineering Methodologies");
		unitItMT.setTitle("Introduction to Matthew-Taming");
		
		allUnits.add(unitAP);
		allUnits.add(unitAaDS);
		allUnits.add(unitP);
		allUnits.add(unitEP);
		allUnits.add(unitSEM);
		allUnits.add(unitItMT);
		
		allStudents.add(sMohammed);
		allStudents.add(sSoufiene);
		allStudents.add(sMatthew);
		allStudents.add(sMajdi);
		allStudents.add(sHuw);
		allStudents.add(sBob);
		allStudents.add(sElaine);
		allStudents.add(sAnnabel);
		allStudents.add(sSusan);
		
	 
		associationsUnitWithLecturer(unitAP,lKris);
		associationsUnitWithLecturer(unitAaDS,lDavid);
		associationsUnitWithLecturer(unitP,lDavid);
		associationsUnitWithLecturer(unitEP,lNick);
		associationsUnitWithLecturer(unitSEM,lDarren);
		associationsUnitWithLecturer(unitItMT,lDarren);
	 
		associationsUnitWithStudent(unitAaDS, sMohammed);
		associationsUnitWithStudent(unitP, sMohammed);
		
		associationsUnitWithStudent(unitAP, sSoufiene);
	 	associationsUnitWithStudent(unitP, sSoufiene);
	 
	 	associationsUnitWithStudent(unitAaDS, sMatthew);
	 	associationsUnitWithStudent(unitP, sMatthew);
	 
	 	associationsUnitWithStudent(unitEP, sMajdi);
	 	associationsUnitWithStudent(unitSEM, sMajdi);
	
	 	associationsUnitWithStudent(unitEP, sHuw);
	 	associationsUnitWithStudent(unitItMT, sHuw);
	 
	 	associationsUnitWithStudent(unitItMT, sBob);
	 	associationsUnitWithStudent(unitEP, sBob);
	 
	
	 	associationsUnitWithStudent(unitP, sElaine);
	 	associationsUnitWithStudent(unitEP, sElaine);
	 
	
	 	associationsUnitWithStudent(unitAaDS, sAnnabel);
	 	associationsUnitWithStudent(unitAP, sAnnabel);
	 

	 	associationsUnitWithStudent(unitItMT, sSusan);
	 	associationsUnitWithStudent(unitAP, sSusan);
	 
 }
  private void associationsUnitWithLecturer(Unit u, Lecturer l) {
	  u.setLecturer(l);
	  l.teachesUnit(u);
  }
  
  private void associationsUnitWithStudent(Unit u, Student s) {
	  u.enrolStudent(s);
	  s.takesUnit(u);
  }
  
  public void bobsUnits() {
	  for(Unit u: sBob.takesUnit) {
		  System.out.println(u.getTitle());
	  }
  }
  
  public void krisStudents() {
	  for(Unit u: lKris.teachesUnit) {
		 for(Student s: u.students) {
			 System.out.println(s.getName() + " " + s.getIdNumber());
		 }
	  }
  }
  
  public void unitWithMoreThanTwoStudents() {
	  for(Unit u: allUnits) {
		  if(u.students.size() > 2) {
			  System.out.println(u.getTitle());
		  }
	  }
  }
  
  public void studentsTaughtByOthers() {
	  Set<Student> students = new HashSet<Student>(allStudents);
	  for(Student s: allStudents) {
		  for(Unit u: s.takesUnit) {
			  if(u.getLecturer() == lKris || u.getLecturer() == lDarren){
					  students.remove(s);
			  }
		  }
	  }
	  for(Student s: students) {
		  System.out.println(s.getName());
	  }
	  
  }
  
  public void mostPopularUnit() {
	  int maxStudents = 0;
	  for(Unit u: allUnits) {
		  if(u.students.size() > maxStudents){
			  maxStudents = u.students.size();
		  }
	  }
	  for(Unit u: allUnits) {
		 if(u.students.size() == maxStudents) {
		  System.out.print(u.getTitle() + ", ");
		 }
	  }
  }
}
