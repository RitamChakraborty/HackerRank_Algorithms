// https://www.hackerrank.com/challenges/birthday-cake-candles/problem

package problem_solving.strings.warmup.birthday_cake_candles;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
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
		
		System.out.println(birthdayCakeCandles(arr));
	}
	
	private static int birthdayCakeCandles(int[] arr) {
		Map<Integer, Integer> map = new HashMap<>();
		int max = Integer.MIN_VALUE;
		
		for (int i : arr) {
			max = Integer.max(max, i);
			map.put(i, map.getOrDefault(i, 0) + 1);
		}
		
		return map.get(max);
	}
}
