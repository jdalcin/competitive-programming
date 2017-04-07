
public class Ch8_10 {
	
	//forms LinkedList
	static class LinkedList{
		int value;
		LinkedList next;
		LinkedList(int value, LinkedList next){
			this.value = value;
			this.next = next;
		}
	}
	
	//shifts a list to the right by amount "shift" - takes O(n) time and O(1) space complexity
	static LinkedList cyclicRightShift(LinkedList head, int shift){
		if(shift == 0){
			return head;
		}
		LinkedList p1 = head;
		LinkedList shiftedHead = p1;
		for(int i = 0; i < shift; i++){
			p1 = p1.next;
		}
		while(p1.next != null){
			p1 = p1.next;
			shiftedHead = shiftedHead.next;
		}
		LinkedList beforeShiftedHead = shiftedHead; //one position before the shifted head
		shiftedHead = shiftedHead.next;
		beforeShiftedHead.next = null;
		p1.next = head; //reconnects the list from the tail end
		return shiftedHead;
		
	}
	
	public static void main(String []args){
		LinkedList list = new LinkedList(1, new LinkedList(2, new LinkedList(3, new LinkedList(4, new LinkedList(5, null)))));
		System.out.print("Original List: ");
		LinkedList temp = list;
		while(temp != null){
			System.out.print(temp.value + " ");
			temp = temp.next;
		}
		System.out.println();
		int shift = 3;
		LinkedList shiftList = cyclicRightShift(list, shift);
		System.out.print("Shifted by " + shift + ": ");
		while(shiftList != null){
			System.out.print(shiftList.value + " ");
			shiftList = shiftList.next;
		}
	}
	
}
