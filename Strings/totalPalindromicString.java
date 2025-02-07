public class totalPalindromicString{
    public static void main(String[] args) {
        String st="nitin";
        int ans=countPalindromicSubString(st);
        System.out.println(ans);
    }
    private static int countPalindromicSubString(String st){
        int odd=0;
        for(int axis=0;axis<st.length();axis++){
            for(int orbit=0;axis-orbit>-1 && axis+orbit<st.length(); orbit++){
                if(st.charAt(axis-orbit)!=st.charAt(axis+orbit)){
                    break;
                }
                odd++;
            }
        }
        int even=0;
        for(double axis=0.5;axis<st.length();axis++){
            for(double orbit=0.5;axis-orbit>-1 && axis+orbit<st.length(); orbit++){
                if(st.charAt((int)(axis-orbit))!=st.charAt((int)(axis+orbit))){
                    break;
                }
                even++;
            }
        }
        return even+odd;
    }
}