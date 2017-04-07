/*--------------------------------
 * Author: Jeremy Dalcin
 * Class: Creates a linked list that can be traversed in both directions
 */
public class MyLink {
	
	public String familyMember; // value variable
	public int age; // value variable
	
	public MyLink forward; // reference variable goes forward in list
	public MyLink next; //reference variable goes back in list
	
	//constructor defining our node
	public MyLink(String familyMember, int age){
		
		this.familyMember = familyMember;
		this.age = age;
	}
	
	public void display(){
		
		System.out.println(familyMember + ": " + age + " years old");
		
	}
	
	public String toString(){
		
		return familyMember;
	}
	
	public static void main(String[] args) {
		
	}

}

class MyLinkedList {
	
	public MyLink firstLink;
	
	MyLinkedList(){
		
		firstLink = null;
		
	}
	
	MyLinkedList(MyLink newLink){
		
		this.firstLink = newLink;
		
	}
	
	public boolean isEmpty(){
		
		return(firstLink == null);
	
	}
	
	//inserts new object
	public void insertNewLink(String familyMember, int age){
		
		MyLink newLink = new MyLink(familyMember, age);
		newLink.next = firstLink;
		firstLink = newLink;
		
		if (firstLink.next != null){
			
		firstLink.next.forward = newLink;
		
		}
		
	}
	
	//removes object last inputted
	public void removeLast(){
		
		firstLink = firstLink.next;
		
	}
	
	//counts size of LinkedList
	public int counter(){
		
		int count = 0;
		MyLink tempFirstLink = firstLink;
		
		while(tempFirstLink != null){
			
			tempFirstLink = tempFirstLink.next;
			count++;
		}
		
		return count;
	}
	
	// find specific object (start from first element inputed) and combines the rest of the list back together
	public void findSpecific(int index){
		
		MyLink tempFirstLink = firstLink;
		int count = this.counter();
		
		for(int i = count; i > index; i--){
		
			firstLink = firstLink.next;
			
		}
		
		firstLink.display();
		
		for (int i = index; i < count; i++){
			
			firstLink = firstLink.forward;
			
		}
		
	}
	
	//displays last object inputed up to first object inputed
	public void displayLinkedList(){
		
		MyLink tempFirstLink = firstLink;
		
		while (tempFirstLink != null){
			
			tempFirstLink.display();
			tempFirstLink = tempFirstLink.next;
			
		}
		
		
	}
	
	
}
