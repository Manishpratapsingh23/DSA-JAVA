
import java.util.Arrays;

public class MinimumCostForTickets {
    public static int mincostTickets(int[] days, int[] costs) {
        return helper(days,costs,0);
    }
    private static int helper(int[] days, int[] costs, int idx){
        if(idx==days.length) return 0;
        int op1 = costs[0]+helper(days, costs, idx+1);
        int idx2 = idx;
        while(idx2<days.length && days[idx2]<=days[idx]+6) idx2++;
        int op2 = costs[1]+helper(days, costs, idx2);
        int idx3 = idx;
        while(idx3<days.length && days[idx3]<=days[idx]+29) idx3++;
        int op3 = costs[2]+helper(days, costs, idx3);
        return Math.min(op1, Math.min(op2, op3));
    }

    public static int mincostTicketsM(int[] days, int[] costs) {
        int memo[] = new int[days.length];
        Arrays.fill(memo,-1);
        return helperM(days,costs,0, memo);
    }
    private static int helperM(int[] days, int[] costs, int idx, int memo[]){
        if(idx==days.length) return 0;
        if(memo[idx]!=-1) return memo[idx];
        int op1 = costs[0]+helperM(days, costs, idx+1,memo);
        int idx2 = idx;
        while(idx2<days.length && days[idx2]<=days[idx]+6) idx2++;
        int op2 = costs[1]+helperM(days, costs, idx2,memo);
        int idx3 = idx;
        while(idx3<days.length && days[idx3]<=days[idx]+29) idx3++;
        int op3 = costs[2]+helperM(days, costs, idx3,memo);
        return memo[idx] = Math.min(op1, Math.min(op2, op3));
    }

    public static int mincostTicketsDP(int[] days, int[] costs) {
        int lastDay = days[days.length-1];
        int dp[] = new int[lastDay+1];
        boolean canTravel[] = new boolean[lastDay+1];
        for(int d : days) canTravel[d] = true;
        for(int i=1;i<=lastDay;i++){
            if(!canTravel[i]) dp[i] = dp[i-1];
            else {
                int op1 = dp[i-1] + costs[0];
                int op2 = dp[Math.max(0, i-7)] + costs[1];
                int op3 = dp[Math.max(0, i-30)] + costs[2];
                dp[i] = Math.min(op1, Math.min(op2, op3));
            }
        }
        return dp[lastDay];
    }

    public static void main(String agrs[]){
        int days[] = {1,4,6,7,8,20};
        int costs[] = {2,7,15};
        System.out.println(mincostTickets(days, costs));
        System.out.println(mincostTicketsM(days, costs));
        System.out.println(mincostTicketsDP(days, costs));
    }
}
