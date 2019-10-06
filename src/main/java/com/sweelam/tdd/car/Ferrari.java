package com.sweelam.tdd.car;

public class Ferrari implements Car {

	public boolean needFuel() {
		// TODO Auto-generated method stub
		return false;
	}

	public String driveTo(String dist) {
		if (needFuel())
			return dist;
		else
			return "Helwan is the default";
	}

}
