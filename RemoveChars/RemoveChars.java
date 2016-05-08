import java.util.HashMap;
import java.util.LinkedList;

public class RemoveChars {
	public String removeChars(String str, String remove){
		LinkedList<Character> removeChars = new LinkedList<Character>();
		String resultStr = "";
		
		char character;
		for(int i = 0; i < remove.length(); i++){
			character = remove.charAt(i);
			if(!removeChars.contains(character))
				removeChars.add(character);
		}
		for(int i = 0; i < str.length(); i++){
			character = str.charAt(i);
			if(removeChars.contains(character) == false)
				resultStr += character;
		}
		return resultStr;
	}
	
	public static void main(String[] args){
		String str = "Battle of the Vowels Hawaii vs. Gronzny";
		String remove = "aeiou";
		System.out.println("Input : " + str);
		System.out.println("Output : " + new RemoveChars().removeChars(str, remove));
	}
}
