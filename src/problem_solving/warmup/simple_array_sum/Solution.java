// https://www.hackerrank.com/challenges/simple-array-sum/problem

package problem_solving.warmup.simple_array_sum;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int n = scanner.nextInt();
		int[] arr = new int[n];
		
		for (int i = 0; i < n; ++i) {
			int m = scanner.nextInt();
			arr[i] = m;
		}
		
		System.out.println(simpleArraySum(arr));
	}
	
	private static int simpleArraySum(int[] arr) {
		int sum = 0;
		
		for (int i : arr) {
			sum += i;
		}
		
		return sum;
	}
}
