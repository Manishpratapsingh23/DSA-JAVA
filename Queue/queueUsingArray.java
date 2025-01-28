package Queue;

public class queueUsingArray {
    private int data[];
    private int front;
    private int rear;
    private int size;

    public queueUsingArray() {
        data = new int[5];
        front = -1;
        rear = -1;
        size = 0;
    }

    public queueUsingArray(int capacity) {
        data = new int[capacity];
        front = -1;
        rear = -1;
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int front() {
        if (size == 0)
            throw new QueueEmptyException();
        return data[front];
    }

    public void enqueue(int num) {
        if (size == data.length)
            doublecapacity();
        if (size == 0)
            front = 0;
        size++;
        // rear++;
        // if(rear==data.length)
        // rear=0;
        // this is done when we have empty array in starting then we can add element in
        // starting of it and this can be done in one line ------> circular queue
        rear = (rear + 1) % data.length;
        data[rear] = num;

    }

    private void doublecapacity() {
        int temp[] = data;
        data = new int[temp.length * 2];
        int index = 0;
        for (int i = front; i < temp.length; i++)
            data[index++] = temp[i];
        for (int i = 0; i < front; i++)
            data[index++] = temp[i];
        rear = temp.length - 1;
        front = 0;

    }

    public int dequeue() {
        if (size == 0)
            throw new QueueEmptyException();
        int temp = data[front];
        size--;
        // front++;
        // if(front==data.length)
        // front=0;

        front = (front + 1) % data.length;
        if (size == 0) {
            front = -1;
            rear = -1;
        }
        return temp;
    }

}
