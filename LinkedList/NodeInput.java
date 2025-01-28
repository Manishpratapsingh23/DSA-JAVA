package LinkedList;

import java.util.Scanner;

public class NodeInput {
    public static Node<Integer> input() {
        System.out.println("Enter node data");
        Scanner sc = new Scanner(System.in);
        Node<Integer> head = null, tail = null;
        int data = sc.nextInt();
        while (data != -1) {
            Node<Integer> newNode = new Node<Integer>(data);
            if (head == null) {
                head = newNode;
                tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;

            }
            data = sc.nextInt();
        }
        return head;
    }
}