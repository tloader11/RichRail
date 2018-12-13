package Domain.trainPart;

import Domain.systemTtrainPart.Passenger1;
import Domain.systemTtrainPart.Wagon;

public class TrainPartFactory {
	
	public TrainPart makeTrainPart(String type) {
		TrainPart tp = new TrainPart();
		if (type.equalsIgnoreCase("Passenger1")) {
			tp.setType(new Passenger1());	
		}
		else if (type.equalsIgnoreCase("wagon")) {
			tp.setType(new Wagon());
			
		}
		
		else {
		tp.setType(new newType(type));
		}
		
		return tp;
		
		
	}
}
