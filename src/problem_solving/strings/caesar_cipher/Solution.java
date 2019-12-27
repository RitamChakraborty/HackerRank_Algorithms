// I was competing against George Hotz,
// But couldn't find the problem in hackerrank
// So I just make the solution by seeing the
// question from YouTube

// https://youtu.be/Q8nhQSp__3s?list=WL&t=1367

package problem_solving.strings.caesar_cipher;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Solution {
	private static char shift(char ch, int value, int k) {
		return (char) ((((((int) ch) - value) + k) % 26) + value);
	}
	
	private static String casearCipher(String plainText, int k) {
		char[] chars = plainText.toCharArray();
		StringBuilder stringBuilder = new StringBuilder();
		
		for (char ch : chars) {
			if (Character.isLowerCase(ch)) {
				stringBuilder.append(shift(ch, 97, k));
			} else if (Character.isUpperCase(ch)) {
				stringBuilder.append(shift(ch, 65, k));
			} else {
				stringBuilder.append(ch);
			}
		}
		
		return stringBuilder.toString();
	}
	
	public static void main(String[] args) throws Exception {
		InputStream in = System.in;
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(in));
		
		char ch;
		StringBuilder stringBuilder = new StringBuilder();
		
		while (true) {
			ch = (char) bufferedReader.read();
			
			if (ch == '\n') {
				break;
			} else {
				stringBuilder.append(ch);
			}
		}
		
		int n = Integer.parseInt(stringBuilder.toString());
		
		stringBuilder = new StringBuilder();
		String plainText = bufferedReader.readLine();
		
		while (true) {
			ch = (char) bufferedReader.read();
			
			if (ch == '\n') {
				break;
			} else {
				stringBuilder.append(ch);
			}
		}
		
		int k = Integer.parseInt(stringBuilder.toString());
		
		System.out.println(casearCipher(plainText, k));
	}
}
