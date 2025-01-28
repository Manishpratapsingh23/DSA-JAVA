public class sumofArray {
    public static int sum(int input[])
    {
        if(input.length==0)
        return 0;
        int inputsmallarray[]=new int[input.length-1];
        for(int i=1;i<input.length;i++)
        inputsmallarray[i-1]=input[i];
        int ans=input[0]+sum(inputsmallarray);
        return ans;


    }
    public static void main(String args[])
    {
        int arr1[]={1,2,3,4,5,6,7,8,9,10};
        System.out.println(sum(arr1));
    }
    
}
