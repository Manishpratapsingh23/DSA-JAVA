import java.util.HashMap;
import java.util.PriorityQueue;

class HuffmanNode{
    char data;
    int frequency;
    HuffmanNode left,right;
    public HuffmanNode(char data, int frequency){
        this.data=data;
        this.frequency=frequency;
        left=null;
        right=null;
    }
}
public class HuffmanCoding {
    public static void main(String[] args) {
        String message = "Huffman coding is a lossless data compression algorithm.";
        HashMap<Character,Integer> map=new HashMap<>();
        for(char c:message.toCharArray()){
            map.put(c,map.getOrDefault(c, 0)+1);
        }
        PriorityQueue<HuffmanNode> priorityQueue = new PriorityQueue<>((a, b) -> a.frequency - b.frequency);
        for (char c : map.keySet()) {
            priorityQueue.add(new HuffmanNode(c, map.get(c)));
        }
        while (priorityQueue.size() > 1) {
            // Remove the two nodes with the lowest frequency
            HuffmanNode left = priorityQueue.poll();
            HuffmanNode right = priorityQueue.poll();

            // Create a new internal node with these two nodes
          	// as children and add it back to the queue
            HuffmanNode newNode =
              new HuffmanNode('$', left.frequency + right.frequency);
          
            newNode.left = left;
            newNode.right = right;
            priorityQueue.add(newNode);
        }

        // The remaining node is the root of the Huffman Tree
        HuffmanNode root = priorityQueue.poll();

        // Print the Huffman codes for each character
        System.out.println("Huffman codes:");
        printCodes(root, new StringBuilder());
    }
    public static void printCodes(HuffmanNode root, StringBuilder code) {
        if (root == null) return;

        // If this is a leaf node, print the character and its code
        if (root.data != '$') {
            System.out.println(root.data + ": " + code);
        }
        
        // Traverse the left subtree
        if (root.left != null) {
            printCodes(root.left, code.append('0'));
            code.deleteCharAt(code.length() - 1);
        }
        
        // Traverse the right subtree
        if (root.right != null) {
            printCodes(root.right, code.append('1'));
            code.deleteCharAt(code.length() - 1);
        }
    }
}
