import java.util.Scanner;

public class Node6use {

    public static void print(Node<Integer> head) {
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
        System.out.println();
    }

    public static void increment(Node<Integer> h1) {

        h1.data++;
    }

    public static void increment1(Node<Integer> h2) {
        h2 = new Node<Integer>(100);
        h2.data++;
    }

    public static void main(String[] args) {
        Node<Integer> node1 = new Node<>(10);
        Node<Integer> node2 = new Node<>(20);
        Node<Integer> node3 = new Node<>(30);
        node1.next = node2;
        node2.next = node3;
        Node<Integer> h1 = node1;
        Node<Integer> node4 = new Node<>(10);
        Node<Integer> node5 = new Node<>(20);
        Node<Integer> node6 = new Node<>(30);
        node4.next = node5;
        node5.next = node6;
        Node<Integer> h2 = node4;
        print(h1);
        increment(h1);
        print(h1);
        print(h2);
        increment1(h2);
        print(h2);
    }
}
