import java.util.Stack;

public class ReverseString {
	public String reverseString(String str){
		String[] StringArr = str.split(" ");
		Stack<String> stack = new Stack<String>();
		String reversedStr = "";
		
		for(int i = 0; i < StringArr.length; i++){
			stack.push(StringArr[i]);
		}
		while(!stack.isEmpty()){
			reversedStr += stack.pop();
			reversedStr += " ";
		}
		
		return reversedStr;
	}
	
	public static void main(String[] args){
		String str = "Do or do not, there is no try.";
		System.out.println(new ReverseString().reverseString(str));
	}
}
