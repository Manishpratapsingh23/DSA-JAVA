
import java.util.Arrays;

/*
 * Problem statement
A thief robbing a store can carry a maximal weight of W into his knapsack. 
There are N items, and i-th item weigh 'Wi' and the value being 'Vi.' 
What would be the maximum value V, that the thief can steal?

Detailed explanation ( Input/output format, Notes, Images )
Constraints :
1 <= N <= 20
1<= Wi <= 100
1 <= Vi <= 100

Time Limit: 1 sec
Sample Input 1 :
4
1 2 4 5
5 4 8 6
5
Sample Output 1 :
13
Sample Input 2 :
5
12 7 11 8 9
24 13 23 15 16
26
Sample Output 2 :
51
 */
 // #### Companies** paytm, Algo8
public class DP_01KnapSack {
    public static int knapsack(int n, int[] weights, int[] values, int maxWeight) {
        return knapsack(n, 0, weights, values, maxWeight);
	}

    public static int knapsack(int n,int index, int[] weights, int[] values, int maxWeight) {
        if(n==index || maxWeight==0) return 0;

        if(weights[index]>maxWeight){
            return knapsack(n, index+1, weights, values, maxWeight);
        }
        int op1=knapsack(n, index+1, weights, values, maxWeight);
        int op2=values[index]+knapsack(n, index+1, weights, values, maxWeight-weights[index]);
        return Math.max(op1,op2);
    }

    
    public static int knapsackM(int n, int[] weights, int[] values, int maxWeight) {
        int memo[][]=new int[n][maxWeight+1];
        for (int[] row : memo) Arrays.fill(row, -1);
        return knapsackM(n, 0, weights, values, maxWeight,memo);
	}

    private static int knapsackM(int n, int index, int weights[], int values[], int maxWeight, int memo[][]){
        if(index==n || maxWeight==0){
            return 0;
        }

        if(memo[index][maxWeight]!=-1) return memo[index][maxWeight];

        if(weights[index]>maxWeight){
            memo[index][maxWeight]=knapsackM(n, index+1, weights, values, maxWeight,memo);
            return memo[index][maxWeight];
        }
        int op1=knapsackM(n, index+1, weights, values, maxWeight,memo);
        int op2=values[index]+knapsackM(n, index+1, weights, values, maxWeight-weights[index],memo);
        memo[index][maxWeight]=Math.max(op1,op2);
        return memo[index][maxWeight];
    }

    public static int knapsack_DP(int n, int[] weights, int[] values, int maxWeight) {
        int memo[][]=new int[n+1][maxWeight+1];
        //for(int i=0;i<=maxWeight;i++) memo[n][i]=0;
        for (int i = 0; i <= n; i++) {
            for (int w = 0; w <= maxWeight; w++) {
                if (i == n || w == 0) {
                    memo[i][w] = 0;
                }
            }
        }

        for(int i=n-1;i>=0;i--){
            for(int w=0;w<=maxWeight;w++){
                int ans;
                if(w>=weights[i]){
                    int op1=memo[i+1][w];
                    int op2=values[i]+memo[i+1][w-weights[i]];
                    ans=Math.max(op1, op2);
                }
                else{
                    ans=memo[i+1][w];
                }
                memo[i][w]=ans;
            }
        }
        return memo[0][maxWeight];
	}

    public static void main(String[] args) {
        int n=4;
        int wl=5;
        int weight[]={1,2,4,5};
        int value[]={5,4,8,6};
        System.out.println(knapsack(n, weight, value, wl));
        System.out.println(knapsackM(n, weight, value, wl));
        System.out.println(knapsack_DP(n, weight, value, wl));
    }
}
