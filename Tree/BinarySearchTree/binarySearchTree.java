import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class binarySearchTree {
    private BinaryTreeNode<Integer> root; 
    private BinaryTreeNode<Integer> insertDataHelper(int data, BinaryTreeNode<Integer> root) {
        if (root == null) {
            return new BinaryTreeNode<>(data);
        }
        if (data <= root.data) {
            root.left = insertDataHelper(data, root.left);
        } else if (data > root.data) {
            root.right = insertDataHelper(data, root.right);
        }
        return root; 
    }
    public void insertData(int data) {
        root = insertDataHelper(data, root);
    }
    public void deleteData(int data) {
        root = deleteDataHelper(data, root);
    }
    private BinaryTreeNode<Integer> deleteDataHelper(int data, BinaryTreeNode<Integer> root) {
        if (root == null) {
            return null;
        }
        if (data < root.data) {
            root.left = deleteDataHelper(data, root.left);
        } else if (data > root.data) {
            root.right = deleteDataHelper(data, root.right);
        } else {
            if (root.left == null && root.right == null) {
                return null;
            } else if (root.left == null) {
                return root.right; 
            } else if (root.right == null) {
                return root.left; 
            } else {
                BinaryTreeNode<Integer> minNode = root.right;
                while (minNode.left != null) {
                    minNode = minNode.left;
                }
                root.data = minNode.data; // Replace root's data
                root.right = deleteDataHelper(minNode.data, root.right); // Delete the minimum node
            }
        }
        return root;
    }
    public boolean hasData(int data) {
        return hasDataHelper(data, root);
    }
    private boolean hasDataHelper(int data, BinaryTreeNode<Integer> root) {
        if (root == null) {
            return false;
        }
        if (data == root.data) {
            return true;
        } else if (data < root.data) {
            return hasDataHelper(data, root.left);
        } else {
            return hasDataHelper(data, root.right);
        }
    }
    public void printBinaryTree() {
        if (root == null) {
            System.out.println("Tree is empty.");
            return;
        }
        Queue<BinaryTreeNode<Integer>> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            BinaryTreeNode<Integer> node = queue.poll();
            String leftData = (node.left != null) ? node.left.data.toString() : "-1";
            String rightData = (node.right != null) ? node.right.data.toString() : "-1";
            System.out.println(node.data + ":L:" + leftData + ",R:" + rightData);

            // Enqueue children
            if (node.left != null) queue.add(node.left);
            if (node.right != null) queue.add(node.right);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        binarySearchTree tree = new binarySearchTree();
        System.out.println("Enter your choice: \n 1. Insert Data \n 2. Delete Data \n 3. Check Data \n 4. Print Tree \n -1. Exit");
        int choice = sc.nextInt();

        while (choice != -1) {
            switch(choice) {
                case 1 -> {
                    System.out.print("Enter data to be inserted: ");
                    int insertData = sc.nextInt();
                    tree.insertData( insertData);
                }

                case 2 -> {
                    System.out.print("Enter data to be deleted: ");
                    int deleteData = sc.nextInt();
                   tree.deleteData(deleteData);
                }

                case 3 -> {
                    System.out.print("Enter data to check: ");
                    int checkData = sc.nextInt();
                    boolean ans = tree.hasData(checkData);
                    System.out.println("Data exists: " + ans);
                }

                case 4 -> {
                    System.out.println("Binary Tree:");
                    tree.printBinaryTree();
                }

                default -> System.out.println("Invalid choice. Please try again.");
            }
            System.out.println("\nEnter your choice: \n 1. Insert Data \n 2. Delete Data \n 3. Check Data \n 4. Print Tree \n -1. Exit");
            choice = sc.nextInt(); // Update the choice to avoid an infinite loop
        }
        System.out.println("Program terminated.");
        sc.close();
    }
}
