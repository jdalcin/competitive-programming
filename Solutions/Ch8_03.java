
public class Ch8_03 {
	
	static class LinkedList{
		int value;
		LinkedList next;
		LinkedList(int value, LinkedList next){
			this.value = value;
			this.next = next;
		}
	}
	
	// reverses a sublist of a linked list - takes O(f) time complexity and O(1) space complexity ----
	// f is the distance from the first node of the entire list to the end node of the sublist
	static LinkedList reverseSublist(LinkedList head, int start, int end){
		LinkedList beforeSublist = head;
		LinkedList curr = beforeSublist;
		if(start > 1){
			for(int i = 1; i < start-1; i++){
				beforeSublist = beforeSublist.next;
			}
			curr = beforeSublist.next;
		} 
		LinkedList prev = null, temp, last = null;
		for(int i = start; i <= end; i++){
			temp = curr.next;
			curr.next = prev;
			prev = curr;
			if(i == start){
				last = prev;
			}
			curr = temp;
		}
		last.next = curr;
		if(start == 1){
			head = prev;
			return head;
		}
		beforeSublist.next = prev;
		return head;
	}
	
	public static void main(String []args){
		LinkedList list1 = new LinkedList(5, new LinkedList(10, new LinkedList(13, new LinkedList(20, new LinkedList(50, null)))));
		LinkedList temp = list1;
		System.out.print("List: ");
		while(temp != null){
			System.out.print(temp.value + " ");
			temp = temp.next;
		}
		System.out.println();
		LinkedList reverse = reverseSublist(list1, 2, 4);
		LinkedList reverseTemp = reverse;
		System.out.print("Reverse List: ");
		while(reverseTemp != null){
			System.out.print(reverseTemp.value + " ");
			reverseTemp = reverseTemp.next;
		}
		
	}
}
