import java.util.ArrayList;

public class Student extends Person{
	ArrayList<Unit> takesUnit = new ArrayList<Unit>();
	
	public Student(String name,int id) {
		super.setName(name);
		super.setIdNumber(id);
	}
	
	public void takesUnit(Unit u) {
		takesUnit.add(u);
	}
	
	public void dropUnit(Unit u) {
		takesUnit.remove(u);
	}
	
	public ArrayList<Unit> getAllUnitsTaken(){
		return takesUnit;
	}
}
