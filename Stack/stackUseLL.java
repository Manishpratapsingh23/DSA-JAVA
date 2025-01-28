package Stack;

public class stackUseLL {
    public static void main(String[] args) {
        try {
            stackUsingLL<Integer> stack = new stackUsingLL<>();
            for (int i = 1; i <= 5; i++) {
                stack.push(i);
                System.out.println("pushed : " + i);
            }
            System.out.println("isEmpty " + stack.isEmpty());
            try {
                System.out.println(stack.top());
            } catch (StackEmptyException e) {
                System.out.println("Exception: " + e.getMessage());
            }
            while (!stack.isEmpty()) {
                System.out.println("poped : " + stack.pop());
            }
            try {
                stack.pop();
            } catch (StackEmptyException e) {
                System.out.println("Exception: " + e.getMessage());
            }
            try {
                stack.top();
            } catch (StackEmptyException e) {
                System.out.println("Exception: " + e.getMessage());
            }
            System.out.println("isEmpty " + stack.isEmpty());
        } catch (Exception e) {
            System.out.println("Unexpected exception: " + e.getMessage());
        }

    }
}
