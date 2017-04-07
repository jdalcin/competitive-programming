
public class Ch8_13 {
	
	//forms LinkedList
	static class LinkedList{
		int value;
		LinkedList next;
		LinkedList(int value, LinkedList next){
			this.value = value;
			this.next = next;
		}
	}
	
	//forms list pivot around a value "pivot" - takes O(n) time complexity and O(1) space complexity
	static LinkedList listPivot(LinkedList head, int pivot){
		//creates 3 starts for lists
		LinkedList pBeforePivot = new LinkedList(0, null);
		LinkedList startPBeforePivot = pBeforePivot;
		LinkedList pPivot = new LinkedList(0,null);
		LinkedList startPPivot = pPivot;
		LinkedList pAfterPivot = new LinkedList(0, null);
		LinkedList startPAfterPivot = pAfterPivot;
		while(head != null){
			if (head.value < pivot){
				pBeforePivot.next = head;
				pBeforePivot = pBeforePivot.next;
			} else if (head.value == pivot){
				pPivot.next = head;
				pPivot = pPivot.next;
			} else{
				pAfterPivot.next = head;
				pAfterPivot = pAfterPivot.next;
			}
			head = head.next;
		}
		if(startPPivot.next == null){
			return null;
		}
		//combine 3 lists
		pBeforePivot.next = startPPivot.next;
		pPivot.next = startPAfterPivot.next;
		return startPBeforePivot.next;	
	}
	
	public static void main(String []args){
		LinkedList list = new LinkedList(3, new LinkedList(2, new LinkedList(2, new LinkedList(11, new LinkedList(7, new LinkedList(5, new LinkedList(11, null)))))));
		int pivot = 7;
		System.out.print("Original List: ");
		LinkedList temp = list;
		while(temp != null){
			System.out.print(temp.value + " ");
			temp = temp.next;
		}
		System.out.println();
		LinkedList pivotedList = listPivot(list, pivot);
		System.out.print("Pivoted List around " + pivot + ": ");
		while(pivotedList != null){
			System.out.print(pivotedList.value + " ");
			pivotedList = pivotedList.next;
		}
	}
	
}
