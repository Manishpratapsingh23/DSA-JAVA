import java.util.LinkedList;
import java.util.Queue;
public class BinaryTreeFromTraversals {
    public static void printNode(BinaryTreeNode<Integer> root)
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
    public static BinaryTreeNode<Integer> binaryTree1(int inorder[],int preorder[])
    {
        if(inorder.length==0 || preorder.length==0)
        {
            return null;
        }
        return helper1(inorder, preorder, 0, inorder.length-1,0, preorder.length-1);
    }
    public static BinaryTreeNode<Integer> helper2(int inorder[],int postorder[], int inStart,int inEnd, int posStart, int posEnd)
    {
        if(inStart>inEnd || posStart>posEnd)
        {
            return null;
        }
        BinaryTreeNode<Integer> root=new BinaryTreeNode<>(postorder[posEnd]);
        int index=inStart;
        while(index<=inEnd && inorder[index]!=postorder[posEnd])
        {
            index++;
        }
        int leftSize = index - inStart;
        root.left = helper2(inorder, postorder, inStart, index - 1, posStart, posStart + leftSize - 1);
        root.right = helper2(inorder, postorder, index + 1, inEnd, posStart + leftSize, posEnd - 1);
    
        return root;
    }
    public static BinaryTreeNode<Integer> binaryTree2(int inorder[],int postorder[])
    {
        if(inorder.length==0 || postorder.length==0)
        {
            return null;
        }
        return helper2(inorder, postorder, 0, inorder.length-1,0, postorder.length-1);
    }
    public static BinaryTreeNode<Integer> helper1(int inorder[],int preorder[], int inStart,int inEnd, int preStart, int preEnd)
    {
        if(inStart>inEnd || preStart>preEnd)
        {
            return null;
        }
        BinaryTreeNode<Integer> root=new BinaryTreeNode<>(preorder[preStart]);
        int index=inStart;
        while(index<=inEnd && inorder[index]!=preorder[preStart])
        {
            index++;
        }
        int leftSize = index - inStart;
        root.left = helper1(inorder, preorder, inStart, index - 1, preStart + 1, preStart + leftSize);
        root.right = helper1(inorder, preorder, index + 1, inEnd, preStart + leftSize + 1, preEnd);
        return root;
    }
    
    public static void main(String[] args) { 
        int inorder[]={ 8, 4, 9, 2, 10, 5, 11, 1, 12, 6, 13, 3, 14, 7, 15};
        int preorder[]={1, 2, 4, 8, 9, 5, 10, 11, 3, 6, 12, 13, 7, 14, 15};
        int postorder[]={8, 9, 4, 10, 11, 5, 2, 12, 13, 6, 14, 15, 7, 3, 1};
        System.out.println("Tree from preorder and inorder");
        printNode(binaryTree1(inorder, preorder));
        System.out.println("Tree from postorder and inorder");
        printNode(binaryTree2(inorder, postorder));
    }
}
