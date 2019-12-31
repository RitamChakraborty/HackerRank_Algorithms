// https://www.hackerrank.com/challenges/hackerrank-in-a-string/problem

package problem_solving.strings.hackerrank_in_a_string;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
	private static String hackerrankInString(String s) {
		char[] chars = s.toCharArray();
		int n = chars.length;
		char[] match = {'h', 'a', 'c', 'k', 'e', 'r', 'r', 'a', 'n', 'k'};
		int j = 0;
		
		for (char aChar : chars) {
			if (j < match.length) {
				if (aChar == match[j]) {
					++j;
				}
			}
		}
		
		
		return j == match.length ? "YES" : "NO";
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = scanner.nextInt();
		
		while (t-- > 0) {
			String string = scanner.next();
			System.out.println(
					hackerrankInString(string)
			);
		}
	}
}
