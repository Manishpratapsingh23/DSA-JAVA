public class checkSortedArrayBetter {
    public static boolean check(int input[], int index){
        if (input.length -1==index || input.length==0)
            return true;
        if (input[index]>input[index+1])
            return false;
        boolean ans = check(input, index+1);
        return ans;

    }
    public static boolean checkSortedArrayInBetter(int input[])
    {
        return check(input,0);
    }

    public static void main(String args[]) {
        int arr1[]={1,2,3,4,5,6,7,8,9};
        int arr2[]={1,2,3,5,6,4,8,7,9};
        int arr3[]={1};
        int arr4[]={};
        int arr5[]={1,4,6,5};
        System.out.println(checkSortedArrayInBetter(arr1));
        System.out.println(checkSortedArrayInBetter(arr2));
        System.out.println(checkSortedArrayInBetter(arr3));
        System.out.println(checkSortedArrayInBetter(arr4));
        System.out.println(checkSortedArrayInBetter(arr5));

    }

}
