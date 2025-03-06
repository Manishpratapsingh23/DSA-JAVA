package Stack;

public class stackUsingDynamicArray {
    private int[] data;
    private int top;
    private int capacity;

    public stackUsingDynamicArray() {
        data = new int[5];
        top = -1;
        this.capacity = capacity;
    }

    public stackUsingDynamicArray(int capacity) {
        data = new int[capacity];
        top = -1;
        this.capacity = capacity;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public int size() {
        return top + 1;
    }

    public int top() throws StackEmptyException {
        if (top == -1) {
            throw new StackEmptyException("Stack is empty");
        }
        return data[top];
    }

    public void push(int element) {
        // If the stack is full, double the size of the array
        if (size() == data.length) {
            System.out.println("changing array length");
            int[] newData = new int[capacity * 2];
            for (int i = 0; i < capacity; i++) {

            }
            capacity *= 2;
            data = newData;
        }
        data[++top] = element;
    }

    public int pop() throws StackEmptyException {
        if (top == -1) {
            throw new StackEmptyException("Stack is empty");
        }
        return data[top--];
    }
}
