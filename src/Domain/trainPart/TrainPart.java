package Domain.trainPart;

public class TrainPart {
	private TrainPartType type;

	public TrainPart(TrainPartType type) {
		this.type = type;
	}
	
	public TrainPart() {
		this.type = null;
	}

	public String getType() {
		return type.getType();
	}

	public void setType(TrainPartType type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return type.getType();
	}
	
	
	
	
	
	
	

}
