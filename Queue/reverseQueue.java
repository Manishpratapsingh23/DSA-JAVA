import java.util.LinkedList;
import java.util.Queue;

public class reverseQueue {
    public static void main(String args[]) {
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= 5; i++)
            queue.add(i);
        reverse(queue);
        while (!queue.isEmpty()) {
            System.out.print(queue.poll() + " ");
        }
    }

    public static void reverse(Queue<Integer> queue) {
        if (queue.isEmpty())
            return;
        int data = queue.poll();
        reverse(queue);
        queue.add(data);

    }
}
