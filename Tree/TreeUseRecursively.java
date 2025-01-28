import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
@SuppressWarnings("unused")
class pair{
    TreeNode<Integer> node;
    int xsum;
}
class pairOutput<T>{
    T first;
    T second;
    public pairOutput(T first, T second)
    {
        this.first=first;
        this.second=second;
    }
}
public class TreeUseRecursively {
    public static TreeNode<Integer> takeInput(Scanner sc)
    {
        int n;
      System.out.println("Enter the Node data");
        n=sc.nextInt();
        
        TreeNode<Integer> root=new TreeNode<>(n);
     System.out.println("Enter number of children of this Node: "+n);
        int childCount=sc.nextInt();
        for(int i=0;i<childCount;i++)
        {
            TreeNode<Integer> child=takeInput(sc);
            root.children.add(child);
        }
        return root;
    }
    public static TreeNode<Integer> takeInputLevelWise(){
        System.out.println("Enter the Node data");
        Scanner sc=new Scanner(System.in);
        int data=sc.nextInt();
        Queue<TreeNode<Integer>> queue=new LinkedList<>();
        TreeNode<Integer> root=new TreeNode<>(data);
         queue.add(root);
         while(!queue.isEmpty())
         {
            TreeNode<Integer> frontNode=queue.remove();
            System.out.println("Enter the number of child of Node: "+frontNode.data);
            int child=sc.nextInt();
            for(int i=0;i<child;i++)
            {
                System.out.println("Enter "+(i+1)+"th node of "+frontNode.data);
                int childData=sc.nextInt();
                TreeNode<Integer> childNode=new TreeNode<>(childData);
                frontNode.children.add(childNode);
                queue.add(childNode);
            }
         }
         return root;

    }
    public static void printNodeLevelWise(TreeNode<Integer> root)
    {
        Queue<TreeNode<Integer>> queue=new LinkedList<>();
        queue.add(root);
        queue.add(null);
        System.out.println(root.data);
        while(!queue.isEmpty())
        {
            TreeNode<Integer> frontNode=queue.remove();
            if(frontNode==null)
            {
                System.out.println();
                if (!queue.isEmpty()) {
                    queue.add(null);
                }
            }
            else{
                for(int i=0;i<frontNode.children.size();i++)
                    {
                        System.out.print(frontNode.children.get(i).data+" ");
                        queue.add(frontNode.children.get(i));
                    }
            }
        }
    }
    public static void print(TreeNode<Integer> root)
    {
        String s=root.data+":";
        for(int i=0;i<root.children.size();i++)
        {
            s+=root.children.get(i).data+",";
        }
        System.out.println(s);
        for(int i=0;i<root.children.size();i++)
        {
            print(root.children.get(i));
        }

    }
    public static int countNodes(TreeNode<Integer> root)
    {
        if(root==null)
        {
            return 0;
        }
        int count=1;
        for(int i=0;i<root.children.size();i++)
        {
            count+=countNodes(root.children.get(i));
        }
        return count;
    }
    public static int sumOfAllNodes(TreeNode<Integer> root)
    {
        if(root==null)
        {
            return 0;
        }
        int sum=root.data;
        for(int i=0;i<root.children.size();i++)
        {
            sum+=sumOfAllNodes(root.children.get(i));
        }
        return sum;
    }
    public static TreeNode<Integer> largestDataNode(TreeNode<Integer> root)
    {
        if(root==null)
        {
            return null;
        }
        TreeNode<Integer> node=root;
        for(int i=0;i<root.children.size();i++)
        {
            node=largestDataNode(root.children.get(i));
            node=root.data>node.data?root:node;
        }
        return node;
    }
    public static int nodesGreaterX(TreeNode<Integer> root,int x)
    {
        if(root==null)
        {
            return 0;
        }
        int val=root.data>x?1:0;
        for(int i=0;i<root.children.size();i++)
        {
            val+=nodesGreaterX(root.children.get(i), x);
        }
        return val;
    }
    public static int heightofTree(TreeNode<Integer> root)
    {
        if(root==null)
        {
            return 0;
        }
        int height=0;
        for(int i=0;i<root.children.size();i++)
        {
            int ans=heightofTree(root.children.get(i));
            height=Math.max(height,ans);
        }
        return height+1;
    }
    public static void atDepthNodes(TreeNode<Integer> root,int depth)
    {
        if(root==null || depth<0){
        return;
        }
        if(depth==0){
        System.out.print(root.data+",");
        return;
        }
        for(int i=0;i<root.children.size();i++)
        {
            atDepthNodes(root.children.get(i), depth-1);
        }
    }
    public static int totalLeafNode(TreeNode<Integer> root)
    {
        if(root==null)
        {
            return 0;
        }
        if(root.children.size()==0)
        {
            return 1;
        }
        int count=0;
        for(int i=0;i<root.children.size();i++)
        {
            count+=totalLeafNode(root.children.get(i));
        }
        return count;
    }
    public static void preorderTraversal(TreeNode<Integer> root)
    {
        if(root==null)
        {
            return;
        }
        System.out.print(root.data+" ");
        for(int i=0;i<root.children.size();i++)
        {
            preorderTraversal(root.children.get(i));
        }

    }
    public static void levelTraversal(TreeNode<Integer> root)
    {
        if(root==null)
        {
            return;
        }
        Queue<TreeNode<Integer>> queue=new LinkedList<>();
        queue.add(root);
        System.out.print(root.data+" ");
        while(!queue.isEmpty())
        {
            TreeNode<Integer> frontNode=queue.remove();
                for(int i=0;i<frontNode.children.size();i++)
                    {
                        System.out.print(frontNode.children.get(i).data+" ");
                        queue.add(frontNode.children.get(i));
                    }
        }
    }
    public static void postorderTraversal(TreeNode<Integer> root)
    {
        if(root==null)
        {
            return;
        }
        if(root.children.size()==0)
        {
            System.out.print(root.data+" ");
            return;
        }
        for(int i=0;i<root.children.size();i++)
        {
            postorderTraversal(root.children.get(i));
        }
        System.out.print(root.data+" ");

    }
    public static pair maxLargerNode(TreeNode<Integer> root)
    {
        if(root==null)
        {
            return null;
        }
        pair ans=new pair();
        ans.node=root;
        int sum=root.data;
        for(int i=0;i<root.children.size();i++)
        {
            sum+=root.children.get(i).data;
        }
        ans.xsum=sum;
        for(int i=0;i<root.children.size();i++)
        {
            pair smallAns = maxLargerNode(root.children.get(i));
            if(smallAns.xsum>ans.xsum)
            {
                ans.xsum=smallAns.xsum;
                ans.node=smallAns.node;
            }

        }
        return ans;
    }
    public static TreeNode<Integer> largerAnsClosureNodeToX(TreeNode<Integer> root,int x)
    {
        if(root==null)
        {
            return root;
        }
        TreeNode<Integer> ans=null;
        if(root.data>x)
        {
            ans=root;
        }
        for(int i=0;i<root.children.size();i++)
        {
            TreeNode<Integer> newAns=largerAnsClosureNodeToX(root.children.get(i), x);
            if (newAns != null && (ans == null || newAns.data < ans.data)) {
                ans = newAns;
            }

        }
        return ans;
    }
    public static pairOutput<TreeNode<Integer>> secondLargestNode(TreeNode<Integer> root)
    {
        pairOutput<TreeNode<Integer>> ans;
        if(root == null){
            ans = new pairOutput<>(null,null);
            return ans;
        }
        ans = new pairOutput<>(root,null);
        for(int i=0;i<root.children.size();i++)
        {
            pairOutput<TreeNode<Integer>> output=secondLargestNode(root.children.get(i));
            if (ans.first == null || output.first.data > ans.first.data) {
                ans.second = ans.first;
                ans.first = output.first;
            } else if (ans.first.data.equals(output.first.data) && output.second != null) {
                ans.second = output.second;
            } else if (ans.second == null || output.first.data > ans.second.data) {
                ans.second = output.first;
            }

        }
        return ans;
    }
    public static TreeNode<Integer> replaceNodeWithDepth(TreeNode<Integer> root,int depth){
        if(root==null)
        {
            return root;
        }
        root.data=depth;
        for(int i=0;i<root.children.size();i++)
        {
            replaceNodeWithDepth(root.children.get(i), depth+1);
        }
        return root;

    }


    public static void main(String[] args) {
   // Scanner sc=new Scanner(System.in);
    //TreeNode<Integer> root=takeInput(sc);
    TreeNode<Integer> root=takeInputLevelWise();
    //  print(root);
    printNodeLevelWise(root);
    //System.out.println("Total Node are "+countNodes(root));
    //System.out.println("Sum Of All Node are "+sumOfAllNodes(root));
    //System.out.println("Node with largest Data is "+largestDataNode(root).data);
    //System.out.print("Enter the value to count node greater than value entered: ");
    //int x=sc.nextInt();
    //System.out.println("Node greater than "+x+" is "+nodesGreaterX(root, x));
    //System.out.println("The height of tree is "+heightofTree(root));
    //System.out.print("Enter the value of depth point of which all node to be printed: ");
    //int depth=sc.nextInt();
    //System.out.println();
    //System.out.print("Nodes at depth "+depth+" : ");
    //atDepthNodes(root,depth);
    //System.out.println("Total Leaf Nodes are "+totalLeafNode(root));
    //System.out.print("Levelorder Traversal ");
    //levelTraversal(root);
    //System.out.println();
    //System.out.print("Preorder Traversal ");
    //preorderTraversal(root);
    //System.out.println();
    //System.out.print("Postlorder Traversal ");
    //postorderTraversal(root);
    //System.out.println();
    //pair ans=maxLargerNode(root);
    //System.out.println(ans.node.data);
    //System.out.print("Enter the number to which closest Node to be find : ");
    //int x=sc.nextInt();
    //System.out.println(largerAnsClosureNodeToX(root, x).data);
    //pairOutput<TreeNode<Integer>> ans1=secondLargestNode(root);
    //System.out.println(ans1.second.data);
    replaceNodeWithDepth(root, 0);
    printNodeLevelWise(root);


    }
    
}
