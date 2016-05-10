import java.util.HashMap;

public class TelephoneNumber {
	private static final int PHONE_NUMBER_LENGTH = 7;
	private final int[] phoneNum;
	private char[] result = new char[PHONE_NUMBER_LENGTH];
	private HashMap<Integer, String> button = new HashMap<Integer, String>();
	
	public TelephoneNumber(int[] n){
		phoneNum = n;
		button.put(1, null);
		button.put(2, "ABC");
		button.put(3, "DEF");
		button.put(4, "GHI");
		button.put(5, "JKL");
		button.put(6, "MNO");
		button.put(7, "PRS");
		button.put(8, "TUV");
		button.put(9, "WXY");
	}
	
	private char getCharKey(int telephoneKey, int place){
		if(telephoneKey == 1 || telephoneKey == 0 && place > 3){
			System.out.println("telephoneKey : 2-9, place : 1-3");
			return 0 ; 
		}
		return button.get(telephoneKey).charAt(place-1);
	}
	
	public void printWord(){
		printWords(0);
	}
	
	private void printWords(int curDigit){
		if(curDigit == PHONE_NUMBER_LENGTH){
			System.out.println(new String(result));
			return ;
		}
		for(int i = 1; i <= 3; i++){
			result[curDigit] = getCharKey(phoneNum[curDigit], i);
			printWords(curDigit+1);
			if(phoneNum[curDigit] == 0 || phoneNum[curDigit] == 1)
				return ;
		}
	}
	
	public static void main(String[] args){
		int[] phoneNum = {8, 6, 6, 2, 6, 6, 5};
		new TelephoneNumber(phoneNum).printWord();
	}
}
