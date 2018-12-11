package Domain;

public class Component {
	protected String type;
	protected int id;
	/**
	 * Custom added
	 */
	protected String name;
	


	@Override
	public String toString() {
		String s = type + ","+id;
		return s;
	}
	

}
