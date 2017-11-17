package model;

public class Treatment {
	private String name;
	private String type;
	private int cost;
	
	public Treatment(String name, String type, int cost) {
		this.name = name;
		this.type = type;
		this.cost= cost;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}
}
