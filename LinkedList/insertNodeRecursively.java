package LinkedList;

import java.util.Scanner;

public class insertNodeRecursively {
    public static Node<Integer> insertNode(Node<Integer> head, int pos, int elem) {
        if (pos == 0) {
            Node<Integer> newNode = new Node<>(elem);
            newNode.next = head;
            return newNode;
        }
        if (head == null)
            return head;
        head.next = insertNode(head.next, pos - 1, elem);
        return head;

    }

    public static void main(String args[]) {
        NodeInput Input = new NodeInput();
        Node<Integer> head = Input.input();
        NodePrint Print = new NodePrint();
        System.out.println("Original Node");
        Print.print(head);
        System.out.println();

        Scanner sc = new Scanner(System.in);
        System.out.println("ENTER NODE POSITION");
        int pos = sc.nextInt();
        System.out.println();
        System.out.println("ENTER NODE DATA");
        int el = sc.nextInt();
        System.out.println();

        Node<Integer> newNode = insertNode(head, pos, el);
        System.out.println("Inserted Node");
        Print.print(newNode);
    }
}
