package LinkedList;

import java.util.Scanner;

public class insertNodeRecursivelyAtithPosition {
    public static Node<Integer> insertRecursively(Node<Integer> head, int position, int element) {
        if (position == 0) {
            Node<Integer> newNode = new Node<Integer>(element);
            newNode.next = head;
            return newNode;

        }
        head.next = insertRecursively(head.next, position - 1, element);
        return head;

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        NodeInput Input = new NodeInput();
        Node<Integer> head = Input.input();
        System.out.println("ORIGINAL NODE");
        NodePrint Print = new NodePrint();
        Print.print(head);
        System.err.println();
        System.err.print("Enter Node positon at which inserted : ");
        int pos = sc.nextInt();
        System.err.println();
        System.err.print("Enter element : ");
        int element = sc.nextInt();
        System.err.println();
        System.out.println("AFTER INSERTING NODE");

        Print.print(insertRecursively(head, pos, element));

    }
}
