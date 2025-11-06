import java.util.ArrayList;
import java.util.Arrays;
public class KnightDialer {
    static ArrayList<Integer>[] possibleMoves;
    static int MOD = 1000000007;
    public static int knightDialer(int n) {
        moves();
        int ans = 0;
        for(int i=0;i<10;i++){
            ans= (ans + helper(n-1, i))%MOD;
        }
        return ans;
    }

    private static int helper(int n, int place){
        if(n==0) return 1;
        ArrayList<Integer> lst = possibleMoves[place];
        int ans = 0;
        for(int i : lst){
            ans= (ans + helper(n-1, i))%MOD;
        }
        return ans;

    }

    public static int knightDialerM(int n) {
        moves();
        int ans = 0;
        int memo[][] = new int[n][10];
        for(int i=0;i<n;i++) Arrays.fill(memo[i], -1);
        for(int i=0;i<10;i++){
            ans=(ans+helperM(n-1, i,memo))%MOD;
        }
        return ans;
    }

    private static int helperM(int n, int place, int memo[][]){
        if(n==0) return 1;
        if(memo[n][place]!=-1) return memo[n][place];
        ArrayList<Integer> lst = possibleMoves[place];
        int ans = 0;
        for(int i : lst){
            ans= (ans + helperM(n-1, i, memo))%MOD;
        }
        return memo[n][place] = ans;

    }

    public static void main(String args[]){
        // System.out.println(knightDialer(1));
        // System.out.println(knightDialer(2));
        System.out.println(knightDialerM(3));
        System.out.println(knightDialerM(3131));
    }
    @SuppressWarnings("unchecked")
    private static ArrayList<Integer>[] moves(){
        
        possibleMoves = (ArrayList<Integer>[])new ArrayList[10];
        for(int i=0;i<10;i++){
            switch(i){
                case(0) : possibleMoves[i] = new ArrayList<>(Arrays.asList(4,6)); break;
                case(1) : possibleMoves[i] = new ArrayList<>(Arrays.asList(6,8)); break;
                case(2) : possibleMoves[i] = new ArrayList<>(Arrays.asList(7,9)); break;
                case(3) : possibleMoves[i] = new ArrayList<>(Arrays.asList(4,8)); break;
                case(4) : possibleMoves[i] = new ArrayList<>(Arrays.asList(0,3,9)); break;
                case(5) : possibleMoves[i] = new ArrayList<>(); break;
                case(6) : possibleMoves[i] = new ArrayList<>(Arrays.asList(0,1,7)); break;
                case(7) : possibleMoves[i] = new ArrayList<>(Arrays.asList(2,6)); break;
                case(8) : possibleMoves[i] = new ArrayList<>(Arrays.asList(1,3)); break;
                case(9) : possibleMoves[i] = new ArrayList<>(Arrays.asList(2,4)); break;
                default: break;
            }
        }
        return possibleMoves;
    }
}
