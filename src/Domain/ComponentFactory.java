package Domain;

import TrainComponenten.Locomotive;
import TrainComponenten.Wagon;

public class ComponentFactory {
	public Component getShape(String cType){
	      if(cType == null){
	         return null;
	      }		
	      if(cType.equalsIgnoreCase("Locomotive")){
//	         return new Locomotive();
	         
	      } else if(cType.equalsIgnoreCase("Wagon")){
//	         return new Wagon();
	      }
	      
	      return null;
	   }
}
