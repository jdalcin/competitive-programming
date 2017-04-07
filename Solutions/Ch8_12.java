
public class Ch8_12 {
	
	//forms LinkedList
	static class LinkedList{
		int value;
		LinkedList next;
		LinkedList(int value, LinkedList next){
			this.value = value;
			this.next = next;
		}
	}
	
	//takes a list and returns if it is palindromic - takes O(n) time complexity and O(1) space complexity
	static boolean isPalindromic(LinkedList head){
		int listSize = listSize(head);
		LinkedList p1 = head;
		LinkedList p2 = head;
		for(int i = 0; i < listSize/2 -1; i++){
			p2 = p2.next;
		}
		LinkedList beforeReverse = p2; // pointer 1 node before section of list reversed
		p2 = p2.next;
		LinkedList reverseHead = reverseList(p2);
		beforeReverse.next = reverseHead;
		p2 = beforeReverse.next;
		for(int i = 0; i < listSize/2; i++){
			if(p1.value != p2.value){
				return false;
			}
			p1 = p1.next;
			p2 = p2.next;
		}
		return true;
	}
	
	//takes a list and returns its size - takes O(n) time and O(1) space complexity
	static int listSize(LinkedList head){
		LinkedList list = head;
		int size = 0;
		while(list != null){
			size++;
			list = list.next;
		}
		return size;
	}
	
	//reverses a list starting from the pointer it has been given - takes O(n) time and O(1) space complexity
	static LinkedList reverseList(LinkedList head){
		LinkedList prev = null, curr = head, temp = curr;
		while(curr != null){
			temp = curr.next;
			curr.next = prev;
			prev = curr;
			curr = temp;
		}
		return prev;
	}
	
	public static void main(String []args){
		LinkedList list = new LinkedList(2, new LinkedList(3, new LinkedList(5, new LinkedList(3, new LinkedList(2, null)))));
		System.out.println(isPalindromic(list));
	}
}
