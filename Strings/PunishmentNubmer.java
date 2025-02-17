public class PunishmentNubmer {
    public static  int punishmentNumber(int n) {
        int ans=0;
        for(int i=1;i<=n;i++){
            int sq=i*i;
            if(helper(sq,Integer.toString(sq),0,0)){
                ans+=sq;
            }
        }
        return ans;
    }
    private static boolean helper(int target, String num, int index, int sum) {
        if (index == num.length()) {
            return sum == target;
        }

        int currentNum = 0;
        for (int i = index; i < num.length(); i++) {
            currentNum = currentNum * 10 + (num.charAt(i) - '0');
            if (helper(target, num, i + 1, sum + currentNum)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int n=10;
        int ans=punishmentNumber(n);
        System.out.println(ans);
    }
}
