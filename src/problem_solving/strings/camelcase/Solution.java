// https://www.hackerrank.com/challenges/camelcase/problem

package problem_solving.strings.camelcase;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
	private static int camelcase(String string) {
		int count = 1;
		char[] chars = string.toCharArray();
		
		for (char ch : chars) {
			if ((int) ch < 97) {
				++count;
			}
		}
		
		return count;
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		String string = scanner.next();
		
		System.out.println(camelcase(string));
	}
}
