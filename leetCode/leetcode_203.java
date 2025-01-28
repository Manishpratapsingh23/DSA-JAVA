package leetCode;

import java.util.Scanner;
import java.util.Stack;
import LinkedList.Node;
import LinkedList.NodeInput;
import LinkedList.NodePrint;

public class leetcode_203 {
    public static Node<Integer> deleteNode(Node<Integer> head, int val) {
        if (head == null)
            return head;

        while (head != null && head.data == val) {
            // Node<Integer> OldNode = head;
            // head = head.next;
            // OldNode = null;
            head = head.next;
        }
        Node<Integer> temp = head;
        // while (temp != null) {
        // if (temp.next != null && temp.next.data == val) {
        // if (temp.next.next == null)
        // temp.next = null;
        // else
        // temp.next = temp.next.next;
        // }
        // temp = temp.next;
        // }
        while (temp != null && temp.next != null) {
            if (temp.next.data == val) {
                temp.next = temp.next.next; // Skip the node with value `val`
            } else {
                temp = temp.next; // Move to the next node only if no deletion
            }
        }
        return head;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        NodeInput Input = new NodeInput();
        Node<Integer> head = Input.input();
        System.out.println("Original Node");
        NodePrint Print = new NodePrint();
        Print.print(head);
        System.out.println();
        System.out.println("ENTER THE NODE VALUE TO BE DELETED");
        int val = sc.nextInt();
        System.out.println();
        System.out.println("AFTER DELETING THE NODES ");
        Print.print(deleteNode(head, val));
    }

}
