// https://www.hackerrank.com/challenges/mini-max-sum/problem

package problem_solving.strings.warmup.mini_max_sum;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	private static void miniMaxSum(long[] arr) {
		int n = arr.length;
		Arrays.sort(arr);
		
		long min = 0;
		for (int i = 0; i < n - 1; ++i) {
			min += arr[i];
		}
		
		long max = 0;
		for (int i = 1; i < n; ++i) {
			max += arr[i];
		}
		
		System.out.println(min + " " + max);
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		long[] arr = Arrays.stream(scanner.nextLine().split(" ")).mapToLong(Long::valueOf).toArray();
		miniMaxSum(arr);
	}
}
