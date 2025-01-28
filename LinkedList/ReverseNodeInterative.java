package LinkedList;

public class ReverseNodeInterative {
    public static Node<Integer> reverse(Node<Integer> head) {
        Node<Integer> curr = head, prev = null, temp;
        while (curr != null) {
            temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }

    public static void main(String[] args) {
        NodeInput Input = new NodeInput();
        Node<Integer> head = Input.input();
        NodePrint Print = new NodePrint();
        System.out.println("original Node");
        Print.print(head);
        System.out.println();
        System.out.println("reversed Node");
        Print.print(reverse(head));
    }
}
