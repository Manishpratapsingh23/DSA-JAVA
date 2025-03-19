public class removeDuplicatesLetter {
    public static  String removeDuplicateLetters(String s) {
        StringBuilder st=new StringBuilder();
        boolean visited[]=new boolean[26];
        int index[]=new int[26];
        for (int i = 0; i < s.length(); i++) {
            index[s.charAt(i)-'a']=i;
        }
        for (int i = 0; i < s.length(); i++) {
            char ch=s.charAt(i);
            if (visited[ch - 'a']) continue;
            while(st.length()>0 && st.charAt(st.length() - 1)>ch &&index[st.charAt(st.length() - 1)-'a']>i){
                char c=st.charAt(st.length() - 1);
                visited[c-'a']=false;
                st.deleteCharAt(st.length() - 1);
            }
            st.append(ch);
            visited[ch-'a']=true;
        }
        return st.toString();
    }
    public static void main(String[] args) {
        String st="bcabc";  
        //"abc"
        String s1="cbacdcbc";
        //"acdb"
        System.out.println(removeDuplicateLetters(st));
        System.out.println(removeDuplicateLetters(s1));
    }
}
