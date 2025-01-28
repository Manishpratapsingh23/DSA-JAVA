package generics;

import final_keyword.Vehicle;
import generics.students;
import generics.printInterface;

public class Print {
    // Generic method
    public static <T extends students, Vehicle> void printArray(T[] a) {
        for (int i = 0; i < a.length; i++) {
            a[i].print();
            // System.out.print(a[i]);
            System.out.print(" ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Integer[] arr = new Integer[10];
        // for (int i = 0; i < 10; i++) {
        // arr[i] = i + 1;
        // }
        // printArray(arr);

        // Character[] ch = new Character[10];
        // for (int i = 0; i < 10; i++) {
        // ch[i] = (char) (i + 65);
        // }
        // printArray(ch);

        Vehicle[] v = new Vehicle[10];
        for (int i = 0; i < 10; i++) {
            v[i] = new Vehicle(10);
        }
        printArray(v);

        students s1[] = new students[10];
        for (int i = 0; i < 10; i++)
            s1[i] = new students(10);

        printArray(s1);

    }
}

// package generic;

// import final_keyword.Vehicle;
// import generics.students;
// import generics.printInterface;

// public class Print {
// // Generic method
// public static <T extends printInterface> void printArray(T[] a) {
// for (T element : a) {
// element.print();
// System.out.print(" ");
// }
// System.out.println();
// }

// public static void main(String[] args) {
// // Creating and printing Vehicle array
// Vehicle[] v = new Vehicle[10];
// for (int i = 0; i < v.length; i++) {
// v[i] = new Vehicle(i * 10);
// }
// printArray(v);

// // Creating and printing students array
// students[] s1 = new students[10];
// for (int i = 0; i < s1.length; i++) {
// s1[i] = new students(i + 1);
// }
// printArray(s1);
// }
// }
