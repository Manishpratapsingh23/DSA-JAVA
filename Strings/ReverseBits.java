public class ReverseBits {
    public static void main(String[] args) {
        String st="00000010100101000001111010011100";
        
        int l=st.length();
        int ans= helper(st,0,l-1);
        System.out.println(ans); 
    }
    private static int helper(String st,int start,int end){
        if(start>=end){
            char ch=st.charAt(start);
            if(ch=='1'){
                return (int) Math.pow(2,start);
            }
            return 0;
        }
        int mid=(start+end)/2;
        return helper(st,start,mid)+helper(st, mid+1, end);
    }
}
