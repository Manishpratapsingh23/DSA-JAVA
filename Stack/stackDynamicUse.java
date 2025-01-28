package Stack;

public class stackDynamicUse {
    public static void main(String[] args) {
        try {
            stackUsingDynamicArray stack = new stackUsingDynamicArray(5);

            // Push elements into the stack
            for (int i = 1; i <= 10; i++) {
                stack.push(i);
                System.out.println("Pushed: " + i);
            }

            // Attempt to push into a full stack (it will resize dynamically)
            System.out.println("Pushed: 11");
            stack.push(11);

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
