
public class Ch8_14 {
	
	//forms LinkedList
	static class LinkedList{
		int value;
		LinkedList next;
		LinkedList(int value, LinkedList next){
			this.value = value;
			this.next = next;
		}
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
	
	//adds two lists together starting from the least significant digit - takes O(n + m) time complexity and 
	//O(max(n,m)) space complexity
	static LinkedList add(LinkedList head1, LinkedList head2){
		LinkedList add = new LinkedList(0, null);
		LinkedList startAdd = add;
		int remainder = 0;
		//adds two lists together up until one list ends 
		while(head1 != null && head2 != null){
			int value = (head1.value + head2.value + remainder) % 10;
			remainder = (head1.value + head2.value + remainder) / 10;
			add.next = new LinkedList(value, null);
			add = add.next;
			head1 = head1.next;
			head2 = head2.next;
		}
		
		if(head1 != null){
			while(head1 != null){
				add.next = new LinkedList(head1.value + remainder, null);
				add = add.next;
				remainder = 0;
				head1 = head1.next;
			}
		}
		if(head2 != null){
			while(head2 != null){
				add.next = new LinkedList(head2.value + remainder, null);
				add = add.next;
				remainder = 0;
				head2 = head2.next;
			}
		}
		if(head1 == null && head2 == null && remainder != 0){
			add.next = new LinkedList(remainder, null);
		}
		LinkedList addReverse = reverseList(startAdd.next);
		return addReverse;
	}
	
	public static void main(String []args){
		LinkedList list1 = new LinkedList(3, new LinkedList(1, new LinkedList(4, null)));
		LinkedList list2 = new LinkedList(7, new LinkedList(0, null));
		System.out.print("List added: ");
		LinkedList added = add(list1, list2);
		while(added != null){
			System.out.print(added.value);
			added = added.next;
		}
	}
}
