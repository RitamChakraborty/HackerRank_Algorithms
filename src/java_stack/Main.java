// https://www.hackerrank.com/challenges/java-stack/problem

package java_stack;

import input_reader.InputReader;

import java.util.Stack;

public class Main {
	
	private static char getOppositeBracket(char ch) {
		switch (ch) {
			case ')':
				return '(';
			case '}':
				return '{';
			case ']':
				return '[';
			default:
				return '*';
		}
	}
	
	private static boolean isBalanced(String input) {
		char[] chars = input.toCharArray();
		Stack<Character> stack = new Stack<>();
		
		for (char ch: chars) {
			if (ch != ')' && ch != '}' && ch != ']') {
				stack.push(ch);
			} else {
				if (!stack.isEmpty()) {
					if (getOppositeBracket(ch) == stack.peek()) {
						stack.pop();
					}
				} else {
					return false;
				}
			}
		}
		
		return stack.isEmpty();
	}
	
	public static void main(String[] args) {
		String path = "/media/ritam/Storage/Projects/IdeaProjects/Playground/Hacker Rank/src/java_stack/testcase.txt";
		String[] inputs = InputReader.read(path).split("\n");
		
		for (String input: inputs) {
			System.out.println(isBalanced(input) ? "true" : "false");
		}
	}
}
