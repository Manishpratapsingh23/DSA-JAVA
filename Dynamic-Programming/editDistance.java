
import java.util.Arrays;

public class editDistance {
    public static  int minDistance(String s, String t) {
        if(s.length()==0) return t.length();
        if(t.length()==0) return s.length();
        if(s.charAt(0)==t.charAt(0)){
            return minDistance(s.substring(1), t.substring(1));
        }
        else{
            //insert
            int op1=minDistance(s, t.substring(1));
            //delete
            int op2=minDistance(s.substring(1), t);
            //replace
            int op3=minDistance(s.substring(1), t.substring(1));

            return 1+Math.min(op1,Math.min(op2,op3));
        }
    }

    public static  int minDistanceM(String s, String t) {
        int m=s.length();
        int n=t.length();

        int memo[][]=new int[m+1][n+1];

        for(int i=0;i<=m;i++) memo[i][0]=i;
        for(int i=0;i<=n;i++) memo[0][i]=i;

        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(s.charAt(m-i)==t.charAt(n-j)){
                    memo[i][j]=memo[i-1][j-1];
                }
                else{
                    memo[i][j]=1+Math.min(memo[i-1][j-1],Math.min(memo[i][j-1],memo[i-1][j]));
                }
            }
        }
        return memo[m][n];
    }
    public static  int minDistanceM(String s, String t, int memo[][]){
        int m=s.length();
        int n=t.length();
        if(m==0){
            memo[m][n]=n;
            return n;
        }
        if(n==0){
            memo[m][n]=m;
            return m;
        }

        if(memo[m][n]!=-1) return memo[m][n];

        if(s.charAt(0)==t.charAt(0)){
            memo[m][n]=minDistanceM(s.substring(1), t.substring(1),memo);
        }
        else{
            //delete
            int op1=minDistanceM(s.substring(1), t,memo);
            //insert
            int op2=minDistanceM(s, t.substring(1),memo);
            //replace
            int op3=minDistanceM(s.substring(1), t.substring(1),memo);
            memo[m][n]=1+Math.min(op1,Math.min(op2,op3));
        }
        return memo[m][n];
    }

    public static  int minDistance_DP(String s, String t) {
        int memo[][]=new int[s.length()+1][t.length()+1];
        for(int i=0;i<s.length()+1;i++) Arrays.fill(memo[i],-1);
        return minDistanceM(s,t,memo);
    }
    public static void main(String[] args) {
        String s="intention";
        String t="execution";
        String s1="agh";
        String t1="ega";
        System.out.println(minDistance(s, t));
        System.out.println(minDistanceM(s, t));
        System.out.println(minDistance_DP(s1, t1));
    }
}
