// https://www.hackerrank.com/challenges/java-stack/problem
// Todo: Fix the bug
package java_stack;

import input_reader.InputReader;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Predicate;

public class Main {
	
	private static char getOppositeBracket(char ch) {
		switch (ch) {
			case '(':
				return ')';
			case  ')':
				return '(';
			case '{':
				return '}';
			case '}':
				return '{';
			case '[':
				return ']';
			case ']':
				return '[';
			default:
				return '*';
		}
	}
	
	public static void main(String[] args) throws IOException {
		String path = "/media/ritam/Storage/Projects/IdeaProjects/Playground/Hacker Rank/src/java_stack/testcase.txt";
		String[] inputs = InputReader.read(path).split("\n");
		
		Predicate<Integer> isEven = (i) -> i % 2 == 0;
		Predicate<Integer> isOdd = (i) -> i % 2 != 0;
		
		for (String input: inputs) {
			char[] chars = input.toCharArray();
			Map<Integer, Boolean> map = new HashMap<>();
			
			for (int i = 0; i < chars.length; i++) {
				map.put(i, false);
			}
			
			for (int i = 0; i < chars.length; i++) {
				if (!map.get(i)) {
					for (int j = chars.length - 1; j > i; j--) {
						if (!map.get(j)) {
							if (getOppositeBracket(chars[i]) == chars[j]) {
								map.put(i, true);
								map.put(j, true);
								break;
							}
						}
					}
				}
				System.out.println(map);
			}
			
			boolean balanced = true;
			for (boolean aBoolean: map.values()) {
				balanced = aBoolean;
				
				if (!balanced) {
					break;
				}
			}
			
			System.out.println(balanced ? "true" : "false") ;
		}
	}
}
