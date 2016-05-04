package listStack;

public class listStack {
	node head;
	node top;
	
	public listStack(){
		head = new node();
		top = head;
	}
	
	public boolean isEmpty(){
		if(this.head.getNext() == null){
			return true;
		}
		else
			return false;
	}
	
	public void push(int data){
		node newNode = new node(data);
		top = newNode;
		
		if(isEmpty()){
			this.head.setnext(newNode);
			return ;
		}
		
		node ptr;
		ptr = this.head;
		while(ptr.getNext() != null)
			ptr = ptr.getNext();
		ptr.setnext(newNode);
	}
	
	public int pop(){
		if(isEmpty()){
			System.out.println("List is empty");
			return -1;
		}
		
		int data;
		data = this.top.getData();
		
		node ptr = this.head;
		while(ptr.getNext().getNext() != null)
			ptr = ptr.getNext();
		top = ptr;
		ptr.setnext(null);
		
		return data;
	}
	
	public void printList(){
		
		if(isEmpty()){
			System.out.println("List is empty");
			return ;
		}
		
		node ptr = this.head.getNext();
		System.out.print("List : ");
		while(ptr != null){
			System.out.print(ptr.getData() + " ");
			ptr = ptr.getNext();
		}
		System.out.println();
	}
	
	public static void main(String[] args){
		listStack stack = new listStack();
		stack.push(1);
		stack.printList();
		System.out.println("pop : " + stack.pop());
		stack.printList();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.printList();
		System.out.println("pop : " + stack.pop());
		stack.printList();
	}
}

class node{
	int data;
	node next;
	
	node(){
		this.next = null;
	}
	
	node(int data){
		this.data = data;
		this.next = null;
	}
	
	void setData(int data){
		this.data = data;
	}
	
	int getData(){
		return this.data;
	}
	
	void setnext(node next){
		this.next = next;
	}
	
	node getNext(){
		return this.next;
	}
}