// https://www.hackerrank.com/challenges/java-hashset/problem

package java_hashset;

import input_reader.InputReader;

import java.util.HashSet;

public class Main {
	public static void main(String[] args) {
		String path = "/media/ritam/Storage/Projects/IdeaProjects/Playground/Hacker Rank/src/java_hashset/testcase.txt";
		String[] input = InputReader.read(path).split("\n");
		
		int t = Integer.parseInt(input[0]);
		String[] pair_left = new String[t];
		String[] pair_right = new String[t];
		
		for (int i = 0; i < t; i++) {
			pair_left[i] = input[i + 1].split(" ")[0];
			pair_right[i] = input[i + 1].split(" ")[1];
		}
		
		// Solution
		HashSet<String> hashSet = new HashSet<>();
		for (int i = 0; i < t; i++) {
			hashSet.add(pair_left[i] + " " + pair_right[i]);
			System.out.println(hashSet.size());
		}
	}
}
