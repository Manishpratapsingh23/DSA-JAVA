package LinkedList;

public class reverseNodeRecursively3 {
    public static Node<Integer> reverseRec(Node<Integer> head) {
        if (head == null || head.next == null)
            return head;
        Node<Integer> reversedTail = head.next;
        Node<Integer> smallHead = reverseRec(head.next);
        reversedTail.next = head;
        head.next = null;
        return smallHead;
    }

    public static void main(String[] args) {
        NodeInput Input = new NodeInput();

        Node<Integer> head = Input.input();
        NodePrint Print = new NodePrint();
        System.out.println("Original Node");
        Print.print(head);
        System.out.println();

        System.out.println("Reversed Node By Recursion");
        Print.print(reverseRec(head));
    }

}
