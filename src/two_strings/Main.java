// https://www.hackerrank.com/challenges/two-strings

package two_strings;

import input_reader.InputReader;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

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
		String path = "/media/ritam/Storage/Projects/IdeaProjects/Playground/Hacker Rank/src/two_strings/testcase.txt";
		String[] input = InputReader.read(path).split("\n");
		
		int t = Integer.parseInt(input[0]);
		
		IntStream.range(0, t).boxed().forEach(x -> {
			System.out.println(twoStrings(input[(x * 2) + 1], input[(x * 2) + 2]));
		});
	}
}
