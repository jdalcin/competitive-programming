
public class Ch8_02 {
	
	
	//sets up LinkedList class
	static class LinkedList{
		int value;
		LinkedList next;
		LinkedList(int value, LinkedList next){
			this.value = value;
			this.next = next;
		}
	}
	
	//reverses a linkedlist through recursion - takes O(n) time and space complexity
	static LinkedList reverseRecursion(LinkedList list1){
		if(list1.next == null){
			return list1;
		}
		LinkedList reverse = reverseRecursion(list1.next);
		list1.next.next = list1;
		list1.next = null;
		return reverse;
	}
	
	//reverses a linkedlist without recursion - takes O(n) time complexity and O(1) space complexity
	static LinkedList reverse(LinkedList list1){
		LinkedList prev = null, curr = list1, temp;
		while(curr != null){
			temp = curr.next;
			curr.next = prev;
			prev = curr;
			curr = temp;
		}
		return prev;
	}
	
	//executes a reversal of a linkedlist
	public static void main(String []args){
		LinkedList list1 = new LinkedList(5, new LinkedList(10, new LinkedList(13, new LinkedList(20, new LinkedList(50, null)))));
		LinkedList temp = list1;
		System.out.print("List: ");
		while(temp != null){
			System.out.print(temp.value + " ");
			temp = temp.next;
		}
		System.out.println();
		LinkedList reverse = reverse(list1);
		LinkedList reverseTemp = reverse;
		System.out.print("Reverse List: ");
		while(reverseTemp != null){
			System.out.print(reverseTemp.value + " ");
			reverseTemp = reverseTemp.next;
		}
		
	}
}
