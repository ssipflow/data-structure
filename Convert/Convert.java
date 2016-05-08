
public class Convert {
	public int StringToInt(String str){
		int convertedInt = 0;
		int index = 0;
		char[] strArr = str.toCharArray();
		
		if(strArr[0] == '-')
			index = 1;
		
		while(index < strArr.length){
			convertedInt += ((int)(strArr[index]-48) * (int)Math.pow(10, strArr.length - 1 - index));
			index++;
		}
		
		if(strArr[0] == '-')
			convertedInt *= -1;
		
		return convertedInt;
	}
	
	public String IntToString(int Integer){
		String convertedString = "";
		char[] charArr;
		int data = Integer;
		int digit = 0;
		
		if(data < 0){
			convertedString += "-";
			data *= -1;
			Integer *= -1;
		}
		
		while(data != 0){
			data/=10;
			digit++;
		}
		
		charArr = new char[digit];
		for(int i = 0; i < digit; i++){
			charArr[i] = (char)((Integer / Math.pow(10, digit-i-1) + 48));
			Integer %= Math.pow(10, digit-1-i);
			convertedString += charArr[i];
		}
		
		return convertedString;
	}
	
	public static void main(String[] args){
		String str1 = "1062";
		String str2 = "-1062";
		
		System.out.println(new Convert().StringToInt(str1));
		System.out.println(new Convert().StringToInt(str2));
		
		int sum = new Convert().StringToInt(str1) + new Convert().StringToInt(str2);
		System.out.println(sum);
		
		int beforeConvert1 = 1062;
		int beforeConvert2 = -1062;
		String afterConvert1 = "";
		afterConvert1 += new Convert().IntToString(beforeConvert1);
		String afterConvert2 = "";
		afterConvert2 += new Convert().IntToString(beforeConvert2);
		System.out.println(afterConvert1);
		System.out.println(afterConvert2);
		System.out.println(afterConvert1 + afterConvert2);
	}
}
