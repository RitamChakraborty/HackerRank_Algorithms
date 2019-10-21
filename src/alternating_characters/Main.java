// https://www.hackerrank.com/challenges/alternating-characters/problem

package alternating_characters;

import input_reader.InputReader;

import java.util.ArrayList;
import java.util.stream.IntStream;

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
		String path = "/media/ritam/Storage/Projects/IdeaProjects/Playground/Hacker Rank/src/alternating_characters/testcase.txt";
		String input = InputReader.read(path);
		String[] inputs = input.split("\n");
		
		int n = Integer.parseInt(inputs[0]);
		IntStream.range(1, n + 1).forEach(i -> {
			System.out.println(alternatingCharacters(inputs[i]));
		});
	}
}
