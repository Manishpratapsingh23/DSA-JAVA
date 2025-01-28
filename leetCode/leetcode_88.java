class Solution {
    public void merge(int[] arr1, int m, int[] arr2, int n) {
        int i=0,j=0;
        while(i<m)
        {
            if(arr1[i]<arr2[j])
            i++;
            else if(arr1[i]>arr2[j])
            {
                int t=arr1[i];
                arr1[i]=arr2[j];
                arr2[j]=t;
                j++;
            }
        }
        int k=m+n;
        i=0;
        while(m<k)
        arr1[m++]=arr2[i++];
    }
}