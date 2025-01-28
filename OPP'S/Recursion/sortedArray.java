public class sortedArray {
    public static boolean check(int input[])
    {
        if(input.length<=1)
        return true;
        if(input[0]>input[1])
        return false;
        int inputsmallarray[]=new int[input.length-1];
        for(int i=1;i<input.length;i++)
        inputsmallarray[i-1]=input[i];
        boolean ans=check(inputsmallarray);
        return ans;


    }
    public static void main(String args[])
    {
        int arr1[]={1,2,3,4,5,6,7,8,9};
        int arr2[]={1,2,3,5,6,4,8,7,9};
        int arr3[]={1};
        int arr4[]={};
        int arr5[]={1,4,6,5};
        System.out.println(check(arr1));
        System.out.println(check(arr2));
        System.out.println(check(arr3));
        System.out.println(check(arr4));
        System.out.println(check(arr5));
    }
    
}
