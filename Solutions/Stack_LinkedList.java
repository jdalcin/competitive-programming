/*-----------------
Author:Jeremy Dalcin
Class: A stack built through a singly Linked List.
-------------------*/

public class Stack_LinkedList {
	private static Node2 head;
	
	public void push(int data){
		Node2 p = new Node2(data);
		p.next = head;
		head = p;
	}
	
	public void pop(){
		if (head != null){
		head = head.next;
		} else{
			System.out.println("Cannot pop a null space.");
		}		
	}
	
	public int peek(){
		if (head == null){
			System.out.println("This a null space.");
		} 
		return head.data;
	}
	
	public boolean isEmpty(){
		if(head == null){
			return true; 
		} else{
			return false;
		}
	}
	
	public void clear(){
		head = null;
	}
	
	public void show(){
		Node2 temp = head;
		while(temp != null){
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
	}
	
	public static void main(String[] args){
		Stack_LinkedList st = new Stack_LinkedList();
		st.push(5);
		st.push(4);
		st.push(3);
		st.push(2);
		st.push(1);
		st.pop();
		st.pop();
		st.show();
		System.out.println();
		System.out.println(st.peek() );
		System.out.println(st.isEmpty() );
		st.clear();
		System.out.println(st.isEmpty() );
		st.pop();
	}
}


class Node2{
	int data;
	Node2 next;
	
	Node2(int data){
		this.data = data;
	}
}
