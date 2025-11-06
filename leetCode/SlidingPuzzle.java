import java.util.*;
public class SlidingPuzzle {
    public static void main(String[] args) {
        int arr[][] = {{4,1,2},{5,0,3}};
        System.out.println(helper(arr));
    }

    private static int helper(int arr[][]){
        Queue<String> queue = new LinkedList<>();
        String target = "123450";
        String start = "";
        for(int a[] : arr){
            for(int n : a) start+=(char)(48+n);
        }

        HashSet<String> visited =new HashSet<>();
        queue.add(start);
        visited.add(start);

        int moves[][] = new int[][]{{}}
    }
}
