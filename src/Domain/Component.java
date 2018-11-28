package Domain;

public class Component {
	protected String type;
	protected int id;
	


	@Override
	public String toString() {
		String s = type + ","+id;
		return s;
	}
	

}
