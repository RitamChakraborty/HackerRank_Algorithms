// https://www.hackerrank.com/challenges/a-very-big-sum/problem

package problem_solving.strings.warmup.a_very_big_sum;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Scanner;

public class Solution {
	private static BigInteger aVeryBigSum(BigInteger[] arr) {
		BigInteger sum = BigInteger.ZERO;
		
		for (BigInteger bigInteger : arr) {
			sum = sum.add(bigInteger);
		}
		
		return sum;
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int n  = scanner.nextInt();
		BigInteger[] arr = new BigInteger[n];
		
		for (int i = 0; i < n; ++i) {
			String num = scanner.next();
			arr[i] = new BigInteger(num);
		}
		
		System.out.println(aVeryBigSum(arr).toString());
	}
}
