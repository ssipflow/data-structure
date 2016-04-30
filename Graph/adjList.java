package adjList;

public class adjList {
	public Node[] adjListHead;
	public int count;
	
	public adjList(){
		this.adjListHead = new Node[30];
		this.count = 0;
		for(int i = 0; i < 30; i++)
			this.adjListHead[i] = null;
	}
	
	public void insertNode(int v){
		if(this.count + 1 > 30){
			System.out.println("Graph is full");
			return ;
		}
		this.count += 1;
	}
	
	public void insertEdge(int u, int v){
		if(u >= this.count || v >= this.count){
			System.out.println("There is no vertex in graph");
			return ;
		}
		Node newNode = new Node(v);
		newNode.setLink(this.adjListHead[u]);
		this.adjListHead[u] = newNode;
	}
	
	public void printAdjList(){
		Node temp;
		for(int i = 0; i < this.count; i++){
			System.out.printf("\n\t\tVertex %c's adjacent list", i+65);
			temp = this.adjListHead[i];
			while(temp != null){
				System.out.printf("-> %c", temp.getKey()+65);
				temp = temp.getLink();
			}
		}
		System.out.println();
	}
	
	public static void main(String[] args){
		adjList G1 = new adjList();
		adjList G2 = new adjList();
		adjList G3 = new adjList();
		adjList G4 = new adjList();
		
		for(int i = 0; i < 4; i++)
			G1.insertNode(i);
		G1.insertEdge(0, 3);
		G1.insertEdge(0, 1);
		G1.insertEdge(1, 3);
		G1.insertEdge(1, 2);
		G1.insertEdge(1, 0);
		G1.insertEdge(2, 3);
		G1.insertEdge(2, 1);
		G1.insertEdge(3, 2);
		G1.insertEdge(3, 1);
		G1.insertEdge(3, 0);
		System.out.println("G1's adjacent list");
		G1.printAdjList();
		
		for(int i = 0; i < 3; i++)
			G2.insertNode(i);
		G2.insertEdge(0, 2);
		G2.insertEdge(0, 1);
		G2.insertEdge(1, 2);
		G2.insertEdge(1, 0);
		G2.insertEdge(2, 0);
		G2.insertEdge(2, 1);
		System.out.println("G2's adjacent list");
		G2.printAdjList();
		
		for(int i = 0; i < 4; i++)
			G3.insertNode(i);
		G3.insertEdge(0, 3);
		G3.insertEdge(0, 1);
		G3.insertEdge(1, 3);
		G3.insertEdge(1, 2);
		G3.insertEdge(1, 0);
		G3.insertEdge(2, 3);
		System.out.println("G3's adjacent list");
		G3.printAdjList();
		
		for(int i = 0; i < 3; i++)
			G4.insertNode(i);
		G4.insertEdge(0, 2);
		G4.insertEdge(0, 1);
		G4.insertEdge(1, 2);
		G4.insertEdge(1, 0);
		System.out.println("G4's adjacent list");
		G4.printAdjList();
	}
}

class Node{
	int key;
	Node link;
	
	Node(int key){
		this.key = key;
		this.link = null;
	}
	
	void setKey(int key){
		this.key = key;
	}
	
	int getKey(){
		return this.key;
	}
	
	void setLink(Node link){
		this.link = link;
	}
	
	Node getLink(){
		return this.link;
	}
}
