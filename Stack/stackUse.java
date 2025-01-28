package Stack;

public class stackUse {
    public static void main(String args[]) throws StackFullException {
        try {
            stackUsingArray stack = new stackUsingArray(5);

            // Push elements into the stack
            for (int i = 1; i <= 5; i++) {
                stack.push(i);
                System.out.println("Pushed: " + i);
            }

            // Attempt to push into a full stack
            try {
                stack.push(6);
            } catch (StackFullException e) {
                System.out.println("Exception: " + e.getMessage());
            }

            // Pop all elements from the stack
            while (!stack.isEmpty()) {
                System.out.println("Popped: " + stack.pop());
            }

            // Attempt to pop from an empty stack
            try {
                stack.pop();
            } catch (StackEmptyException e) {
                System.out.println("Exception: " + e.getMessage());
            }

        } catch (Exception e) {
            System.out.println("Unexpected exception: " + e.getMessage());
        }
    }
}
