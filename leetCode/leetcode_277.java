
import java.util.Stack;

public class leetcode_277 {
    public static void main(String[] args) {

		// TODO Auto-generated method stub
		int[][] arr = { { 0, 1, 1, 1 }, { 1, 0, 1, 1 }, { 0, 0, 0, 0 }, { 1, 1, 1, 0 } };
		System.out.println(Celebrity(arr));
	}

	public static int Celebrity(int[][] arr) {
		Stack<Integer> stack=new Stack<>();
        


        int candidate=stack.pop();
        for(int i=0;i<arr.length;i++){
            if(i==candidate) continue;
            if(arr[candidate])
        }
)	}
}
