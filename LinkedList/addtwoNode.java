public class addtwoNode {
    public static void print(Node<Integer> head) {
        // Node<Integer> temp = head;
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
        System.out.println();
        // this will print the node list second time as we have stored the head refrence
        // in temp variable
        // head = temp;
        // while (head != null) {
        // System.out.print(head.data + " ");
        // head = head.next;
        // }
    }

    public static Node<Integer> add(Node<Integer> node1, Node<Integer> node2) {
        int carry = 0;
        // Node<Integer> result = new Node(0);
        Node<Integer> dummyHead = new Node<>(0);
        Node<Integer> current = dummyHead;
        while (node1 != null || node2 != null || carry > 0) {
            if (node1 != null) {
                carry += node1.data;
                node1 = node1.next;
            }
            if (node2 != null) {
                carry += node2.data;
                node2 = node2.next;
            }
            // result.next = new Node<>(carry % 10);
            // carry /= 10;
            // result = result.next;
            current.next = new Node<>(carry % 10);
            carry /= 10;
            current = current.next;
        }
        return dummyHead.next;

    }

    public static void main(String[] args) {
        Node<Integer> node1 = new Node<>(2);
        Node<Integer> node2 = new Node<>(4);
        Node<Integer> node3 = new Node<>(3);
        node1.next = node2;
        node2.next = node3;
        Node<Integer> node11 = new Node<>(5);
        Node<Integer> node21 = new Node<>(6);
        Node<Integer> node31 = new Node<>(4);
        node11.next = node21;
        node21.next = node31;
        Node<Integer> head1 = node1;
        Node<Integer> head11 = node11;
        print(head1);
        print(head11);
        // this is alsoing to print the node again
        // print(head);
        Node<Integer> result = add(head1, head11);
        print(result);
    }
}
