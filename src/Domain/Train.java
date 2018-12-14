package Domain;

import java.util.ArrayList;
import java.util.List;

import DataSource.DataHandler;
import DataSource.FileHandler;
import Domain.trainPart.*;
public class Train {
	private DataHandler dh = new FileHandler();
	String code;
	List<TrainPart> parts;
	
	public Train(String code) {
		this.code = code;
	this.parts = new ArrayList<TrainPart>();	
	dh.addTrain(this);
	}
	
	public int getTrainSize() {
		return this.parts.size();
	}
	
	public String getCode() {
		return code;
	}



	public void setCode(String code) {
		this.code = code;
	}



	public void addParts(TrainPart trainpart) {
		this.parts.add(trainpart);
	}
	
	public void delParts(String part) {		
		for (int i = 0 ; i <  this.parts.size(); i++) {
            if(this.parts.get(0).toString().equals(part.toString())) {
            	System.out.println(this.parts.get(i).toString());
            	this.parts.remove(i);
            	break;
            }       
		}
		
		System.out.println(this.parts);
	}
	
	
	
public List getPartsTypes() {
	List l = new ArrayList();

	for (Object o : parts) {
		l.add(o.toString());
	}
		return this.parts;
	}

@Override
public String toString() {
	return "Train [code=" + code + ", parts=" + parts + "]";
}





}
