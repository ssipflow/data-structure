import java.util.ArrayList;

public class AdjList {
	static int vertexCount=0;
	static ArrayList<ArrayList<Integer>> adjListHead;
	static boolean[] visited;
	
	public static void DFS(int vertex){
		visited[vertex] = true;
		System.out.print((char)(vertex+65) + " ");
		
		for(int j : adjListHead.get(vertex)){
			if(!visited[j])
				DFS(j);
		}
	}
	
	public static void createGraph(int count){
		vertexCount = count;
		adjListHead = new ArrayList(vertexCount);
		visited = new boolean[vertexCount];
		
		for(int i = 0; i < vertexCount; i++)
			adjListHead.add(new ArrayList());
	}
	
	public static void insertEdge(int start, int end){
		adjListHead.get(start).add(end);
		adjListHead.get(end).add(start);
	}
	
	public static void main(String[] args){
		createGraph(7);
		
		insertEdge(0, 1);
		insertEdge(0, 2);
		insertEdge(1, 3);
		insertEdge(1, 4);
		insertEdge(2, 4);
		insertEdge(3, 6);
		insertEdge(4, 6);
		insertEdge(5, 6);
		
		DFS(0);
	}
}
