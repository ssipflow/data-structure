
public class BinarySearch {
	//Non-Recursion
	int iterBinarySearch(int[] array, int target)throws Exception{
		int lower = 0, upper = array.length-1;
		int center, range;
		
		if(lower > upper)
			throw new Exception("Limits reversed");
		
		while(true){
			range = upper-lower;
			if(range == 0 && array[lower] != target)
				throw new Exception("There is no target");
			else if(array[lower] > array[upper])
				throw new Exception("Array is not sorted");
			
			center = (range/2)+lower;
			if(target == array[center])
				return center;
			else if(target < array[center])
				upper = center-1;
			else
				lower = center+1;
		}
	}
	/*
	//Recursion
	public int binarySearch(int[] array, int target)throws Exception{
		return binarySearch(array, target, 0, array.length-1);
	}
	
	public int binarySearch(int[] array, int target, int lower, int upper)throws Exception{
		int range = upper-lower;
		
		if(range < 0)
			throw new Exception("Limits reversed");
		else if(range == 0 && array[lower] != target)
			throw new Exception("There is no target");
		if(array[lower] > array[upper])
			throw new Exception("Array is not sorted");
		
		int center = (upper + lower)/2;
		if(target == array[center])
			return center;
		else if(target > array[center])
			return binarySearch(array, target, center+1, upper);
		else
			return binarySearch(array, target, lower, center-1);
			
	}
	*/
	
	public static void main(String[] args)throws Exception{
		int[] arr = {1, 2, 3, 4, 5, 6};
		System.out.println("index of target : " + new BinarySearch().iterBinarySearch(arr, 2));
		System.out.println("target : " + arr[new BinarySearch().iterBinarySearch(arr, 2)]);
	}
}
