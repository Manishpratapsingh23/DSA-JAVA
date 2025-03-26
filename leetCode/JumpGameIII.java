import java.util.LinkedList;
import java.util.Queue;

public class JumpGameIII{
    public static boolean canReach(int[] arr, int start) {
        return helper(arr,start);
    }
    private static boolean helper(int arr[],int index){
        if(index<0 || index>=arr.length || arr[index]<0) return false;
        if(arr[index]==0) return true;
        int jump=arr[index];
        arr[index]=-1;
        boolean op1=helper(arr,index-jump);
        boolean op2=helper(arr,index+jump);
        return op1 || op2;
    }

    public static boolean canReachM(int[] arr, int start) {
        boolean visited[]=new boolean[arr.length];
        return helperM(arr,start,visited);
    }
    private static boolean helperM(int arr[],int index,boolean visited[]){
        if(index<0 || index>=arr.length || visited[index]) return false;
        if(arr[index]==0) return true;
        visited[index]=true;
        
        boolean op2=helperM(arr,index+arr[index],visited);
        boolean op1=helperM(arr,index-arr[index],visited);
        return op1 || op2;
    }

    public static boolean canReach_DP(int[] arr, int start) {
        int n = arr.length;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);

        while (!queue.isEmpty()) {
            int curr = queue.poll();
            if (arr[curr] == 0) return true;

            int jump = arr[curr];
            int forward = curr + jump;
            int backward = curr - jump;

            arr[curr] = -1;
            if (forward < n && arr[forward] != -1) {
                queue.add(forward);
            }
            if (backward >= 0 && arr[backward] != -1) {
                queue.add(backward);
            }
        }

        return false;
    }

    public static void main(String args[]){
        int arr1[]={4,2,3,0,3,1,2};
        int s1=5;
        int arr2[]={4,2,3,0,3,1,2};
        int s2=0;
        int arr3[]={3,0,2,1,2};
        int s3=2;

        System.out.println(canReach(arr1, s1));
        System.out.println(canReach(arr2, s2));
        System.out.println(canReach(arr3, s3));

        System.out.println(canReachM(arr1, s1));
        System.out.println(canReachM(arr2, s2));
        System.out.println(canReachM(arr3, s3));

        System.out.println(canReach_DP(arr1, s1));
        System.out.println(canReach_DP(arr2, s2));
        System.out.println(canReach_DP(arr3, s3));

    }
}