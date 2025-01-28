import java.util.Scanner;

public class inputNode {

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
        /*
         * Node1 10 address @150 head node has address @150 and it node1.next has adress
         * of next node2
         * so when head=head.next hten head will have address of node2
         * Node2 20 address @200
         * Node3 30 address @210
         */
    }

    public static Node<Integer> input() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter digit to enter number or enter -1 to exit");
        int data = sc.nextInt();
        /*
         * as this approach of taking two input is O(n2) as 1+1+2+3+4+......+(n-1) =
         * (n-1) *n/2=O(n2)
         * so for making timecomplexity easier we will take a tail node which will hold
         * the reference of last node
         */
        Node<Integer> head = null, tail = null;
        while (data != -1) {
            Node<Integer> newNode = new Node<Integer>(data);
            if (head == null) {
                head = newNode;
                tail = newNode;
            } else {
                // Node<Integer> temp = head;
                // while (temp.next != null)
                // temp = temp.next;

                // temp.next = newNode;
                tail.next = newNode;
                tail = newNode;
            }
            data = sc.nextInt();
        }
        return head;
    }

    public static void main(String[] args) {
        Node<Integer> node1 = new Node<>(10);
        Node<Integer> node2 = new Node<>(20);
        Node<Integer> node3 = new Node<>(30);
        node1.next = node2;
        node2.next = node3;
        Node<Integer> head = node1;
        print(head);
        Node<Integer> head1 = input();
        print(head1);
        // this is also going to print the node again
        // print(head);
    }
}
