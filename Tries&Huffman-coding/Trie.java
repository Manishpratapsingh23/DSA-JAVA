

public class Trie {
    private TrieNode root;
    private  int totalWords;
    public Trie(){
        root=new TrieNode('\0');
        totalWords=0;
    }
    private void add(TrieNode root,String word){
        if(word.length()==0){
            root.isTerminating=true;
            totalWords++;
            return;
        }
        int childIndex=word.charAt(0)-'a';
        TrieNode child=root.children[childIndex];
        if(child==null){
            child=new TrieNode(word.charAt(0));
            root.children[childIndex]=child;
            root.childCount++;
        }
        add(child, word.substring(1));
    }
    public void add(String word){
        add(root,word);
    }
    private boolean search(TrieNode root,String word){
        if( word.length()==0){
			return root.isTerminating;
		}
		int childIndex=word.charAt(0)-'a';
        TrieNode child=root.children[childIndex];
		if(child==null){
			return false;
		} 
        return search(child, word.substring(1));
    }
    public boolean search(String word){
        return  search(root, word);
    }
    private void delete(TrieNode root,String word){
        if(word.length()==0){
            root.isTerminating=false;
            totalWords--;
            return;
        }
        int childIndex=word.charAt(0)-'a';
        TrieNode child=root.children[childIndex];
        if(child==null){
            return;
        }
        delete(child, word.substring(1));
        /*
         As we have directly made terminating point to non terminating,
         however the word will not be present but it will take space
         so to reduce the space we will delete the node only if
         1. node is non-terminating
         2. node has no child --> no. of children is zero 
         */
        // if(!child.isTerminating){
        //     int numChild=0;
        //     for(int i=0;i<26;i++){
        //         if(child.children[i]!=null) numChild++;
        //     }
        //     if(numChild==0){
        //         root.children[childIndex]=null;
        //         child=null;
        //     }
        // }
        if(!child.isTerminating && child.childCount==0){
            root.children[childIndex]=null;
            child=null;
            root.childCount--;
        }
    }
    public void delete(String word){
        delete(root, word);
    }
    public int countWords(){
        return totalWords;
    }
    private void print(TrieNode root, String word) {
		if (root == null) {
			return;
		}
		
		if (root.isTerminating) {
			System.out.println(word);
		}
		
		for (TrieNode child : root.children) {
			if (child == null) {
				continue;
			}
			String fwd = word + child.data;
			print(child, fwd);
		}
	}
	
	public void print() {
		print(this.root, "");
	}
    public TrieNode getRoot(){
        return root;
    }
}


