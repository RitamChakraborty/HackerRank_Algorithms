// https://www.hackerrank.com/challenges/alternating-characters/problem

package problem_solving.strings.alternating_characters;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	private static int alternatingCharacters(String s) {
		ArrayList<Character> list = new ArrayList<>();
		for (char ch: s.toCharArray()) {
			list.add(ch);
		}
		
		int i = 0;
		int count = 0;
		
		while (i < list.size() - 1) {
			while ((i < list.size() - 1) && (list.get(i) == list.get(i + 1))) {
				list.remove(i + 1);
				count++;
			}
			i++;
		}
		
		return count;
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = scanner.nextInt();
		
		while (t-- > 0) {
			String string = scanner.next();
			System.out.println(alternatingCharacters(string));
		}
	}
}
