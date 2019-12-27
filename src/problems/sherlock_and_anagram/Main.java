// https://www.hackerrank.com/challenges/sherlock-and-anagrams

package problems.sherlock_and_anagram;

import problems.input_reader.InputReader;

import java.util.*;
import java.util.stream.IntStream;

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
		String path = "/media/ritam/Storage/Projects/IdeaProjects/Playground/Hacker Rank/src/problems.sherlock_and_anagram/testcase.txt";
		String input = InputReader.read(path);
		
		IntStream.range(0, Integer.parseInt(input.split("\n")[0])).boxed().forEach(t -> {
			System.out.println(sherlockAndAnagrams(input.split("\n")[t + 1]));
		});
	}
}
