package Queue;

import java.util.Stack;

public class queueUsingStack<T> {
    private Stack<T> stack1;
    private Stack<T> stack2;
    private int size;

    public queueUsingStack() {
        size = 0;
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void enqueue(T data) {
        stack1.push(data);
        size++;
    }

    public T dequeue() {
        // Transfer elements from stack1 to stack2 if stack2 is empty
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }

        // If stack2 is still empty, it means the queue is empty
        if (stack2.isEmpty()) {
            throw new QueueEmptyException();
        }

        // Pop from stack2 and return the dequeued element
        size--;
        return stack2.pop();
    }
}
