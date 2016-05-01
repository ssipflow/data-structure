import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class adjList {
	static int vertexCount;
	static ArrayList<ArrayList<Integer>> graph;
	static boolean[] visited;
	
	public static void createGraph(int count){
		vertexCount = count;
		visited = new boolean[count];
		graph = new ArrayList<ArrayList<Integer>>(count); 
		for(int i = 0; i < count; i++)
			graph.add(new ArrayList<Integer>());
	}
	
	public static void insertEdge(int start, int end){
		graph.get(start).add(end);
		graph.get(end).add(start);
	}
	
	public static void DFS(int vertex){
		visited[vertex] = true;
		System.out.print((char)(vertex+65) + " ");
		for(int j: graph.get(vertex)){
			if(visited[j] == false)
				DFS(j);
		}
	}
	
	public static void BFS(int vertex){
		Queue<Integer> BFSQueue = new LinkedList<>();
		HashMap<Integer, Boolean> hash = new HashMap<>();
		
		BFSQueue.offer(vertex);
		while(!BFSQueue.isEmpty()){
			int temp = BFSQueue.poll();
			visited[temp] = true;
			System.out.print((char)(temp+65) + " ");
			
			for(int j: graph.get(temp)){
				if(visited[j] == false && !hash.containsKey(j)){
					BFSQueue.offer(j);
					hash.put(j, true);
				}
			}
		}
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
		
		System.out.println("////////// DFS>>>>>>>>");
		DFS(0);
		System.out.println();
		
		createGraph(7);
		insertEdge(0, 1);
		insertEdge(0, 2);
		insertEdge(1, 3);
		insertEdge(1, 4);
		insertEdge(2, 4);
		insertEdge(3, 6);
		insertEdge(4, 6);
		insertEdge(5, 6);
		
		System.out.println("////////// BFS>>>>>>>>");
		BFS(0);
	}
}
