package Priority_Queue;
import java.util.ArrayList;
public class priorityQueueMax {
    private ArrayList<Integer> heap;
    public priorityQueueMax(){
        heap=new ArrayList<>();
    }
    public boolean isEmpty() {
		// Implement the isEmpty() function here
        return heap.size()==0;
	}

	public int getSize() {
		// Implement the getSize() function here
        return heap.size();
	}

	public int getMax() throws PriorityQueueEmptyException{
		// Implement the getMax() function here
        if(isEmpty()){
            throw new PriorityQueueEmptyException();
        }
        return heap.get(0);
	}

	public void insert(int element) {
		// Implement the insert() function here
        heap.add(element);
        int childIndex=heap.size()-1;
        int parentIndex=(childIndex-1)/2;
        while(childIndex>0 && heap.get(childIndex)>heap.get(parentIndex)){
            int temp=heap.get(childIndex);
            heap.set(childIndex,heap.get(parentIndex));
            heap.set(parentIndex,temp);
            childIndex=parentIndex;
            parentIndex=(childIndex-1)/2;
        }

	}

	public int removeMax() throws PriorityQueueEmptyException{
		// Implement the removeMax() function here
        if(isEmpty()){
            throw new PriorityQueueEmptyException();
        }
    int ans = heap.get(0);
    int size = heap.size();
    
    heap.set(0, heap.get(size - 1));
    heap.remove(size - 1);

    int parentIndex = 0;
    int leftIndex = 2 * parentIndex + 1;
    int rightIndex = 2 * parentIndex + 2;
        while (leftIndex < heap.size()) {
            int minIndex = parentIndex;
            if (heap.get(leftIndex) > heap.get(minIndex)) {
                minIndex = leftIndex;
            } 
            if (rightIndex < heap.size() && heap.get(rightIndex) > heap.get(minIndex)) {
                minIndex = rightIndex;
            }
            if (minIndex == parentIndex) {
                break;
            }
            int temp = heap.get(parentIndex);
            heap.set(parentIndex, heap.get(minIndex));
            heap.set(minIndex, temp);
            parentIndex = minIndex;
            leftIndex = 2 * parentIndex + 1;
            rightIndex = 2 * parentIndex + 2;
        }
        return ans;

	}
}
