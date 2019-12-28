// https://www.hackerrank.com/challenges/time-conversion/problem

package problem_solving.strings.warmup.time_conversion;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringJoiner;

public class Solution {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		String input = scanner.nextLine();
		
		System.out.println(timeConversion(input));
	}
	
	private static String timeConversion(String input) {
		CharSequence separator = ":";
		StringJoiner stringJoiner = new StringJoiner(separator);
		String[] strings = input.split(":");
		String secondPlusMedian = strings[2];
		String hourString = strings[0];
		int hour = Integer.parseInt(hourString);
		String minute = strings[1];
		String second = secondPlusMedian.substring(0, 2);
		String median = secondPlusMedian.substring(2, 4);
		
		if (hourString.equals("12") && median.equals("AM")) {
			hour = 0;
		} else if (!hourString.equals("12") && median.equals("PM")) {
			hour += 12;
			hour %= 24;
		}
		
		hourString = String.format("%02d", hour);
		
		return stringJoiner.add(hourString).add(minute).add(second).toString();
	}
}
