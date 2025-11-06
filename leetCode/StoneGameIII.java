import java.util.Arrays;
public class StoneGameIII {
    public static String stoneGame(int[] stoneValue) {
        int ans =  helper(stoneValue,0);
        if(ans>0) return "Alice";
        if(ans<0) return "Bob";
        return "Tie";

    }

    private static int helper(int stoneValue[], int idx){
        if(idx>=stoneValue.length) return 0;
        int total = 0;
        int ans = Integer.MIN_VALUE;
        for(int i=0;i<3 && idx+i<stoneValue.length;i++){
            total+=stoneValue[idx+i];
            ans = Math.max(ans, total-helper(stoneValue, idx+i+1));
        }
        return ans;
    }

    public static String stoneGameM(int[] stoneValue) {
        int memo[] = new int[stoneValue.length];
        Arrays.fill(memo, Integer.MIN_VALUE);
        int ans =  helperM(stoneValue,0,memo);
        if(ans>0) return "Alice";
        if(ans<0) return "Bob";
        return "Tie";

    }

    private static int helperM(int stoneValue[], int idx, int memo[]){
        if(idx>=stoneValue.length) return 0;
        if(memo[idx]!=Integer.MIN_VALUE) return memo[idx];
        int total = 0;
        int ans = Integer.MIN_VALUE;
        for(int i=0;i<3 && idx+i<stoneValue.length;i++){
            total+=stoneValue[idx+i];
            ans = Math.max(ans, total-helperM(stoneValue, idx+i+1,memo));
        }
        return memo[idx]=ans;
    }

    public static String stoneGameDP(int[] stoneValue) {
        int n = stoneValue.length;
        int dp[] = new int[n+1];
        dp[n]=0;
        for(int i=n-1;i>=0;i--){
            int total = 0;
            int score = Integer.MIN_VALUE;
            for(int idx=0;idx<3 && i+idx<n; idx++){
                total += stoneValue[i+idx];
                score = Math.max(score, total-dp[i+idx+1]);
            }
            dp[i]=score;
        }
        int ans = dp[0];
        if(ans>0) return "Alice";
        if(ans<0) return "Bob";
        return "Tie";

    }
    public static void main(String[] args) {
        int stoneValue[] = {1,2,3,7};
        int stoneValue1[] = {1,2,3,4};
        System.out.println(stoneGameM(stoneValue));
        System.out.println(stoneGameM(stoneValue1));
    }
}
