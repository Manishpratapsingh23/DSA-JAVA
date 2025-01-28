package LinkedList;

public class reverseNodeRecursively {
    public static Node<Integer> reverseRec(Node<Integer> head) {
        if (head == null || head.next == null)
            return head;
        Node<Integer> finalHead = reverseRec(head.next);

        Node<Integer> temp = finalHead;
        while (temp.next != null)
            temp = temp.next;
        temp.next = head;
        head.next = null;
        return finalHead;

    }
    
    public static void main(String[] args) {
        NodeInput Input = new NodeInput();

        Node<Integer> head = Input.input();
        NodePrint Print = new NodePrint();
        System.out.println("Original Node");
        Print.print(head);
        System.out.println();

        Node<Integer> newNode = reverseRec(head);
        System.out.println("Reversed Node By Recursion");
        Print.print(newNode);

    }
}
