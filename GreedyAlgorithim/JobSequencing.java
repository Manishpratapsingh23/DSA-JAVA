import java.util.ArrayList;
import java.util.Arrays;

public class JobSequencing {
    static class pair implements Comparable<pair>{
        int a, b;
        pair(int a, int b){
            this.a = a;
            this.b =b;
        }

        @Override
        public int compareTo(pair other){
            return Integer.compare(other.b, this.b);
        }
    }
    public static ArrayList<Integer> jobSequencing(int[] deadline, int[] profit) {
        // code here
        int n = deadline.length;
        pair sch[] = new pair[n];
        int maxDays = 0;
        for(int i : deadline) maxDays = Math.max(maxDays, i);
        for(int i=0;i<n;i++) sch[i] = new pair(deadline[i], profit[i]);
        Arrays.sort(sch);
        boolean isEmpty[] = new boolean[maxDays+1];
        int total = 0, ans = 0;
        for(pair p : sch){
            int i = p.a;
            while(i>0){
                if (!isEmpty[i]) {
                    isEmpty[i] = true;
                    total++;
                    ans += p.b;
                    break;
                }
                i--;
            }
        }
        ArrayList<Integer> ans1 = new ArrayList<>();
        ans1.add(total);
        ans1.add(ans);
        return ans1;
    }
    public static void main(String[] args) {
        int deadline[] = {2, 1, 2, 1, 1};
        int profit[] = {100,19,27,25,15};
        System.out.println(jobSequencing(deadline, profit));
    }
}
