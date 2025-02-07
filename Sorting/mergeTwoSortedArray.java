public class mergeTwoSortedArray {
    public static void main(String[] args) {
        int arr1[]={1,3,7,9,11,13,15,17};
        int arr2[]={2,4,5,10,12,};
        int m=arr1.length;
        int n=arr2.length;
        int l=m+n;
        int ans[]=new int[l];
        int i=0,j=0,k=0;
        while(i<m && j<n){
            if(arr1[i]<arr2[j]){
                ans[k++]=arr1[i++];
            }
            else{
                ans[k++]=arr2[j++];
            }
        }
        while(i<m){
            ans[k++]=arr1[i++];
        }
        while(j<n){
            ans[k++]=arr2[j++];
        }
        System.out.print("First array :");
        display(arr1);
        System.out.println();
        System.out.print("Second array :");
        display(arr2);
        System.out.println();
        System.out.print("Merged array :");
        display(ans);
    }
    public static void display(int arr[]){
        for(int i:arr){
            System.out.print(i+" ");
        }
    }
}
