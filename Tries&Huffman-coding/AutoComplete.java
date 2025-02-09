
import java.util.ArrayList;

public class AutoComplete {
    private void helper(TrieNode root,String prefix ,String currentWord){
        if(root.isTerminating){
            System.out.println(currentWord);
        }
        for(TrieNode child : root.children){
            if(child!=null) helper(child,prefix,currentWord+child.data);
        }
    }
    public void autoComplete(ArrayList<String> words, String prefix) {

        // Write your code here
        Trie tt=new Trie();
        for(String word : words){
            tt.add(word);
        }
        TrieNode root=tt.getRoot();
        TrieNode prefixNode=root;
        for (char ch : prefix.toCharArray()) {
            int index = ch - 'a';
            if (prefixNode.children[index] == null) {
                System.out.println("No suggestions found.");
                return;
            }
            prefixNode = prefixNode.children[index];
        }
        helper(prefixNode, prefix, prefix);

    }
}
