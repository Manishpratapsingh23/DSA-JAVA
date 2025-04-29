import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
class MinMaxIsBSTdata{
    int minimum;
    int maximum;
    boolean isBst;
}
class Pair<T,V> {
	public T first;
	public V second;
}
public class BinarySearchTreeUse {
    public static BinaryTreeNode<Integer> takeInput1(Scanner sc)
    {
        System.out.println("Enter the root data");
        int data=sc.nextInt();
        if(data==-1)
        {
            return null;
        }
        BinaryTreeNode<Integer> root=new BinaryTreeNode<>(data);
        root.left=takeInput1(sc);
        root.right=takeInput1(sc);
        return root;
    }
    public static void printBinaryTree1(BinaryTreeNode<Integer> root)
    {
        if(root==null)
        {
            return;
        }
        String str=root.data+": ";
        if(root.left!=null)
        {
            str+="L->"+root.left.data+" , ";
        }
        if(root.right!=null)
        {
            str+="R->"+root.right.data;
        }
        System.out.println(str);
        printBinaryTree1(root.left);
        printBinaryTree1(root.right);
    }
    public static BinaryTreeNode<Integer> takeInput2()
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter node data");
        int rootData=sc.nextInt();
        if(rootData==-1)
        {
            return null;
        }
        BinaryTreeNode<Integer> root=new BinaryTreeNode<>(rootData);
        Queue<BinaryTreeNode<Integer>> queue=new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty())
        {
            BinaryTreeNode<Integer> node=queue.remove();
            System.out.println("Enter left node data of "+node.data);
            int l=sc.nextInt();
            System.out.println("Enter right node data of "+node.data);
            int r=sc.nextInt();
            if(l!=-1)
            {
                node.left=new BinaryTreeNode<>(l);
                queue.add(node.left);
            }
            if(r!=-1)
            {
                node.right=new BinaryTreeNode<>(r);
                queue.add(node.right);
            }

        }
        return root;
    }
    public static void printBinaryTree2(BinaryTreeNode<Integer> root)
    {
        if(root==null)
        {
            return;
        }
        Queue<BinaryTreeNode<Integer>> queue=new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty())
        {
            BinaryTreeNode<Integer> node=queue.remove();
            if(node!=null)
            {
            String leftData = (node.left != null) ? node.left.data.toString() : "-1";
            String rightData = (node.right != null) ? node.right.data.toString() : "-1";
            System.out.println(node.data + ":L:" + leftData + ",R:" + rightData);
            
            // Add children to the queue if they exist
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
            }
        }
    }
    public static boolean isBST(BinaryTreeNode<Integer> root,int min, int max)
    {
        if(root==null)
        {
            return true;
        }
        if(root.data<=min || root.data>=max)
        {
            return false;
        }
        return isBST(root.left,min,root.data) && isBST(root.right,root.data,max);
    }
    public static boolean isBST2(BinaryTreeNode<Integer> root)
    {
        if(root==null)
        {
            return true;
        }
        int leftmax=maximum(root.left);
        int rightmin=minimum(root.right);
        if(root.data<=leftmax || root.data>=rightmin)
        {
            return false;
        }
        return isBST2(root.left) && isBST2(root.right);
    }
    public static int minimum(BinaryTreeNode<Integer> root)
    {
        if(root==null)
        {
            return Integer.MAX_VALUE;
        }
        return Math.min(root.data,Math.min(minimum(root.left), minimum(root.right)));
    }
    public static int maximum(BinaryTreeNode<Integer> root)
    {
        if(root==null)
        {
            return Integer.MIN_VALUE;
        }
        return Math.max(root.data,Math.max(maximum(root.left), maximum(root.right)));
    }
    public static boolean searchInBST(BinaryTreeNode<Integer> root,int k)
    {
        if(root==null)
        {
            return false;
        }
        if(root.data==k)
        {
            return true;
        }
        if(root.data>k)
        {
            return searchInBST(root.left, k);
        }
        else
        {
            return searchInBST(root.right, k);
        }
    }
    public static MinMaxIsBSTdata isBST3(BinaryTreeNode<Integer> root)
    {
        MinMaxIsBSTdata ans=new MinMaxIsBSTdata();
        if(root==null)
        {
            ans.minimum=Integer.MAX_VALUE;
            ans.maximum=Integer.MIN_VALUE;
            ans.isBst=true;
            return ans;
        }
        MinMaxIsBSTdata ansleft=isBST3(root.left);
        MinMaxIsBSTdata ansright=isBST3(root.right);
        ans.minimum = Math.min(root.data, Math.min(ansleft.minimum, ansright.minimum));
        ans.maximum = Math.max(root.data, Math.max(ansleft.maximum, ansright.maximum));

    // The current tree is a BST only if:
    // 1. The left subtree is a BST.
    // 2. The right subtree is a BST.
    // 3. The root's value is greater than the maximum value of the left subtree.
    // 4. The root's value is less than the minimum value of the right subtree.
    ans.isBst = ansleft.isBst && ansright.isBst && (root.data > ansleft.maximum) && (root.data < ansright.minimum);
        return ans;

    }
    public static Pair<Boolean, Pair<Integer, Integer>> isBST4(BinaryTreeNode<Integer> root) {
		if (root == null) {
			Pair<Boolean, Pair<Integer, Integer>> output = new Pair<Boolean, Pair<Integer, Integer>>();
			output.first = true;
			output.second = new Pair<Integer, Integer>();
			output.second.first = Integer.MAX_VALUE;
			output.second.second = Integer.MIN_VALUE;
			return output;
		}
		Pair<Boolean, Pair<Integer, Integer>> leftOutput = isBST4(root.left);
		Pair<Boolean, Pair<Integer, Integer>> rightOutput = isBST4(root.right);
		int min = Math.min(root.data, Math.min(leftOutput.second.first, rightOutput.second.first));
		int max = Math.max(root.data, Math.max(leftOutput.second.second, rightOutput.second.second));
		boolean isBST = (root.data > leftOutput.second.second) && (root.data <= rightOutput.second.first) && leftOutput.first && rightOutput.first;
		Pair<Boolean, Pair<Integer, Integer>> output = new Pair<Boolean, Pair<Integer, Integer>>();
		output.first = isBST;
		output.second = new Pair<Integer, Integer>();
		output.second.first = min;
		output.second.second = max;
		return output;
	}
    public static BinaryTreeNode<Integer> SortedArrayToBST(int[] arr, int n){
        if(n==0)
        return null;
        return helper(arr,0,n-1);
    }
    public static BinaryTreeNode<Integer> helper(int[] arr, int start, int end)
    {
        if(start>end)
        return null;
        int m=(start+end)/2;
        BinaryTreeNode<Integer> root=new BinaryTreeNode<>(arr[m]);
        root.left=helper(arr, start, m-1);
        root.right=helper(arr, m+1, end);
        return root;
    }
    public static List<Integer> getRootToNodePath(BinaryTreeNode<Integer> root, int k)
    {
        if(root==null)
        {
            return null;
        }
        if(root.data==k)
        {
            List<Integer> lst=new ArrayList<>();
            lst.add(root.data);
            return lst;   
        }
        List<Integer> leftans=getRootToNodePath(root.left, k);
        if(leftans!=null)
        {
            leftans.add(root.data);
            return leftans;
        }
        List<Integer> rightans=getRootToNodePath(root.right, k);
        if(rightans!=null)
        {
            rightans.add(root.data);
            return rightans;
        }
        return null;
    }
    public static int heightOfTree(BinaryTreeNode<Integer> root)
    {
        if(root==null)
        {
            return 0;
        }
        int height=1;
        int heightOfLeft=heightOfTree(root.left);
        int heightOfRight=heightOfTree(root.right);
        return height+Math.max(heightOfLeft, heightOfRight);
    } 
    public static List<Integer> BSTtoSortedArray(BinaryTreeNode<Integer> root) {
        List<Integer> ans = new ArrayList<>();
        inorderTraversal(root, ans);
        return ans;
    }
    private static void inorderTraversal(BinaryTreeNode<Integer> root, List<Integer> ans) {
        if (root == null) {
            return;
        }
        // Traverse the left subtree
        inorderTraversal(root.left, ans);
    
        // Add the current node's data
        ans.add(root.data);
    
        // Traverse the right subtree
        inorderTraversal(root.right, ans);
    }
    


    public static void main(String[] args) {
        //Scanner sc=new Scanner(System.in);
        System.out.println("                 ===========BINARY SEARCH TREE========");
        // BinaryTreeNode<Integer> root=takeInput1(sc);
        // printBinaryTree1(root);
        BinaryTreeNode<Integer> root=takeInput2();
        printBinaryTree2(root);
        // System.out.println("Is Tree a BST: "+isBST(root,Integer.MIN_VALUE,Integer.MAX_VALUE));
        // System.out.println("Is Tree a BST2: "+isBST2(root));
        // MinMaxIsBSTdata ans=isBST3(root);
        // System.out.println("Is Tree a BST3: "+ans.isBst);
        // Pair<Boolean, Pair<Integer, Integer>> output=isBST4(root);
        // System.out.println("Is Tree a BST4: "+output.first);
        // System.out.println("Is present in Tree : "+searchInBST(root, 5));
        // System.out.println("Is present in Tree : "+searchInBST(root, 10));
        // int arr[]={1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
        // int arr2[]={2,3,5,9,10,15,18,29};
        // BinaryTreeNode<Integer> node1=SortedArrayToBST(arr, 15);
        // printBinaryTree2(node1);
        // System.out.println(heightOfTree(node1));
        // BinaryTreeNode<Integer> node=SortedArrayToBST(arr, 15);
        // printBinaryTree2(node);
        // List<Integer> ans=getRootToNodePath(node, 7);
        // if(ans!=null){
        //     for(int i=0;i<ans.size();i++){
        //         System.out.print(ans.get(i)+" ");
        //     }
        //     System.out.println();
        // }
        // else{
        //     System.out.println("No path found for 4");
        // }
        // List<Integer> ans1=getRootToNodePath(node, 15);
        // if(ans1!=null){
        //     for(int i=0;i<ans1.size();i++){
        //         System.out.print(ans1.get(i)+" ");
        //     }
        //     System.out.println();
        // }
        // else{
        //     System.out.println("No path found for 4");
        // }
        // List<Integer> ans2=getRootToNodePath(node, 16);
        // if(ans2!=null){
        //     for(int i=0;i<ans2.size();i++){
        //         System.out.print(ans2.get(i)+" ");
        //     }
        //     System.out.println();
        // }
        // else{
        //     System.out.println("No path found for 4");
        // }
        List<Integer> arr=BSTtoSortedArray(root);
        for(int i : arr)
        System.out.print(i+" ");
    }
}
