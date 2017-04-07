/*-----------------
Author:Jeremy Dalcin
Class: A stack built through dynamic array resizing.
-------------------*/

import java.util.*;

public class Stack_DynamicArray {
	
	private static int[] stack = new int[1];
	private int count = 0;
	
	public void resizeBigger(){
		int[] stackTemp = new int[2*count];
		for (int i = 0; i < (stackTemp.length/2); i++){
			stackTemp[i] = stack[i];
		}
		stack = stackTemp;
	}
	
	public void resizeSmaller(){
		int[] stackTemp = new int[stack.length/2];
		for (int i = 0; i < (stack.length/2); i++){
			stackTemp[i] = stack[i];
		}
		stack = stackTemp;
	}
	
	public void push(int data){
		if (count == stack.length){
			resizeBigger();
		}
		stack[count] = data;
		count++;
	}
	
	public void pop(){
		if (count == 0){
			System.out.println("Cannot pop nothing :)");
		} else if(count == 1){
			count--;
	    } else{
			if(stack.length/2 == (count - 1) ){
				resizeSmaller();
			}
			count--;
		}
	}
	
	public int peek(){
		return stack[count-1];
	}
	
	public void show(){
		for(int i = 0; i < count; i++){
			System.out.print(stack[i] + " ");
		}
	}
	
	public void clear(){
		count = 0;
	}
	
	public static void main(String[] args){
		Stack_DynamicArray st = new Stack_DynamicArray();
		st.push(1);
		st.push(2);
		st.push(3);
		st.push(4);
		st.push(5);
		st.push(6);
		st.push(7);
		st.push(8);
		st.push(9);
		st.pop();
		st.pop();
		st.pop();
		st.pop();
		st.pop();
		st.pop();
		st.pop();
		st.pop();
		st.pop();
		st.pop();
		st.show();
		System.out.println();
		//System.out.println(st.peek() );
	}
}
