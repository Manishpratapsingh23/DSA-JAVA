
package LinkedList;

import java.util.Scanner;

public class midPointNode {
    public static Node<Integer> midpoint(Node<Integer> head) {
        if (head == null || head.next == null)
            return head;
        Node<Integer> slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        // if (fast.next != null)
        // slow = slow.next;
        return slow;

    }

    public static void main(String[] args) {
        NodeInput Input = new NodeInput();

        Node<Integer> head = Input.input();
        NodePrint Print = new NodePrint();
        System.out.println("Original Node");
        Print.print(head);
        System.out.println();

        Node<Integer> MidNode = midpoint(head), part1 = head, part2 = MidNode.next;
        MidNode.next = null;
        System.out.println("#####    Mid Node Point   ########");
        System.out.println(MidNode.data);
        System.out.println("#####    part1 Node   ########");
        Print.print(part1);
        System.out.println();
        System.out.println("#####    part2 Node   ########");
        Print.print(part2);
    }
}
