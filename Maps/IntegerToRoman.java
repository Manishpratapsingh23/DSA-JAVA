
import java.util.HashMap;

public class IntegerToRoman {
    public static String intToRoman(int num) {
        if(num<0 || num>3999)
        {
            return "";
        }
        HashMap<Integer,String> map=new HashMap<>();
        map.put(1000, "M");
        map.put(900, "CM");
        map.put(500, "D");
        map.put(400, "CD");
        map.put(100, "C");
        map.put(90, "XC");
        map.put(50, "L");
        map.put(40, "XL");
        map.put(10, "X");
        map.put(9, "IX");
        map.put(5, "V");
        map.put(4, "IV");
        map.put(1, "I");
        
        int arr[]={1000,900,500,400,100,90,50,40,10,9,5,4,1};
        StringBuilder st=new StringBuilder();
        int prev=0;
        while(num>0){
            for(int i:arr)
            {
                if(i<=num){
                    prev=i;
                    break;
                }
            }
            st.append(map.get(prev));
            num-=prev;
        }
        return st.toString();
    }
    public static void main(String args[]){
        String ans=intToRoman(3999);
        System.out.println(ans);
        // outpui --> "MMMCMXCIX"
    }
}
