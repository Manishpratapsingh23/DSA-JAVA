package LinkedList;

import java.util.Scanner;

public class rotateNode {
    public static Node<Integer> rotate(Node<Integer> head, int n) {
        if (head.next == null || n <= 0)
            return head;
        Node temp = head;
        while (temp.next != null)
            temp = temp.next;
        temp.next = head;
        temp = head;
        for (int i = 0; i < n - 1; i++)
            temp = temp.next;
        head = temp.next;
        temp.next = null;
        return head;

    }

    public static void main(String[] args) {
        NodeInput Input = new NodeInput();

        Node<Integer> head = Input.input();
        NodePrint Print = new NodePrint();
        System.out.println("Original Node");
        Print.print(head);
        System.out.println();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the node index from where to be rotated");
        int index = sc.nextInt();
        Node<Integer> newNode = rotate(head, index);
        System.out.println("rotated Node");
        Print.print(newNode);

    }
}
