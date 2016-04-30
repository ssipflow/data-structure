
public class BinarySearchTree {
	public Node root;
	public BinarySearchTree(){
		root = null;
	}
	
	public boolean find(int key){
		Node current = this.root;
		while(current != null){
			if(current.getKey() == key)
				return true;
			else if(key < current.getKey())
				current = current.getLeft();
			else
				current = current.getRight();
		}
		return false;
	}
	
	public boolean delete(int key){
		Node parent = this.root;
		Node current = this.root;
		boolean isLeft = false;
		
		//삭제할 노드를 탐색
		while(current.getKey() != key){	
			parent = current;
			if(key < current.getKey()){
				isLeft = true;
				current = current.getLeft();
			}
			else{
				isLeft = false;
				current = current.getRight();
			}
			if(current == null){
				return false;
			}
		}
		//삭제할 노드가 단말노드일때
		if(current.getLeft() == null && current.getRight() == null){
			if(current == this.root)
				this.root = null;
			else if(isLeft)
				parent.setLeft(null);
			else
				parent.setRight(null);
		}
		//삭제할 노드가 자식노드 하나만 갖고있을 때
		if(current.getRight() == null){
			if(current == this.root)
				this.root = current.getLeft();
			else if(isLeft)
				parent.setLeft(current.getLeft());
			else
				parent.setRight(current.getLeft());
		}
		else if(current.getLeft() == null){
			if(current == this.root)
				this.root = current.getRight();
			else if(isLeft)
				parent.setLeft(current.getRight());
			else
				parent.setRight(current.getRight());
		}
		//삭제할 노드가 두개의 자식도드를 갖고 있을 떄
		else if(current.getLeft() != null && current.getRight() != null){
			Node successor = getSuccessor(current);
			if(current == this.root)
				this.root = successor;
			else if(isLeft)
				parent.setLeft(successor);
			else
				parent.setRight(successor);
			successor.setLeft(current.getLeft());
		}
		return true;
	}
	
	public Node getSuccessor(Node deleteNode){
		Node successor = null;
		Node successorParent = null;
		Node current = deleteNode.right;	//오른쪽 서브트리의 제일 왼쪽 노드를 위한 포인터
		while(current != null){
			successorParent = successor;
			successor = current;
			current = current.left;
		}
		if(successor != deleteNode.getRight()){
			successorParent.left = successor.getRight();
			successor.setRight(deleteNode.getRight());
		}
		return successor;
	}
	
	public void insertNode(int key){
		Node newNode = new Node(key);
		if(this.root == null){
			this.root = newNode;
			return;
		}
		Node current = this.root;
		Node parent = null;
		while(true){
			parent = current;
			if(key < current.key){
				current = current.getLeft();
				if(current == null){
					parent.setLeft(newNode);
					return ;
				}
			}
			else if(key > current.key){
				current = current.getRight();
				if(current == null){
					parent.setRight(newNode);
					return ;
				}
			}
		}
	}
	
	public void printTree(Node root){
		if(root != null){
			printTree(root.getLeft());
			System.out.print(root.getKey() + " ");
			printTree(root.getRight());
		}
	}
	
	public static void main(String[] args){
		BinarySearchTree b = new BinarySearchTree();
		
		b.insertNode(3);
		b.insertNode(8);
		b.insertNode(1);
		b.insertNode(4);
		b.insertNode(6);
		b.insertNode(2);
		b.insertNode(10);
		b.insertNode(9);
		b.insertNode(20);
		b.insertNode(25);
		b.insertNode(15);
		b.insertNode(16);
		System.out.println("Original Tree : ");
		b.printTree(b.root);		
		System.out.println("");
		System.out.println("Check whether Node with value 4 exists : " + b.find(4));
		System.out.println("Delete Node with no children (2) : " + b.delete(2));		
		b.printTree(b.root);
		System.out.println("\n Delete Node with one child (4) : " + b.delete(4));		
		b.printTree(b.root);
		System.out.println("\n Delete Node with Two children (10) : " + b.delete(10));		
		b.printTree(b.root);
	}
}

class Node{
	int key;
	Node left;
	Node right;
	
	Node(int key){
		this.key = key;
		this.left = null;
		this.right = null;
	}
	
	void setKey(int key){
		this.key = key;
	}
	
	int getKey(){
		return this.key;
	}
	
	void setLeft(Node left){
		this.left = left;
	}
	
	Node getLeft(){
		return this.left;
	}
	
	void setRight(Node right){
		this.right = right;
	}
	
	Node getRight(){
		return this.right;
	}
}