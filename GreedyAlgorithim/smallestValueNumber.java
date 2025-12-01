import java.util.*;
public class smallestValueNumber{
	public static long smallestNumber(long num) {
		int sign = num<0 ? -1 : 1;
		num = Math.abs(num);
        char[] arr = String.valueOf(num).toCharArray();
        long ans = 0;
        Arrays.sort(arr);
        if(sign==-1) reverse(arr);
        else {
        	int i=0;
        	while(i<arr.length && arr[i]=='0') i++;
        	if(i<arr.length){
        		char ch = arr[i];
        		arr[i] = arr[0];
        		arr[0] = ch;
        	}
        }
        for(char ch : arr){
        	ans = ans*10+(ch-'0');
        }
        return sign*ans;
    }

    private static void reverse(char arr[]){
    	int l=0,r=arr.length-1;
    	while(l<r){
    		char t = arr[r];
    		arr[r] = arr[l];
    		arr[l] = t;
    		l++;
    		r--;
    	}
    }

    public static void main(String agrs[]){
        System.out.println(smallestNumber(310));
        System.out.println(smallestNumber(-12345));
    }
}