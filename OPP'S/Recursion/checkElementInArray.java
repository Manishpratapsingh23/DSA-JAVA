public class checkElementInArray {
    public static boolean check(int input[],int x)
    {
        if(input.length==0)
        return false;
        if(x==input[0])
        return true;
        int inputsmallarray[]=new int[input.length-1];
        for(int i=1;i<input.length;i++)
        inputsmallarray[i-1]=input[i];
        boolean ans=check(inputsmallarray,x);
        return ans;


    }
    public static void main(String args[])
    {
        int arr1[]={1,2,3,4,5,6,7,8,9};
        System.out.println(check(arr1,9));
        System.out.println(check(arr1,0));
        
    }
    
}
