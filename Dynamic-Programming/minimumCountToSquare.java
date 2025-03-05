
import java.util.Arrays;

public class minimumCountToSquare {
    public static int minCount(int n){
        if(n==0) return 0;
        int ans=Integer.MAX_VALUE;
        for(int i=1;i*i<=n;i++){
            int currAns=minCount(n-i*i);
            if(ans>currAns){
                ans=currAns;
            }
        }
        return ans+1;
    }
    public static int minCount_DP(int n){
        int dp[]=new int[n+1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0]=0;
        for(int i=1;i<=n;i++){
            for(int j=1;j*j<=i;j++){
                dp[i]=Math.min(dp[i],1+dp[i-j*j]);
            }
        }
        return dp[n];
    }
    public static int minCountM(int n, int[] dp){
        if(n==0) return 0;
        if(dp[n]!=-1) return dp[n];
        int ans=Integer.MAX_VALUE;
        for(int i=1;i*i<=n;i++){
            int currAns=minCountM(n-i*i,dp);
            if(ans>currAns){
                ans=currAns;
            }
        }
        return dp[n]=1+ans;
    }
    public static void main(String[] args) {
        int n=8;
        int dp[]=new int[n+1];
        Arrays.fill(dp,-1);
        dp[0]=0;
        System.out.println(minCount(n));
        System.out.println(minCount_DP(n));
        System.out.println(minCountM(n,dp));
    }
}
