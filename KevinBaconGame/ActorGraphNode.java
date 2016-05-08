import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

//BFS
public class ActorGraphNode {
	private String name;
	private Set<ActorGraphNode> linkedActors;
	private int baconNumber = -1;
	
	public ActorGraphNode(String name){
		this.name = name;
		linkedActors = new HashSet<ActorGraphNode>();
	}
	
	public void linkedCostar(ActorGraphNode costar){
		linkedActors.add(costar);
		costar.linkedActors.add(this);
	}
	
	public int getBaconNumber(){
		return baconNumber;
	}
	
	//케빈 베이컨 노드에 대해서만 호출함
	public void getBaconNumbers(){
		baconNumber = 0;
		Queue<ActorGraphNode> queue = new LinkedList<ActorGraphNode>();
		queue.add(this);
		ActorGraphNode current;
		while((current = queue.poll()) != null){
			for(ActorGraphNode n : current.linkedActors){
				if(n.baconNumber == -1){
					n.baconNumber = current.baconNumber+1;
					queue.add(n);
				}
			}
		}
	}
}
