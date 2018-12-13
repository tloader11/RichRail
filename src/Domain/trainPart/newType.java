package Domain.trainPart;

import DataSource.DataHandler;
import DataSource.FileHandler;

public class newType extends TrainPartType {
	private DataHandler dh = new FileHandler();

	public newType(String typeCode, int zitPlaatsten) {
		super();
		super.type = typeCode;
		super.zitPlaatsen = zitPlaatsten;
		dh.addRollerType(typeCode, zitPlaatsten);
			}
	


	public newType(String typeCode) {
		super();
		super.type = typeCode;
		dh.addRollerType(typeCode, 0);

		

	}

}
