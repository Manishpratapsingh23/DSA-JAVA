package Queue;

public class queueUsingStackUse {
    public static void main(String[] args) {
        // Create an instance of the queue using stacks
        queueUsingStack<Integer> queue = new queueUsingStack<>();

        // Enqueue elements into the queue
        System.out.println("Enqueueing elements: 10, 20, 30");
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);

        // Display the size of the queue
        System.out.println("Queue size after enqueuing: " + queue.size());

        // Dequeue an element
        System.out.println("Dequeuing an element: " + queue.dequeue());

        // Display the size of the queue after one dequeue
        System.out.println("Queue size after dequeueing: " + queue.size());

        // Enqueue more elements
        System.out.println("Enqueueing elements: 40, 50");
        queue.enqueue(40);
        queue.enqueue(50);

        // Dequeue all elements
        System.out.println("Dequeuing elements:");
        while (!queue.isEmpty()) {
            System.out.println(queue.dequeue());
        }

        // Try to dequeue from an empty queue (this should throw an exception)
        try {
            System.out.println("Attempting to dequeue from an empty queue:");
            queue.dequeue(); // This should throw an exception
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
        }
    }
}
