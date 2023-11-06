package com.code;

public enum serviceplan {

	

	MONTHLY(3000),QUARTELY(11700),HALFYEAR(17500),YEARLY(32000);
	
	private serviceplan(double cost) {
		this.cost = cost;
	}

	private double cost;

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}
	
	
}

