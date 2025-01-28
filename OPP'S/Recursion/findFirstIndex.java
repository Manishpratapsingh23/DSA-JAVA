import java.util.Scanner;
public class findFirstIndex {
    public static int firstIndex(int input[], int x) {
		if( input.length==0)
		return -1;
		if(input[0]==x)
		return 0;
		int newarray[]=new int[input.length-1];
		for(int i=0;i<input.length-1;i++)
		newarray[i]=input[i+1];
		int ans=firstIndex(newarray, x);
		if (ans!=-1)
		return ans+1;
		return -1;
	}
	public static void main(String[] args) {
		int[] input = {34, 57, 82 ,41 ,65 ,35 ,82, 27, 36, 12, 6 ,40 ,66 ,99, 25, 29, 22, 25, 12, 26,85, 15 ,5 ,43, 28, 33, 76, 32, 13, 95, 22, 84, 71, 23, 28 ,7 ,65, 94, 18 ,47 ,9 ,42, 61 ,73,61};
		int x=41;
        System.out.println(firstIndex(input, x));
	}
    
}
