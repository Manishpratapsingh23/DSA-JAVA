package Queue;

public class queueUse {
    public static void main(String[] args) {
        queueUsingArray queue = new queueUsingArray();
        // Enqueue some elements
        for (int i = 1; i <= 11; i++) {
            try {
                queue.enqueue(i);
            } catch (QueueFullException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
        queue.enqueue(1000);

        // Dequeue all elements
        while (!queue.isEmpty()) {
            try {
                System.out.println(queue.dequeue());
            } catch (QueueEmptyException e) {
                System.out.println("Error: " + e.getMessage());
            }

        }
    }
}
