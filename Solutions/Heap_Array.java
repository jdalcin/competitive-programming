/*------------
 * Author: Jeremy Dalcin
 * Class: creates a maxHeap using a dynamic resizing array.
 -------------*/
public class Heap_Array {
	private int[] heap = new int[0];
	private int count = 0;
	
	void resizeBigger(){
		if(heap.length == 0){
			heap = new int[1];
			return;
		}
		int[] heapTemp = new int[2*heap.length];
		for(int i = 0; i < heap.length;i++){
			heapTemp[i] = heap[i];
		}
		heap = heapTemp;
	}
	
	void resizeSmaller(){
		int[] heapTemp = new int[heap.length/2];
		for(int i = 0; i < heap.length/2;i++){
			heapTemp[i] = heap[i];
		}
		heap = heapTemp;
	}
	
	void add(int data){
		
		if(heap.length == count){
			resizeBigger();
		}
		if(heap.length == 1){
			heap[0] = data;
		} else{
			heap[count] = data;
			int parent = (int) Math.floor((count-1)/2);
			int child = count;
			while(true){
				if(heap[child] > heap[parent]){
					int childTemp = heap[child];
					heap[child] = heap[parent];
					heap[parent] = childTemp;
					child = parent;
					parent = (int) Math.floor((child-1)/2);
				} else{
					heap[child] = data;
					break;
				}
			}
		}
		count++;
		return;
	}
	
	void removeMax(){
		heap[0] = heap[count-1];//puts end of heap value at top
		int parent = 0;
		int leftChild = 2*parent+1;
		int rightChild = 2*parent+2;
		count--;
		if(heap.length/2 == count){
			resizeSmaller();
		}
		while(leftChild < count && rightChild < count){
			//checks if children are greater than parent
			if(heap[leftChild] > heap[parent] || heap[rightChild] > heap[parent]){
				int parentTemp = heap[parent];
				//if children are greater, checks which one is the greatest and then swaps
				if(heap[leftChild] >= heap[rightChild]){
				heap[parent]=heap[leftChild];
				heap[leftChild] = parentTemp;
				parent = leftChild;
				} else{
					heap[parent]=heap[rightChild];
					heap[rightChild] = parentTemp;
					parent = rightChild;
				}
			} else{
				return;
			}
			leftChild = 2*parent+1;
			rightChild = 2*parent+2;
		}
		//checks for last case: where object traverses down to an index without a brother
		if(leftChild < count && heap[leftChild] > heap[parent]){
				int parentTemp = heap[parent];
				heap[parent]=heap[leftChild];
				heap[leftChild] = parentTemp;
		}
	}
	
	void show(){
		for(int i = 0; i < count; i++){
			System.out.print(heap[i] + " ");
		}
	}
	
	void clear(){
		heap = new int[1];
		count = 0;
	}
	
	public static void main(String[] args){
		Heap_Array he = new Heap_Array();
		he.add(100);
		he.add(50);
		he.add(40);
		he.add(28);
		he.add(27);
		he.add(26);
		he.add(23);
		he.add(20);
		he.add(30);
		//he.removeMax();
		he.show();
		System.out.println();
		System.out.println(he.count);
	}
}
