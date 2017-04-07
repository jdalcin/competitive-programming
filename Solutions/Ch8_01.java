import java.util.*;

public class Ch8_01 {
	
	//sets up LinkedList class
	static class LinkedList{
		int value;
		LinkedList next;
		LinkedList(int value, LinkedList next){
			this.value = value;
			this.next = next;
		}
	}
	
	//merges two sorted linked lists in ascending order - takes O(n) time complexity--- 
	//and O(1) space complexity
	static LinkedList merge(LinkedList list1, LinkedList list2){
		LinkedList merge;
		//decides where head of merge list should be at
		if(list1.value > list2.value){
			merge = list2;
		} else{
			merge = list1;
		}
		// combines lists in ascending sorted order - up until last node of lists
		while(list1 != null && list2 != null){
			if(list1.value > list2.value){ // list 2 pointer smaller
				if(list2.next != null){// before end of list 2
					if(list2.next.value <= list1.value){
						list2 = list2.next;
						continue;
					} else{
						LinkedList temp = list2.next;
						list2.next = list1;
						list2 = temp;
					}
				} else{ // end of list 2
					list2.next = list1;
					break;
				}
			} else{
				if(list1.next != null){ //before end of list 1
					if(list1.next.value <= list2.value){
						list1 = list1.next;
						continue;
					} else{ //list 1 pointer smaller
						LinkedList temp = list1.next;
						list1.next = list2;
						list1 = temp;
					}
				} else{ // end of list 1
					list1.next = list2;
					break;
				}
			}
		}
		return merge;
	}
	
	//textbook solution to merge - uses three pointers. Idea is there is a current pointer that is always
	//one element behind pointer 1 and pointer 2. Same time complexity as above but much more succinct code.
	static LinkedList mergeTextbook(LinkedList list1, LinkedList list2){
		LinkedList p1 = list1, p2 = list2;
		LinkedList dummyHead = new LinkedList(0, null); //the head of this list is not returned at end
		LinkedList current = dummyHead;
		while(p1 != null && p2 != null){
			if(p1.value <= p2.value){
				current.next = p1;
				p1 = p1.next;
			} else{
				current.next = p2;
				p2 = p2.next;
			}
			current = current.next;
		}
		//appends rest of list that is left onto shorter list
		current.next = p1 != null ? p1 : p2;
		return dummyHead.next;
	}
	
	//executes merge methods between linked lists
	public static void main(String [] args){
		LinkedList list1 = new LinkedList(5, new LinkedList(10, new LinkedList(13, new LinkedList(20, null))));
		LinkedList list2 = new LinkedList(3, new LinkedList(7, new LinkedList(9, new LinkedList(9, new LinkedList(13, null)))));
		LinkedList tempList1 = list1;
		LinkedList tempList2 = list2;
		System.out.print("List1: ");
		while(tempList1 != null){
			System.out.print(tempList1.value + " ");
			tempList1 = tempList1.next;
		}
		System.out.println();
		System.out.print("List2: ");
		while(tempList2 != null){
			System.out.print(tempList2.value + " ");
			tempList2 = tempList2.next;
		}
		//outputs merge
		LinkedList merge = mergeTextbook(list1, list2);
		System.out.println();
		System.out.print("Merged List: ");
		while(merge != null){
			System.out.print(merge.value + " ");
			merge = merge.next;
		}
	}
	
}
