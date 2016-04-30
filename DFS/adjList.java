import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class adjList {
	static int vertexCount;
	static int edgeCount;
	static boolean[] visit;
	static ArrayList<ArrayList<Integer>> adjacentList;
	
	public static void DFS(int i){
		visit[i] = true;
		System.out.print((char)(i+65) + " ");
		
		for(int j : adjacentList.get(i)){
			if(visit[j] == false)
				DFS(j);
		}
	}
	
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		System.out.print("Type the number of vertexs : ");
		vertexCount = scan.nextInt();
		System.out.print("Type the number of edges : ");
		edgeCount = scan.nextInt();
		adjacentList = new ArrayList(vertexCount + 1);
		visit = new boolean[vertexCount + 1];
		
		for(int i = 0; i < vertexCount+1; i++){
			adjacentList.add(new ArrayList());
		}
		
		for(int i = 0; i < edgeCount; i++){
			System.out.print("Type the number of head vertex : ");
			int t1 = scan.nextInt();
			System.out.print("Type the number of tail vertex : ");
			int t2 = scan.nextInt();
			
			adjacentList.get(t1).add(t2);
			adjacentList.get(t2).add(t1);
		}
		DFS(0);
	}
}
