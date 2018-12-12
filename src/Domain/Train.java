package Domain;

import java.util.ArrayList;
import java.util.List;

public class Train {
	String name;
	List componenten;
	
	public Train(String name) {
		this.name = name;
	this.componenten = new ArrayList<Component>();	
	}
	
	public void addComponent(Component c) {
		this.componenten.add(c);
	}
	
	public List getComponenten() {
			return componenten;
		}
	
	@Override
	public String toString() {
		String s = ";";
		for (Object object : componenten) {
			s += object + "," ;
			
		}
	    s = s.substring(0, s.length() - 1);
	
		s+=";";
		return name;
	
	}

}
