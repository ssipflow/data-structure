import java.util.HashMap;

public class FirstNonRepeat {
	char FirstNonRepeat(String input){		
		HashMap<Character, Integer> hash = new HashMap<Character, Integer>();
				
		int size = input.length();
		char character;
		for(int i = 0; i < size; i++){
			character = input.charAt(i);
			if(hash.containsKey(character))
				hash.put(character, hash.get(character)+1);
			else
				hash.put(character, 1);
		}
		for(int i = 0; i < size; i++){
			character = input.charAt(i);
			if(hash.get(character)==1)
				return character;
		}
		return 0;
	}
	
	public static void main(String[] args){
		String input1 = "total";
		String input2 = "teeter";
		
		System.out.println(input1 + "'s first non repeated character : " + new FirstNonRepeat().FirstNonRepeat(input1));
		System.out.println(input2 + "'s first non repeated character : " + new FirstNonRepeat().FirstNonRepeat(input2));
	}
}
