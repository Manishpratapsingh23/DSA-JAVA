// Car.java
package vehicle;

public class Car extends Vehicle {
	int numGears;
	boolean isConvertible;

	public Car(int carType, int vehicleType) {
		super(vehicleType);
		this.type = carType; // Using the inherited `type` field
	}

	public void print() {
		super.print();
		System.out.println("Car numGears : " + numGears);
		System.out.println("Car isConvertible : " + isConvertible);
		System.out.println("Car Type: " + this.type); // Refers to the inherited `type`
	}
}
