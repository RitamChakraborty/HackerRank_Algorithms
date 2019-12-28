// https://www.hackerrank.com/challenges/sherlock-and-anagrams

package problem_solving.strings.sherlock_and_anagram;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	
	private static String getSortedString(String s) {
		char[] chars = s.toCharArray();
		Arrays.sort(chars);
		return new String(chars);
	}
	
	static int sherlockAndAnagrams(String s) {
		int count = 0;
		int n = s.length();
		Set<String> set = new HashSet<>();
		
		for (int i = 1; i < n; i++) {
			List<String> list = new ArrayList<>();
			for (int j = 0; (j + i) <= n; j++) {
				list.add(getSortedString(s.substring(j, (j + i))));
			}
			
			for (int k = 0; k < list.size(); k++) {
				for (int l = (k + 1); l < list.size(); l++) {
					if (list.get(k).equals(list.get(l))) {
						count++;
					}
				}
			}
		}
		
		return count;
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = scanner.nextInt();
		
		while (t-- > 0) {
			String string = scanner.next();
			System.out.println(sherlockAndAnagrams(string));
		}
	}
}
