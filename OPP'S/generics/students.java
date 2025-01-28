package generics;

import generics.printInterface;

public class students implements printInterface {
    private int roll;

    public students(int roll) {
        this.roll = roll;
    }

    @Override
    public void print() {
        System.out.println("Student Roll Number: " + roll);
    }
}
// package generics;

// import generics.printInterface;

// public class students implements printInterface {
// private int roll;

// public students(int roll) {
// this.roll = roll;
// }

// @Override
// public void print() {
// System.out.println("Student Roll Number: " + roll);
// }
// }
