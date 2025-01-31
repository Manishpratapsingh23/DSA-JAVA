package Priority_Queue;
public class priorityQueueUseOone {
    private static void insertIntoVirtualarr(int arr[],int i){
        int childIndex=i;
        int parentIndex=(childIndex-1)/2;
        while(childIndex>0){
            if(arr[childIndex]<arr[parentIndex]){
                int temp=arr[childIndex];
                arr[childIndex]=arr[parentIndex];
                arr[parentIndex]=temp;
                childIndex=parentIndex;
                parentIndex=(childIndex-1)/2;
            }
            else{
                break;
            }
        } 
    }

    public static int removeMinVirtualarr(int arr[],int heapSize){
        int temp=arr[0];
        arr[0]=arr[heapSize-1];
        heapSize--;
        int parentIndex = 0;
        int leftIndex = 2 * parentIndex + 1;
        int rightIndex = 2 * parentIndex + 2;
        while (leftIndex < heapSize) {
            int minIndex = parentIndex;
            if (arr[leftIndex] < arr[minIndex]) {
                minIndex = leftIndex;
            } 
            if (rightIndex < heapSize && arr[rightIndex] < arr[minIndex]) {
                minIndex = rightIndex;
            }
            if (minIndex == parentIndex) {
                break;
            }
            int temp1 = arr[parentIndex];
            arr[parentIndex]=arr[minIndex];
            arr[minIndex]=temp1;
            parentIndex = minIndex;
            leftIndex = 2 * parentIndex + 1;
            rightIndex = 2 * parentIndex + 2;
        }
        return temp;
    }


    public static void main(String args[]){
        int arr[]={7,3,2,6,1,0,-1};
        // priorityQueue pq=new priorityQueue();
        // for(int i:arr){
        //     pq.insert(i);
        // }
        // while (!pq.isEmpty()) { 
        //     System.out.print(pq.removeMin()+" ");
        // }
        // System.out.println();
        //System.out.println("Minimum: "+pq.getMin());
        for(int i=0;i<arr.length;i++){
            insertIntoVirtualarr(arr, i);
        }
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
        for(int i=0;i<arr.length;i++){
           arr[arr.length-i-1]=removeMinVirtualarr(arr, arr.length-i);
        }
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
}
