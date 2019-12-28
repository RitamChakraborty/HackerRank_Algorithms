// https://www.hackerrank.com/challenges/staircase/problem

package problem_solving.warmup.staircase;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringJoiner;

public class Solution {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int n = scanner.nextInt();
		
		stairCase(n);
	}
	
	private static void stairCase(int n) {
		CharSequence separator = "\n";
		StringJoiner stringJoiner = new StringJoiner(separator);
		for (int i = 1; i <= n; ++i) {
			StringBuilder stringBuilder = new StringBuilder();
			
			for (int j = 0; j < n - i; ++j) {
				stringBuilder.append(" ");
			}
			
			for (int j = 0; j < i; ++j) {
				stringBuilder.append("#");
			}
			stringJoiner.add(stringBuilder.toString());
		}
		
		System.out.println(stringJoiner.toString());
	}
}
