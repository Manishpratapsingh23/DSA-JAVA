package leetCode;

import LinkedList.Node;
import LinkedList.NodeInput;
import LinkedList.NodePrint;

public class leetcode_82 {
    public static Node<Integer> removeDuplicates(Node<Integer> head) {
        if (head == null)
            return null;
        int previous_data = head.data;
        Node prev = head, temp = head;
        while (temp != null) {
            if (prev.next == temp)
                temp.next = temp.next.next;
            else {
                temp = temp.next;
                prev = temp;
            }

        }
        return head;
    }

    public static void main(String args[]) {
        NodeInput Input = new NodeInput();
        Node<Integer> head = Input.input();
        NodePrint Print = new NodePrint();
        System.out.println("ORIGINAL NODE");
        Print.print(head);
        System.out.println();
        System.out.println("DUPLICATES REMOVED NODE");
        Print.print(removeDuplicates(head));
    }
}
