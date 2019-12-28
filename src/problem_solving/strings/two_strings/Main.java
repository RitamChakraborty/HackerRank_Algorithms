// https://www.hackerrank.com/challenges/two-strings

package problem_solving.strings.two_strings;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
	
	static String twoStrings(String s1, String s2) {
		Set<Character> set1 = new HashSet<>();
		Set<Character> set2 = new HashSet<>();
		
		for (char aChar : s1.toCharArray()) {
			set1.add(aChar);
		}
		
		for (char aChar : s2.toCharArray()) {
			set2.add(aChar);
		}
		
		for (char aChar : set1) {
			if (set2.contains(aChar)) {
				return "YES";
			}
		}
		
		return "NO";
	}
	
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = scanner.nextInt();
		
		while (t-- > 0) {
			String string1 = scanner.next();
			String string2 = scanner.next();
			
			System.out.println(twoStrings(string1, string2));
		}
	}
}
