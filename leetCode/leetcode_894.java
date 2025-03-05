import java.util.ArrayList;
import java.util.List;
class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int val) { this.val = val; }
        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
}
public class leetcode_894 {
    public static List<TreeNode> allPossibleFBT(int n) {
        if(n%2==0) return new ArrayList<>();
        return helper(n);
    }
    private static List<TreeNode> helper(int n){
        if(n==1){
            List<TreeNode> singleNodes=new ArrayList<>();
            singleNodes.add(new TreeNode(0));
            return singleNodes;
        }
        List<TreeNode> ans=new ArrayList<>();
        for(int i=1;i<n;i+=2){
            int j=n-i-1;
            List<TreeNode> leftAns=helper(i);
            List<TreeNode> rightAns=helper(j);
            for(TreeNode left: leftAns){
                for(TreeNode right:rightAns){
                    ans.add(new TreeNode(0,left,right));
                }
            }
        }
        return ans;
    }
    public static List<TreeNode> allPossibleFBT_DP(int n){
        if(n%2==0) return new ArrayList<>();
        if (n == 1) {
            List<TreeNode> singleNodeList = new ArrayList<>();
            singleNodeList.add(new TreeNode(0));
            return singleNodeList;
        }
        List<List<TreeNode>> dp=new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            dp.add(new ArrayList<>());
        }
        dp.get(0).add(null);
        dp.get(1).add(new TreeNode(0));
        for(int nodes=3;nodes<=n;nodes+=2){
            for(int i=1;i<nodes;i+=2){
                List<TreeNode> leftAns=dp.get(i);
                List<TreeNode> rightAns=dp.get(nodes-i-1);
                for(TreeNode left: leftAns){
                    for(TreeNode right:rightAns){
                        dp.get(nodes).add(new TreeNode(0,left,right));
                    }
                }
            }
        }
        return dp.get(n);
    }
 public static void main(String[] args) {
    int n=7;
    List<TreeNode> ans=allPossibleFBT(n);
    System.out.println(ans.size());
    List<TreeNode> ans_Dp=allPossibleFBT_DP(n);
    System.out.println(ans_Dp.size());
 }   
}
