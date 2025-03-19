import java.util.Scanner;
public class coincombination1 {
    final static int mod = 1000000007;
    public static int coinChange(int[] coins, int amount) {
        int memo[]=new int[amount+1];
        memo[0]=1;
        for(int i=1;i<=amount;i++){
            for(int coin : coins){
                if(i>=coin) {
                    memo[i]=(memo[i]+memo[i-coin])%mod;
                }
            }
        }
        return memo[amount];
    }
    public static void main(String[] args) { 
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int amount = sc.nextInt();
        int coins[] = new int[n];
        for(int i = 0; i < n; i++){
            coins[i] = sc.nextInt();
        }
        System.out.println(coinChange(coins,amount));
    }
}