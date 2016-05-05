
public class LinkedList {
	Node head;
	
	LinkedList(){
		this.head = new Node();
	}
	
	boolean isEmpty(){
		if(this.head.getNext() == null)
			return true;
		else
			return false;
	}
	
	void insertNode(int data){
		Node newNode = new Node(data);
		
		if(isEmpty())
			this.head.setNext(newNode);
		else{
			Node ptr = this.head.getNext();
			
			while(ptr.getNext() != null)
				ptr = ptr.getNext();
			ptr.setNext(newNode);
		}
	}
	
	int findLastElement(int m){
		int data;
		
		if(isEmpty()){
			System.out.println("List is empty");
			return -1;
		}
		
		Node curPos = this.head.getNext();
		Node lastPos = this.head.getNext();
		if(m == 0){
			while(curPos.getNext() != null)
				curPos = curPos.getNext();
			data = curPos.getData();
		}
		else{
			for(int i = 0; i < m; i++)
				lastPos = lastPos.getNext();
			while(lastPos.getNext() != null){
				curPos = curPos.getNext();
				lastPos = lastPos.getNext();
			}
			data = curPos.getData();
		}
				
		return data;
	}
	
	void printList(){
		if(isEmpty()){
			System.out.println("List is empty");
			return ;
		}
		
		Node ptr = this.head.getNext();
		System.out.print("List : ");
		while(ptr != null){
			System.out.print(ptr.getData() + " ");
			ptr = ptr.getNext();
		}
		System.out.println();
	}
	
	public static void main(String[] args){
		LinkedList l1 = new LinkedList();
		l1.insertNode(1);
		l1.insertNode(2);
		l1.insertNode(3);
		l1.insertNode(4);
		l1.insertNode(5);
		l1.insertNode(6);
		l1.printList();
		System.out.println(l1.findLastElement(0));
		System.out.println(l1.findLastElement(3));
	}
}

class Node{
	int data;
	Node next;
	
	Node(){
		this.next = null;
	}
	
	Node(int data){
		this.data = data;
		this.next = null;
	}
	
	void setData(int data){
		this.data = data;
	}
	
	int getData(){
		return this.data;
	}
	
	void setNext(Node next){
		this.next = next;
	}
	
	Node getNext(){
		return this.next;
	}
}