package TaskLayer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import DataSource.DataHandler;
import DataSource.FileHandler;
import Domain.trainPart.TrainPartType;
import Domain.trainPart.newType;

public class TrainPartController {
	private DataHandler dh = new FileHandler();

	public TrainPartType CreatePartType(String code, int zitplaats) {
		TrainPartType tpt = new newType(code, zitplaats);
		return tpt;
	}

	public void delPartType(String type) {

		dh.delType(type);

	}

	public List selectPartTypes() {
		// the format will be [type,typeZitplaatsen,nextType,nextTypeZitplaatsen]
		return dh.selectAllTypes();

	}

	public int selectZitplaats(String code) throws FileNotFoundException, IOException {
		TrainPartType tpt = dh.selectType(code);
		return tpt.getZitPlaatsen();
	}
}
