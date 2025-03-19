
import java.util.Scanner;

public class magicPowder {
    private static boolean canBakeCake(long mid, long n, long quantity[], long present[],long k){
        long required=0;
        for(int i=0;i<n;i++){
            long needed=Math.max(0,mid*quantity[i]-present[i]);
            required+=needed;
            if(required>k) return false;
        }
        return required<=k;
    }
    private static long solve(long n, long k,long quantity[], long present[]){
        long left = 0, right = (long)1e13, ans = 0;
        while (left <= right) {
            long mid = left + (right - left) / 2;
            
            if (canBakeCake(mid, n,quantity,present,k)) {
                ans = mid; // Try making more burgers
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return ans;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        long n=sc.nextLong();
        long k=sc.nextLong();

        long quantity[]=new long[(int)n];
        long present[]=new long[(int)n];

        for(int i=0;i<n;i++) quantity[i]=sc.nextLong();

        for(int i=0;i<n;i++) present[i]=sc.nextLong();

        System.out.println(solve(n,k,quantity,present));
    }
}
