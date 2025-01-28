package leetCode;

import java.util.Scanner;
import java.util.Stack;
import LinkedList.Node;
import LinkedList.NodeInput;
import LinkedList.NodePrint;

public class leetcode_445 {

    public static Node<Integer> addNode(Node<Integer> head1, Node<Integer> head2) {
        if (head1 == null)
            return head2;
        if (head2 == null)
            return head1;
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        Node<Integer> temp1 = head1;
        Node<Integer> temp2 = head2;
        Node<Integer> newNode = null;
        while (temp1 != null) {
            stack1.push(temp1.data);
            temp1 = temp1.next;
        }
        while (temp2 != null) {
            stack2.push(temp2.data);
            temp2 = temp2.next;
        }
        int carry = 0;
        while (!stack1.isEmpty() || !stack2.isEmpty()) {
            if (!stack1.isEmpty())
                carry += stack1.pop();
            if (!stack2.isEmpty())
                carry += stack2.pop();
            Node<Integer> newdata = new Node<>(carry % 10);
            newdata.next = newNode;
            newNode = newdata;
            carry /= 10;

        }
        if (carry == 1) {
            Node<Integer> newdata = new Node<>(1);
            newdata.next = newNode;
            newNode = newdata;
        }
        return newNode;

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        NodeInput Input = new NodeInput();
        System.out.println("Enter Node 1 Data");
        Node<Integer> head1 = Input.input();
        System.out.println("Enter Node 2 Data");
        Node<Integer> head2 = Input.input();
        System.out.println("Node 1");
        NodePrint Print = new NodePrint();
        Print.print(head1);
        System.out.println();
        System.out.println("Node 2");
        Print.print(head2);
        System.out.println();
        System.out.println("NODE AFTER ADDITION");
        Print.print(addNode(head1, head2));
    }
}
