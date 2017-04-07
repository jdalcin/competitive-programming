
public class Ch8_9 {
	
	//forms LinkedList
	static class LinkedList{
		int value;
		LinkedList next;
		LinkedList(int value, LinkedList next){
			this.value = value;
			this.next = next;
		}
	}
	
	//removes successor node on a given list - takes O(1) time and space complexity
	static void removeSuccessor(LinkedList node){
		node.next = node.next.next;
	}
	
	//removes duplicates from a list - takes O(n) time complexity and O(1) space complexity
	static void deleteDuplicates(LinkedList head){
		LinkedList p1 = head;
		while(p1 != null){
			if(p1.value == p1.next.value){
				removeSuccessor(p1);
			}
			p1 = p1.next;
		}
	}
	
	public static void main(String []args){
		LinkedList list = new LinkedList(2, new LinkedList(2, new LinkedList(3, new LinkedList(3, new LinkedList(5, new LinkedList(7, new LinkedList(11, new LinkedList(11, null))))))));
		LinkedList temp = list;
		System.out.print("Original List: ");
		while(temp != null){
			System.out.print(temp.value + " ");
			temp = temp.next;
		}
		System.out.println();
		deleteDuplicates(list);
		System.out.print("After duplicates deleted: ");
		while(list != null){
			System.out.print(list.value + " ");
			list = list.next;
		}
	}
}
