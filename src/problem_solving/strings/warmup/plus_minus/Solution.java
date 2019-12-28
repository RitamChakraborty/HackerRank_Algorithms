// https://www.hackerrank.com/challenges/plus-minus/problem

package problem_solving.strings.warmup.plus_minus;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
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
		
		plusMinus(arr);
	}
	
	private static String format(double d) {
		return new DecimalFormat("0.000000").format(d);
	}
	
	private static void plusMinus(int[] arr) {
		int pCount = 0;
		int nCount = 0;
		int zCount = 0;
		int n = arr.length;
		
		for (int i : arr) {
			if (i < 0) {
				++nCount;
			} else if (i > 0) {
				++pCount;
			} else {
				++zCount;
			}
		}
		
		System.out.println(format((double) pCount / (double) n));
		System.out.println(format((double) nCount / (double) n));
		System.out.println(format((double) zCount / (double) n));
	}
}
