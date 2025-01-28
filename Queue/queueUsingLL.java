package Queue;

public class queueUsingLL<T> {
    private Node<T> front;
    private Node<T> rear;
    int size;

    public queueUsingLL() {
        front = null;
        rear = null;
        size = 0;
    }

    int size() {
        return size;
    }

    boolean isEmpty() {
        return front == null;
    }

    public void enqueue(T data) {
        Node<T> head = new Node<>(data);
        if (rear == null) {
            front = head;
            rear = head;
        } else {
            rear.next = head;
            rear = head;
        }
        size++;
    }

    public T dequeue() {
        if (front == null)
            throw new QueueEmptyException();
        T ans = front.data;
        front = front.next;
        if (front == null)
            rear = null;
        size--;
        return ans;

    }
}
