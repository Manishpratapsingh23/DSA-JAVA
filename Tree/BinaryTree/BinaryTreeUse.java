import java.util.LinkedList;
import java.util.Queue;
import  java.util.Scanner;
class balancedTreeReturn{
    boolean isbalanced;
    int height;
}
class diameterBinaryTree<T,V>{
    public T height;
    public V diameter;
}
class Pair<T, U> {
    T minimum;
    U maximum;

    public Pair(T minimum, U maximum) {
        this.minimum = minimum;
        this.maximum = maximum;
    }

}

public class BinaryTreeUse {
    public static BinaryTreeNode<Integer> takeInput(Scanner sc)
    {
        int rootData;
        System.out.println("Enter root data");
        rootData=sc.nextInt();
        if(rootData==-1)
        {
            return null;
        }
        BinaryTreeNode<Integer> root=new BinaryTreeNode<>(rootData);
        root.left=takeInput(sc);
        root.right=takeInput(sc);
        return root;
    }
    public static void printTree(BinaryTreeNode<Integer> root)
    {
        if(root==null)
        {
            return;
        }
        String toBePrinted=root.data+" --->  ";
        if(root.left!=null)
        {
            toBePrinted+="L : "+root.left.data;
        }
        if(root.right!=null)
        {
            toBePrinted+="   R : "+root.right.data;
        }
        System.out.println(toBePrinted);
        printTree(root.left);
        printTree(root.right);
    }
    public static BinaryTreeNode<Integer> takeInputIteratively()
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter root data");
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
            System.out.println("Enter left child of Node : "+node.data);
            int l=sc.nextInt();
            System.out.println("Enter right child of Node : "+node.data);
            int r=sc.nextInt();
            if(l!=-1){
                node.left=new BinaryTreeNode<>(l);
                queue.add(node.left);
            }
            if(r!=-1){
                node.right=new BinaryTreeNode<>(r);
                queue.add(node.right);
            }
        }
        return root;
    }
    public static void printNodeLevelWise(BinaryTreeNode<Integer> root)
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
    public static void printNodeLevelWise2(BinaryTreeNode<Integer> root)
    {
        if(root==null)
        {
            return;
        }
        Queue<BinaryTreeNode<Integer>> queue=new LinkedList<>();
        queue.add(root);
        queue.add(null);
        while(!queue.isEmpty())
        {
            BinaryTreeNode<Integer> node=queue.remove();
            if(node==null)
            {
                System.out.println();
                if(!queue.isEmpty())
                {
                    queue.add(null);
                }
            }
            else{
                System.out.print(node.data+" ");
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }
    }   
    public static int countNodes(BinaryTreeNode<Integer> root)
    {
        if(root==null)
        {
            return 0;
        }
        int ans=1;
        ans+=countNodes(root.left);
        ans+=countNodes(root.right);
        return ans;
    }
    public static int sumOfNodes(BinaryTreeNode<Integer> root)
    {
        if(root==null)
        {
            return 0;
        }
        int ans=root.data;
        ans+=sumOfNodes(root.left);
        ans+=sumOfNodes(root.right);
        return ans;
    }
    public static boolean isNodePresent(BinaryTreeNode<Integer> root, int x)
    {
	    //Your code goes here
		if(root==null)
		return false;
		if(root.data==x)
		{
			return true;
		}
		boolean ansleft=isNodePresent(root.left, x);
		if(ansleft)
		return true;
		boolean ansRight=isNodePresent(root.right, x);
		if(ansRight)
		return true;
		return false;
	}
    public static int largestNode(BinaryTreeNode<Integer> root)
    {
        if(root==null)
        {
            return -1;
        }
        int left=largestNode(root.left);
        int right=largestNode(root.right);
        return Math.max(root.data, Math.max(left,right));
    }
    public static int nodesGreaterThanX(BinaryTreeNode<Integer> root,int x)
    {
        if(root==null)
        {
            return 0;
        }
        int ans=0;
        ans+=nodesGreaterThanX(root.left,x);
        ans+=nodesGreaterThanX(root.right, x);
        if(root.data>x){
            ans+=1;
        }
        return ans;
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
    public static int totolLeafs(BinaryTreeNode<Integer> root)
    {
        if(root==null)
        {
            return 1;
        }
        if(root.left==null && root.right==null)
        {
            return 1;
        }
        return totolLeafs(root.left)+totolLeafs(root.right);
    }
    public static void allNodeAtDepth(BinaryTreeNode<Integer> root,int depth)
    {
        if(root==null)
        {
            return;
        }
        if(depth==0)
        {
            System.out.print(root.data+", ");
            return;
        }
        allNodeAtDepth(root.left, depth-1);
        allNodeAtDepth(root.right, depth-1);
    }
    public static void replaceNodeWithDepth(BinaryTreeNode<Integer> root,int depth)
    {
        if(root==null)
        {
            return;
        }
        root.data=depth;
        replaceNodeWithDepth(root.left, depth+1);
        replaceNodeWithDepth(root.right, depth+1);
    }
    public static void nodeWithOutSiblings(BinaryTreeNode<Integer> root)
    {
        if(root==null)
        {
            return;
        }
        if((root.left!=null && root.right==null))
        {
            System.out.println(root.left.data);
            
        }
        if((root.left==null && root.right!=null))
        {
            System.out.println(root.right.data);
            
        }
        nodeWithOutSiblings(root.left);
        nodeWithOutSiblings(root.right);
    }
    public static void preorderTraversal(BinaryTreeNode<Integer> root)
    {
        if(root==null)
        {
            return;
        }
        System.out.print(root.data+", ");
        preorderTraversal(root.left);
        preorderTraversal(root.right);
    }
    public static void postorderTraversal(BinaryTreeNode<Integer> root)
    {
        if(root==null)
        {
            return;
        }
        postorderTraversal(root.left);
        postorderTraversal(root.right);
        System.out.print(root.data+", ");
    }
    public static void inorderTraversal(BinaryTreeNode<Integer> root)
    {
        if(root==null)
        {
            return;
        }
        inorderTraversal(root.left);
        System.out.print(root.data+", ");
        inorderTraversal(root.right);
    }
    public static void levelorderTraversal(BinaryTreeNode<Integer> root)
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
            System.out.print(node.data+", ");
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
    }
    public static BinaryTreeNode<Integer> removeLeafs(BinaryTreeNode<Integer> root)
    {
        if(root==null)
        {
            return null;
        }
        if(root.left==null && root.right==null)
        {
            return null;
        }
        root.left=removeLeafs(root.left);
        root.right=removeLeafs(root.right);
        return root;

    }
    public static boolean balancedBinaryTree(BinaryTreeNode<Integer> root)
    {
        if(root==null)
        {
            return true;
        }
        int hl=heightOfTree(root.left);
        int hr=heightOfTree(root.right);
        if(Math.abs(hr-hl)>1)
        {
            return false;
        }
        boolean ansLeft=balancedBinaryTree(root.left);
        boolean ansRight=balancedBinaryTree(root.right);
        return ansLeft && ansRight;
    }
    public static balancedTreeReturn balancedBinaryTreeBetter(BinaryTreeNode<Integer> root)
    {
        if(root==null)
        {
            int height=0;
            boolean isBal=true;
            balancedTreeReturn ans=new balancedTreeReturn();
            ans.height=height;
            ans.isbalanced=isBal;
            return ans;
        }
        balancedTreeReturn leftOutput=balancedBinaryTreeBetter(root.left);
        balancedTreeReturn rightOutput=balancedBinaryTreeBetter(root.right);
        boolean isBal=true;
        int height=1+Math.max(leftOutput.height,rightOutput.height);
        if(Math.abs(leftOutput.height-rightOutput.height)>1)
        {
            isBal=false;
        }
        if(!leftOutput.isbalanced || !rightOutput.isbalanced)
        {
            isBal=false;
        }
        balancedTreeReturn ans=new balancedTreeReturn();
            ans.height=height;
            ans.isbalanced=isBal;
            return ans;
    }
    public static int diameter(BinaryTreeNode<Integer> root)
    {
        if(root==null)
       {
        return 0;
       }
       int option1=heightOfTree(root.left)+heightOfTree(root.right);
       int option2=diameter(root.left);
       int option3=diameter(root.right);
       return Math.max(option1, Math.max(option2,option3));

    }
    public static diameterBinaryTree<Integer,Integer> diameterBetterApproach(BinaryTreeNode<Integer> root)
    {
        diameterBinaryTree<Integer,Integer> ans=new diameterBinaryTree<>();
        if(root==null)
        {
            ans.diameter=0;
            ans.height=0;
            return ans;
        }
        diameterBinaryTree<Integer,Integer> ansLeft=diameterBetterApproach(root.left);
        diameterBinaryTree<Integer,Integer> ansRight=diameterBetterApproach(root.right);
        int height=1+Math.max(ansLeft.height, ansRight.height);
        int op1=ansLeft.height+ansRight.height;
        int op2=ansLeft.diameter;
        int op3=ansRight.diameter;
        int diameter=Math.max(op1, Math.max(op2,op3));
        ans.height=height;
        ans.diameter=diameter;
        return ans;

    }
    public static void mirrorBinaryTree(BinaryTreeNode<Integer> root)
    {
		//Your code goes here
		if(root==null){
            return;
        }
		BinaryTreeNode<Integer> temp=root.left;
        root.left=root.right;
        root.right=temp;
        mirrorBinaryTree(root.left);
        mirrorBinaryTree(root.right);

	}
    public static Pair<Integer, Integer> getMinAndMax(BinaryTreeNode<Integer> root) {
		if(root==null)
		{
			Pair<Integer, Integer> ans=new Pair(Integer.MAX_VALUE,Integer.MIN_VALUE);
			return ans;
		}
		Pair<Integer, Integer> ansleft=getMinAndMax(root.left);
		Pair<Integer, Integer> ansright=getMinAndMax(root.right);
		int minimum=Math.min(root.data,Math.min(ansleft.minimum,ansright.minimum));
		int maximum=Math.max(root.data,Math.max(ansright.maximum,ansleft.maximum));
		Pair<Integer, Integer> ans=new Pair(minimum,maximum);
		return ans;
	}




    public static void main(String[] args) {
        @SuppressWarnings("unused")
        Scanner sc=new Scanner(System.in);
        // BinaryTreeNode<Integer> root= new BinaryTreeNode<>(1);
        // BinaryTreeNode<Integer> node1= new BinaryTreeNode<>(2);
        // root.left=node1;
        // BinaryTreeNode<Integer> node2= new BinaryTreeNode<>(3);
        // root.right=node2;
        // System.out.println(root.data);
        // System.out.println(root.left.data);
        // System.out.println(root.right.data);
        //Scanner sc=new Scanner(System.in);
        //BinaryTreeNode<Integer> root=takeInput(sc);
        //printTree(root);
        BinaryTreeNode<Integer> root=takeInputIteratively();    
        printNodeLevelWise(root);
        printNodeLevelWise2(root);
        // System.out.println("Total Nodes are "+countNodes(root));
        // System.out.println("Total sum of all Nodes are "+ sumOfNodes(root));
        // System.out.print("Enter the node to be check: ");
        // int x=sc.nextInt();
        // System.out.println();
        // System.err.println(isNodePresent(root, x));
        // System.out.println("Largest Node data : " + largestNode(root));
        // System.out.print("Enter number to which totla grater nodes to be found: ");
        // int x=sc.nextInt();
        // System.out.println("Total node grater than x: "+ nodesGreaterThanX(root, x));
        //System.out.println("The height of tree: "+heightOfTree(root));
        //System.out.println("Total leafs: "+totolLeafs(root));
        // System.out.print("Enter the depth to which all nodes to be printed: ");
        // int depth=sc.nextInt();
        // System.out.print("All nodes at depth "+ depth +": ");
        // allNodeAtDepth(root,depth);
        // System.out.println();
        // replaceNodeWithDepth(root, 0);
        // printNodeLevelWise(root);
        //nodeWithOutSiblings(root);
        // System.out.print("Level-Order Traversal: ");
        // levelorderTraversal(root);
        // System.out.println();
        // System.out.print("In-Order Traversal: ");
        // inorderTraversal(root);
        // System.out.println();
        // System.out.print("Pre-Order Traversal: ");
        // preorderTraversal(root);    
        // System.out.println();
        // System.out.print("Post-Order Traversal: ");
        // postorderTraversal(root);
        // System.out.println();
        //printNodeLevelWise(removeLeafs(root));
        //System.out.println("Is tree balanced: "+balancedBinaryTree(root));
        // balancedTreeReturn ans=balancedBinaryTreeBetter(root);
        // System.out.println(ans.isbalanced);
        // System.out.println("Diameter of Binary Tree: "+diameter(root));
        // diameterBinaryTree<Integer,Integer> ans=diameterBetterApproach(root);
        // System.out.println("Diameter of Binary Tree: "+ans.diameter );
        // mirrorBinaryTree(root);
        // printNodeLevelWise2(root);
        // Pair<Integer, Integer> ans=getMinAndMax(root);
        // System.out.println("Maximum: "+ans.maximum);
        // System.out.println("Minimum: "+ans.minimum);
    }
}
