import java.util.HashMap;

public class FirstNonRepeat {
	char FirstNonRepeatChar(String input){		
		HashMap<Character, Integer> hash = new HashMap<Character, Integer>();
		int length = input.length();
		char character;
		
		for(int i = 0; i < length; i++){
			character = input.charAt(i);
			if(hash.containsKey(character))
				hash.put(character, hash.get(character)+1);
			else
				hash.put(character, 1);
		}
		
		for(int i = 0; i < length; i++){
			character = input.charAt(i);
			if(hash.get(character) == 1)
				return character;
		}
		return 0;
	}
	
	public static void main(String[] args){
		String input1 = "total";
		String input2 = "teeter";
		
		System.out.println(input1 + "'s first non repeated character : " + new FirstNonRepeat().FirstNonRepeatChar(input1));
		System.out.println(input2 + "'s first non repeated character : " + new FirstNonRepeat().FirstNonRepeatChar(input2));
	}
}
