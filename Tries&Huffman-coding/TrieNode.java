class TrieNode{
    @SuppressWarnings("unused")
    char data;
    boolean isTerminating;
    TrieNode children[];
    int childCount;
    public TrieNode(char data){
        this.data=data;
        isTerminating=false;
        children=new TrieNode[26];
        for(int i = 0; i < 26; i++) {
            children[i] = null;
            }
        childCount=0;
    }
}