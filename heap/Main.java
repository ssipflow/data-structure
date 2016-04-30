package heap;

public class Main {

	public static void main(String[] args){
		heap h = new heap();
		h.insert(10);
		h.insert(45);
		h.insert(19);
		h.insert(11);
		h.insert(96);
		
		h.display();
		
		int length = h.heapSize;
		for(int i = 0; i < length; i++){
			int key = h.delete();
			System.out.println("Delete : " + key);
		}
		
		System.out.println("After delete");
		h.display();
	}
}
