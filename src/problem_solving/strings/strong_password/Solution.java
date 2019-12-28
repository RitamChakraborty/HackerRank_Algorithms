// https://www.hackerrank.com/challenges/strong-password/problem

package problem_solving.strings.strong_password;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Stream;

public class Solution {
	private static int strongPassword(String password, int n) {
		char[] chars = password.toCharArray();
		Set<Character> specialCharacters = new HashSet<>(Arrays.asList(
				'!', '@', '#', '$', '%', '^', '&', '*', '(', ')', '-', '+'));
		
		boolean lengthIs6 = n >= 6;
		boolean containsDigit = false;
		boolean containsLowercase = false;
		boolean containsUppercase = false;
		boolean containsSpecialCharacter = false;
		
		for (char ch : chars) {
			if (!containsDigit && Character.isDigit(ch)) {
				containsDigit = true;
			}
			if (!containsLowercase && Character.isLowerCase(ch)) {
				containsLowercase = true;
			}
			if (!containsUppercase && Character.isUpperCase(ch)) {
				containsUppercase = true;
			}
			if (!containsSpecialCharacter) {
				if (specialCharacters.contains(ch)) {
					containsSpecialCharacter = true;
				}
			}
		}
		
		int strength = (int) Stream.of(containsDigit, containsLowercase, containsUppercase, containsSpecialCharacter)
				                     .filter(Boolean::valueOf).count();
		
		if (n < 6) {
			int newPassword = n + (4 - strength);
			
			if (newPassword >= 6) {
				return 4 - strength;
			} else {
				return (4 - strength) + (6 - newPassword);
			}
		} else {
			return 4 - strength;
		}
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int n = scanner.nextInt();
		String password = scanner.next();
		
		System.out.println(strongPassword(password, n));
	}
}
