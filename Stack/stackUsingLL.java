package Stack;

import LinkedList.Node;

public class stackUsingLL<T> {
    private Node<T> head;
    private int size;

    public stackUsingLL() {
        head = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public T top() throws StackEmptyException {
        if (size() == 0)
            throw new StackEmptyException("No element in Stack");
        return head.data;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void push(T element) {
        Node<T> newNode = new Node<>(element);
        newNode.next = head;
        head = newNode;
        size++;
    }

    public T pop() throws StackEmptyException {
        if (size == 0)
            throw new StackEmptyException("Stack is empty");
        T ret = head.data;
        head = head.next;
        size--;
        return ret;

    }

}
