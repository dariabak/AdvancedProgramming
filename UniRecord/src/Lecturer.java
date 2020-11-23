import java.util.ArrayList;

public class Lecturer extends Person{

	ArrayList<Unit> teachesUnit = new ArrayList<Unit>();
	
	public Lecturer(String name, int id) {
		super.setIdNumber(id);
		super.setName(name);
	}
	
	public void teachesUnit(Unit u) {
		teachesUnit.add(u);
	
	}
	
	public void dropUnit(Unit u) {
		teachesUnit.remove(u);
	}
	
	public ArrayList<Unit> getAllUnitsTaught() {
		return teachesUnit;
	}

}
