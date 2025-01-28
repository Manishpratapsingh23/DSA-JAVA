package leetCode;

import java.util.Stack;
import LinkedList.Node;
import LinkedList.NodeInput;
import LinkedList.NodePrint;

public class leetcode_2130 {
    public static int maximumTwinSum(Node<Integer> head) {
        Stack<Integer> end = new Stack<>();
        Node<Integer> temp = head, start = head;
        int count = 0;
        while (temp != null) {
            end.push(temp.data);
            temp = temp.next;
            count++;
        }
        int ans = 0;
        int n = 0;
        while (n < count / 2) {
            int sum = start.data + end.pop();
            ans = Math.max(ans, sum);
            n++;
        }
        return ans;
    }

    public static void main(String[] args) {
        NodeInput Input = new NodeInput();
        Node<Integer> head = Input.input();
        System.out.println("Original Node");
        NodePrint Print = new NodePrint();
        Print.print(head);
        System.out.println();
        System.out.println("Maximum Twin Sum is " + maximumTwinSum(head));
    }

}
