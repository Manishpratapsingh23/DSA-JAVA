
import java.util.Stack;

public class insertAtBottom {
    public static void main(String[] args) {
        Stack<Integer> st = new Stack<>();
        // stack default capacity is 10. It uses LIFO
        st.push(10);
        st.push(20);
        st.push(30);
        st.push(40);
        st.push(50);
        System.out.println(st);
        reverse(st);
        System.out.println(st);
    }
    public static void reverse(Stack<Integer> stack){
        if(stack.isEmpty()) return;
        int x=stack.pop();
        reverse(stack);
        add_lst(stack,x);
    }
    public static void add_lst(Stack<Integer> stack, int x){
        if(stack.isEmpty()){
            stack.push(x);
            return; 
        }
        int i=stack.pop();
        add_lst(stack, x);
        stack.push(i);
    }
}
