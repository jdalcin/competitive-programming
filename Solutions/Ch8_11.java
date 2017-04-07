
public class Ch8_11 {
	
	//forms LinkedList
	static class LinkedList{
		int value;
		LinkedList next;
		LinkedList(int value, LinkedList next){
			this.value = value;
			this.next = next;
		}
	}
	
	//takes a list and merges the even nodes, and then odd nodes directly after them - takes O(n) time complexity and -
	// O(1) space complexity
	static void evenOddMerge(LinkedList head){
		LinkedList pEven = head;
		LinkedList headOdd = head.next;
		LinkedList pOdd = head.next;
		LinkedList tailEven = head;
		while(pEven.next != null && pOdd.next != null){
			pEven.next = pEven.next.next;
			pEven = pEven.next;
			pOdd.next = pOdd.next.next;
			pOdd = pOdd.next;
		}
		if(pEven.next == null){
			tailEven = pEven; //tail node of even list
		}
		if(pOdd != null){
			pOdd.next = null;
		}
		if(tailEven != head){
			tailEven.next = headOdd;
		} else{
			pEven.next = headOdd;
		}
	}
	
	public static void main(String []args){
		LinkedList list = new LinkedList(1, new LinkedList(2, new LinkedList(3, new LinkedList(4, new LinkedList(5, new LinkedList(6, new LinkedList(7, null)))))));
		System.out.print("Original List: ");
		LinkedList temp = list;
		while(temp != null){
			System.out.print(temp.value + " ");
			temp = temp.next;
		}
		System.out.println();
		evenOddMerge(list);
		System.out.print("After even-odd merge: ");
		while(list != null){
			System.out.print(list.value + " ");
			list = list.next;
		}
	}
}
