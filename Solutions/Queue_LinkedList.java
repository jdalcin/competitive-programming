/*--------------
 * Author: Jeremy Dalcin
 * Class: Creates a queue using a singly-linked list.
 ---------------*/

public class Queue_LinkedList {
	private static Node3 head;
	private static Node3 tail;
	
	public void enqueue(int data){
		Node3 p = new Node3(data);
		if(head == null && tail == null){
		head = p;
		tail = head;
		} else{
			head.next = p;
			head = p;
		}
	}
	
	public void dequeue(){
		if (head == null && tail == null){
			System.out.println("Cannot pop what is not there.");
		} else{
			tail = tail.next;
		}
	}
	
	public boolean isEmpty(){
		if(head == null && tail == null){
			return true;
		} else{
			return false;
		}
	}
	
	public void peekBack(){
		if (tail == null){
			System.out.println("Nothing there.");
		} else{
		System.out.println(tail.data);
		}
	}
	
	public void peekFront(){
		if (head == null){
			System.out.println("Nothing there.");
		} else{
		System.out.println(head.data);
		}
	}
	
	public void show(){
		if(tail == null){
			System.out.println("Nothing there.");
		}
		Node3 tailTemp = tail;
		while(tailTemp != null){
			System.out.print(tailTemp.data + " ");
			tailTemp = tailTemp.next;
		}
	}
	
	public void clear(){
		tail = null;
		head = null;
	}
	
	public static void main(String[] args){
		Queue_LinkedList qu = new Queue_LinkedList();
		qu.enqueue(4);
		qu.enqueue(3);
		qu.enqueue(2);
		qu.enqueue(1);
		qu.dequeue();
		qu.clear();
		qu.enqueue(1);
		qu.enqueue(2);
		qu.enqueue(3);
		qu.peekBack();
		qu.peekFront();
		qu.show();
		System.out.println();
		System.out.println(qu.isEmpty() );
	}
	
}

class Node3{
	int data;
	Node3 next;
	
	Node3(int data){
		this.data = data;
	}
	
}