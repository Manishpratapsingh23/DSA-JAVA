package LinkedList;

public class reverseNodeRecursively2 {
    public static doubleNode reverseRec(Node<Integer> head) {
        if (head == null || head.next == null) {
            doubleNode ans = new doubleNode();
            ans.head = head;
            ans.tail=head;

            return ans;
        }
        doubleNode smallAns = reverseRec(head.next);
        smallAns.tail.next = head;
        head.next = null;

        doubleNode ans = new doubleNode();
        ans.head = smallAns.head;
        ans.tail = head;

    return ans;
    }

    public static void main(String[] args) {
        NodeInput Input = new NodeInput();

        Node<Integer> head = Input.input();
        NodePrint Print = new NodePrint();
        System.out.println("Original Node");
        Print.print(head);
        System.out.println();

        doubleNode ans = reverseRec(head);
        System.out.println("Reversed Node By Recursion");
        Print.print(ans.head);
    }

}
