package Stack;

public class stackUsingArray {
    private int data[];
    private int top;

    public stackUsingArray() {
        data = new int[10];
        top = -1;
    }

    public stackUsingArray(int capacity) {
        data = new int[capacity];
        top = -1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public int size() {
        return top + 1;
    }

    public int top() throws StackEmptyException {

        if (top == -1) {
            StackEmptyException e = new StackEmptyException("Stack is empty");
            throw e;
        }
        return data[top];
    }

    public void push(int element) throws StackFullException {
        if (size() == data.length) {
            StackFullException e = new StackFullException("Stack is Full");
            throw e;
        }
        data[++top] = element;

    }

    public int pop() throws StackEmptyException {
        if (top == -1) {
            StackEmptyException e = new StackEmptyException("Stack is empty");
            throw e;
        }
        return data[top--];
    }
}
