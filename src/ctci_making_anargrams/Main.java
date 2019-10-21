// https://www.hackerrank.com/challenges/ctci-making-anagrams/problem

package ctci_making_anargrams;

import input_reader.InputReader;

import java.util.HashMap;

public class Main {
	private static int makeAnagram(String string1, String string2) {
		int count = 0;
		HashMap<Character, Integer> map1 = new HashMap<>();
		HashMap<Character, Integer> map2 = new HashMap<>();
		
		for (char ch1: string1.toCharArray()) {
			map1.put(ch1, map1.getOrDefault(ch1, 0) + 1);
		}
		
		for (char ch2: string2.toCharArray()) {
			map2.put(ch2, map2.getOrDefault(ch2, 0) + 1);
		}

//		System.out.println(map1);
//		System.out.println(map2);
		
		for (char ch: map1.keySet()) {
			if (map2.containsKey(ch)) {
				int a = map1.get(ch);
				int b = map2.get(ch);
				int n = Math.min(a, b);
				
				map1.put(ch, (a - n));
				map2.put(ch, (b - n));
			}
		}
		
//		System.out.println(map1);
//		System.out.println(map2);
		
		for (int i: map1.values()) {
			count += i;
		} for (int j: map2.values()) {
			count += j;
		}
		
		return count;
	}
	
	public static void main(String[] args) {
		String path = "/media/ritam/Storage/Projects/IdeaProjects/Playground/Hacker Rank/src/ctci_making_anargrams/testcase.txt";
		String input = InputReader.read(path);
		
		String string1 = input.split("\n")[0];
		String string2 = input.split("\n")[1];
		
		System.out.println(makeAnagram(string1, string2));
	}
}
