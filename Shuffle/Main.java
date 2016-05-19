
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Shuffle shuffle = new Shuffle();
		
		System.out.print("Original list : ");
		for(int i = 0; i < shuffle.Songs.length; i++)
			System.out.print(shuffle.Songs[i] + " ");
		System.out.println();
		
		int[] shuffledArr = shuffle.shuffle(3);
		System.out.print("After shuffle 3 : ");
		for(int i = 0; i < shuffledArr.length; i++)
			System.out.print(shuffledArr[i] + " ");
		System.out.println();
		
		System.out.print("After shuffle 11 : ");
		shuffledArr = shuffle.shuffle(11);
		for(int i = 0; i < shuffledArr.length; i++)
			System.out.print(shuffledArr[i] + " ");
		System.out.println();
		
		System.out.print("After shuffle 6 : ");
		shuffledArr = shuffle.shuffle(6);
		for(int i = 0; i < shuffledArr.length; i++)
			System.out.print(shuffledArr[i] + " ");
		System.out.println();
	}

}
