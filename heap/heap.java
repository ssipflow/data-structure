//heap.java

package heap;

public class heap {
	public int[] arrHeap;
	public int heapSize;
	
	public heap(){
		this.arrHeap = new int[100];
		this.heapSize = 0;
	}
	
	void insert(int key){
		this.heapSize += 1;
		int index = this.heapSize;
		while(index != 1 && key > this.arrHeap[index/2]){
			this.arrHeap[index] = this.arrHeap[index/2];
			index/=2;
		}
		this.arrHeap[index] = key;
	}
	
	int delete(){
		int parent = 1;
		int child = 2;
		int data = this.arrHeap[1];
		int temp = this.arrHeap[this.heapSize];
		this.heapSize -= 1;
		while(child <= this.heapSize){
			if(child < this.heapSize && this.arrHeap[child] < this.arrHeap[child+1])
				child++;
			if(temp >= this.arrHeap[child])
				break;
			this.arrHeap[parent] = this.arrHeap[child];
			parent = child;
			child *= 2;
		}
		this.arrHeap[parent] = temp;
		return data;
	}
	
	void display(){
		for(int i = 1; i <= this.heapSize; i++)
			System.out.print(this.arrHeap[i] + " ");
		System.out.println();
	}
}