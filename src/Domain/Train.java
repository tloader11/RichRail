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
	
	public void delParts(int index) {
		this.parts.remove(index);
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
