
import java.util.Collections;
import java.util.PriorityQueue;
/*
You are given a stream of 'N' integers. For every 'i-th' integer added to the running list of integers,
print the resulting median.

Print only the integer part of the median.

Detailed explanation ( Input/output format, Notes, Images )
Sample Input 1 :
6
6 2 1 3 7 5
Sample Output 1 :
6 4 2 2 3 4
Explanation of Sample Output 1 :
S = {6}, median = 6
S = {6, 2} -> {2, 6}, median = 4
S = {6, 2, 1} -> {1, 2, 6}, median = 2
S = {6, 2, 1, 3} -> {1, 2, 3, 6}, median = 2
S = {6, 2, 1, 3, 7} -> {1, 2, 3, 6, 7}, median = 3
S = {6, 2, 1, 3, 7, 5} -> {1, 2, 3, 5, 6, 7}, median = 4
Sample Input 2 :
5
5 4 3 2 1
Sample Output 2 :
5 4 4 3 3
 */
// OYO AMAZON MYNTRA SPRINKLER MICROSOFT PAYTM FLIPKART GOOGLE WIPRO HIKE 
//UBER CUEMATH
public class RunningMedian {
    public static void findMedian(int arr[])  {
        
        
        /* Your class should be named Solution
		 * Don't write main().
		 * Don't read input, it is passed as function argument.
		 * Return output and don't print it.
	 	 * Taking input and printing output is handled automatically.
        */
        PriorityQueue<Integer> maxHeap=new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minHeap=new PriorityQueue<>();
        for(int i : arr){
            if(maxHeap.isEmpty()){
                maxHeap.add(i);
            }
            else if(i>maxHeap.peek()){
                minHeap.add(i);
                if( (minHeap.size() - maxHeap.size()) > 1 ) {
					int p = minHeap.remove();
					maxHeap.add(p);
				}
            }
            else{
                maxHeap.add(i);
                if( (maxHeap.size() - minHeap.size()) > 1 ) {
					int p = maxHeap.remove();
					minHeap.add(p);
				}
            }
            if(maxHeap.size()>minHeap.size()){
                    System.out.print(maxHeap.peek()+" ");
            }
            else if(maxHeap.size() < minHeap.size()) {
				System.out.print(minHeap.peek()+" ");
			}
			else {
				System.out.print( (maxHeap.peek() + minHeap.peek()) /2  +" ");
			}
    }
}
    public static void main(String[] args) {
        int arr[]={6,2,1,3,7,5};
        findMedian(arr);
    }
}
