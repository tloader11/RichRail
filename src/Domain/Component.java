package Domain;

public class Component {
	protected String type;
	protected int id;
	/**
	 * Custom added
	 */
	protected String name;
	


	public Component( String name,String type) {
		super();
		this.type = type;
		this.name = name;
	}

	@Override
	public String toString() {
		String s = type + ","+id;
		return s;
	}
	

}
