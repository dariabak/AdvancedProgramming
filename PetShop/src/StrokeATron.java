import java.util.ArrayList;

public class StrokeATron {

	public void strokeAll(ArrayList<Strokeable> array) {
		for(int i = 0; i < array.size(); i++) {
			array.get(i).stroke();
		}
	}
}
