import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/*
 * 노래 배열에 10개의 노래가 들어있다
 * Function shuffle(int num)
 * 숫자를 넣었을 떄
 * 숫자가 노래 목록과 같거나 크면 전체를 셔플하고
 * 작으면 그 수만큼 셔플해서 셔플플된 리스트를 리턴
 * 
 * 셔플 알고리즘 : Fisher-Yates shuffle
 */
public class Shuffle {
	public int[] Songs = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
	
	public int[] shuffle(int num){
		int length = Songs.length;
		int[] shuffledArr;
		
		if(num >= length)
			num = length;
		
		shuffledArr = new int[num];
		
		Random rnd = ThreadLocalRandom.current();
		for(int i = length-1; i > 0; i--){
			int index = rnd.nextInt(i+1);
			int temp = Songs[index];
			Songs[index] = Songs[i];
			Songs[i] = temp;
		}
		
		System.arraycopy(Songs, 0, shuffledArr, 0, num);
		
		return shuffledArr;
	}
}