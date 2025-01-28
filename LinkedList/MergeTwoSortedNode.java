import java.util.Scanner;

public class MergeTwoSortedNode {
    public static Node<Integer> merge(Node<Integer> head1, Node<Integer> head2) {
        if (head1 == null)
            return head2;
        if (head2 == null)
            return head1;
        Node<Integer> head = null, tail = null;

        while (head1 != null && head2 != null) {
            if (head1.data <= head2.data) {
                if (head == null) {
                    head = head1;
                    tail = head1;
                    head1 = head1.next;
                } else {
                    tail.next = head1;
                    tail = head1;
                    head1 = head1.next;
                }
            } else {
                if (head == null) {
                    head = head2;
                    tail = head2;
                    head2 = head2.next;
                } else {
                    tail.next = head2;
                    tail = head2;
                    head2 = head2.next;
                }

            }
        }
        // while (head1 != null)
        // tail.next = head1.next;
        // while (head2 != null)
        // tail.next = head2.next;
        if (head1 != null) {
            if (tail != null)
                tail.next = head1;
            else
                head = head1;
        } else if (head2 != null) {
            if (tail != null)
                tail.next = head2;
            else
                head = head2;
        }
        return head;
    }

    public static void main(String[] args) {
        NodeInput Input = new NodeInput();

        Node<Integer> head1 = Input.input();
        NodePrint Print = new NodePrint();
        System.out.println("Original Node 1");
        Print.print(head1);
        System.out.println();
        Node<Integer> head2 = Input.input();
        System.out.println("Original Node2");
        Print.print(head2);
        System.out.println();
        Node<Integer> finalNode = merge(head1, head2);
        System.out.println("Merged Node");
        Print.print(finalNode);

    }
}
