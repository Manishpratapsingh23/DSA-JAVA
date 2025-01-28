package final_keyword;

import generics.printInterface;

public final class Vehicle implements printInterface {
	protected String color;
	private int maxSpeed;

	public Vehicle(int maxSpeed) {
		this.maxSpeed = maxSpeed;
	}

	public int getMaxSpeed() {
		return maxSpeed;
	}

	public void setMaxSpeed(int maxSpeed) {
		this.maxSpeed = maxSpeed;
	}

	@Override
	public final void print() {
		System.out.println("Vehicle Color : " + color);
		System.out.println("Vehicle Speed : " + maxSpeed);
	}
}
// package final_keyword;

// import generics.printInterface;

// public class Vehicle implements printInterface {
// private String color;
// private int maxSpeed;

// public Vehicle(int maxSpeed) {
// this.maxSpeed = maxSpeed;
// this.color = "Red"; // Default color
// }

// @Override
// public void print() {
// System.out.println("Vehicle Speed: " + maxSpeed + ", Color: " + color);
// }
// }
