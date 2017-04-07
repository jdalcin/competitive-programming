import java.util.*;

public class Ch14_10 {

	private static class LinkedList {
		int value;
		LinkedList next;
		
		LinkedList(int value, LinkedList next) {
			this.value = value;
			this.next = next;
		}
	}
	
	private static LinkedList mergeSort(LinkedList sort1, LinkedList sort2) {
		LinkedList head = sort2.value < sort1.value ? sort2 : sort1;
		LinkedList p3 = head;
		while (true) {
			if (p3.next != null) {
				if (p3 == sort2) {
					sort2 = sort2.next;
					if (p3.next.value > sort1.value) {
						p3.next = sort1;
					}
				} else {
					sort1 = sort1.next;
					if (p3.next.value > sort2.value) {
						p3.next = sort2;
					}
				}
				p3 = p3.next;
			} else {
				p3.next = p3 == sort2 ? sort1 : sort2;
				break;
			}
		}
		return head;
	}
	
	//uses a mergesort to sort a linkedlist recursively
	//-takes O(nlogn) time complexity and O(logn) implicit space complexity
	public static LinkedList listSort(LinkedList list) {
		if (list == null || list.next == null) {
			return list;
		}
		LinkedList fast = list.next;
		LinkedList slow = list;
		//sets two pointers - slow ends at the middle of the list and fast ends at the end of it
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		LinkedList middle = slow.next;
		slow.next = null;
		LinkedList sort1 = listSort(list);
		LinkedList sort2 = listSort(middle);
		LinkedList mergeSort = mergeSort(sort1, sort2);
		return mergeSort;
	}
	
	public static void main(String []args) {
		LinkedList list = new LinkedList(3, new LinkedList(-2, new LinkedList(1, 
				new LinkedList(4, new LinkedList(99, null)))));
		LinkedList sortedList = listSort(list);
		while (sortedList != null) {
			System.out.print(sortedList.value + " ");
			sortedList = sortedList.next;
		}
	}
}
