// https://www.hackerrank.com/challenges/mars-exploration/problem

package problem_solving.strings.mars_exploration;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
	private static int marsExploration(String message) {
		int count = 0;
		int j = 1;
		String str;
		char[] chars = message.toCharArray();
		int n = chars.length;
		
		for (int i = 0; i < n; ++i) {
			if (i == j) {
				if (chars[i] != 'O') {
					++count;
				}
				
				j += 3;
			} else {
				if (chars[i] != 'S') {
					++count;
				}
			}
		}
		
		return count;
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		String message = scanner.nextLine();
		System.out.println(marsExploration(message));
	}
}
