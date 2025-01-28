package Queue;

public class queueUsingLLUse {
    public static void main(String[] args) {
        try {
            queueUsingLL<Integer> queue = new queueUsingLL<>();
            queue.enqueue(10);
            queue.enqueue(20);
            queue.enqueue(30);

            System.out.println("Size: " + queue.size());

            System.out.println("Dequeue: " + queue.dequeue());
            System.out.println("Dequeue: " + queue.dequeue());
            System.out.println("Size after dequeue: " + queue.size());
            System.out.println("Dequeue: " + queue.dequeue());
            System.out.println("Dequeue: " + queue.dequeue());
        } catch (QueueEmptyException e) {
            System.err.println(e.getMessage());
        }
    }
}
