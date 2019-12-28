// https://www.hackerrank.com/challenges/diagonal-difference/problem

package problem_solving.strings.warmup.diagonal_difference;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int n = scanner.nextInt();
		int[][] arr = new int[n][n];
		
		for (int i = 0; i < n; ++i) {
			for (int j = 0; j < n; ++j) {
				int m = scanner.nextInt();
				arr[i][j] = m;
			}
		}
		
		System.out.println(diagonalDifference(arr));
	}
	
	private static int diagonalDifference(int[][] arr) {
		int a = 0;
		int b = 0;
		
		for (int i = 0; i < arr.length; ++i) {
			a += arr[i][i];
		}
		
		int j = arr.length;
		for (int[] ints : arr) {
			b += ints[--j];
		}
		
		return Math.abs(a - b);
	}
}
