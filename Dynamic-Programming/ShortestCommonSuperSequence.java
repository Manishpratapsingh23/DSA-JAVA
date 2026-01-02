import java.util.*;
public class ShortestCommonSuperSequence{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		String s1 = sc.next();
		String s2 = sc.next();
		String res = shortestCommonSupersequence(s1,s2);
		System.out.println(res);
	}

	public static String shortestCommonSupersequence(String str1, String str2) {
        String ans = lsc_scs(str1,str2);
        return ans;
        
        //String res = helper(str1, str2);
        //System.out.println(res);

        // String res = helperMM(str1, str2);
        // System.out.println(res);
        // return "";
    }

    private static String helper(String s1, String s2){
    	if(s1.length()==0) return s2;
    	if(s2.length()==0) return s1;
    	if(s1.charAt(0)==s2.charAt(0)){
    		return s1.charAt(0) + helper(s1.substring(1), s2.substring(1));
    	}
		String op1 = s1.charAt(0) + helper(s1.substring(1), s2);
		String op2 = s2.charAt(0) + helper(s1, s2.substring(1));
		return op1.length()>op2.length() ? op2 : op1;
    }

    private static String helperM(String s1, String s2){
    	Map<String, String> memo = new HashMap<>();
    	System.out.println(helperM(s1, s2, memo));
    	return "";
    }

    private static String helperM(String s1, String s2, Map<String, String> memo){
    	int m = s1.length();
    	int n = s2.length();
    	if(m==0) return s2;
    	if(n==0) return s1;
    	String key = s1+" "+s2;
    	if(memo.containsKey(key)) return memo.get(key);

    	if(s1.charAt(0)==s2.charAt(0)){
    		String res = s1.charAt(0) + helperM(s1.substring(1), s2.substring(1), memo);
    		memo.put(key,res);
    		return res;
    	}
		String op1 = s1.charAt(0) + helperM(s1.substring(1), s2, memo);
		String op2 = s2.charAt(0) + helperM(s1, s2.substring(1), memo);
		String res = op1.length()>op2.length() ? op2 : op1;
		memo.put(key,res);
    	return res;
    }


    private static String helperMM(String s1, String s2){
    	Map<String, String> memo = new HashMap<>();
    	return helperMM(s1, s2, memo);
    	//return "";
    }

    private static String helperMM(String s1, String s2, Map<String, String> memo){
    	int m = s1.length();
    	int n = s2.length();
    	if(m==0) return s2;
    	if(n==0) return s1;
    	String key = s1+" "+s2;
    	if(memo.containsKey(key)) return memo.get(key);

    	if(s1.charAt(0)==s2.charAt(0)){
    		String res = s1.charAt(0) + helperMM(s1.substring(1), s2.substring(1), memo);
    		memo.put(key,res);
    		return res;
    	}
		String op1 = s1.charAt(0) + helperMM(s1.substring(1), s2, memo);
		String op2 = s2.charAt(0) + helperMM(s1, s2.substring(1), memo);
		String res = op1.length()>op2.length() ? op2 : op1;
		memo.put(key,res);
    	return res;
    }

    private static String lsc_scs(String str1, String str2){
    	int m = str1.length();
    	int n = str2.length();
    	int dp[][] = new int[m+1][n+1];
    	// for(int i=0;i<=m;i++) dp[i][n]=0;
    	// for(int i=0;i<=n;i++) dp[m][i]=0;

    	for(int i=1;i<=m;i++){
    		for(int j=1;j<=n;j++){
    			if(str1.charAt(i-1)==str2.charAt(j-1)){
    				dp[i][j] = 1+dp[i-1][j-1];
    			} else {
    				dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
    			}
    		}
    	}
    	StringBuilder sb = new StringBuilder();
    	int i=m,j=n;
    	while(i>0 && j>0){
    		if(str1.charAt(i-1)==str2.charAt(j-1)){
    			sb.append(str1.charAt(i-1));
    			i--;
    			j--;
    		} else if(dp[i-1][j]>dp[i][j-1]){
    			sb.append(str1.charAt(i-1));
    			i--;
    		} else {
    			sb.append(str2.charAt(j-1));
    			j--;
    		}
    	}
    	while (i > 0) {
		    sb.append(str1.charAt(i - 1));
		    i--;
		}
		while (j > 0) {
		    sb.append(str2.charAt(j - 1));
		    j--;
		}


    	return sb.toString();
    }
}