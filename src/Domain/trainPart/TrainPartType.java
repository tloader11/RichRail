package Domain.trainPart;

public abstract class TrainPartType {
	protected String type;
	protected int zitPlaatsen = 0;
	
	public String getType() {
		return type;
	}

	public int getZitPlaatsen() {
		return zitPlaatsen;
	}

	public void setZitPlaatsen(int zitPlaatsen) {
		this.zitPlaatsen = zitPlaatsen;
	}
	
	
	
	



}
