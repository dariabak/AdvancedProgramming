
public class Dog extends Pet implements Strokeable{
	
	public void stroke() {
		System.out.println(super.name + " enjoys being stroked");
		makeNoise();
	}
	@Override
	void makeNoise() {
		System.out.println(super.name + " makes: hau");
	}

}
