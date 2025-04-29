
import java.util.Scanner;


public class kthSamllestElemntInBST {
    private BinaryTreeNode<Integer> root;
    public static void main(String[] args) {
        binarySearchTree tree= new binarySearchTree();
        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();
        while(choice != -1){
            tree.insertData(choice);
            choice = sc.nextInt();
        }
        

    }
}
