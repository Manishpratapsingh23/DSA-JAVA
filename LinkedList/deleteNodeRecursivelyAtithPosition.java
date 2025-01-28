package LinkedList;

import java.util.Scanner;

public class deleteNodeRecursivelyAtithPosition {
    public static Node<Integer> deleteRecursively(Node<Integer> head, int position) {
        if (head == null)
            return head;
        if (position == 0) {
            return head.next;
        }
         
        head.next= deleteRecursively(head.next, position - 1);
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
        System.err.print("Enter Node positon at which deleted : ");
        int pos = sc.nextInt();
        System.err.println();
        System.out.println("AFTER DELETTING NODE");

        Print.print(deleteRecursively(head, pos));

    }
}
