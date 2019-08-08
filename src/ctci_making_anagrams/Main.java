// https://www.hackerrank.com/challenges/ctci-making-anagrams/problem

package ctci_making_anagrams;

import input_reader.InputReader;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
	
	private static int makeAnagram(String a, String b) {
		char[] ch1 = a.length() > b.length() ? a.toCharArray() : b.toCharArray();
		char[] ch2 = a.length() <= b.length() ? a.toCharArray() : b.toCharArray();
		int n1 = ch1.length;
		int n2 = ch2.length;
		Arrays.sort(ch1);
		Arrays.sort(ch2);
		ArrayList<Character> anagramList = new ArrayList<>();
		int count = 0;
		boolean foundMatch = false;
		
		int j;
		int temp = 0;
		for (int i = 0; i < n1; i++) {
			j = temp;
			while (j < n2) {
				System.out.println("i: " + i + " j: " + j + " ch1: " + ch1[i] + " ch2: " + ch2[j]);
				if (ch1[i] == ch2[j]) {
					anagramList.add(ch1[i]);
					temp = j + 1;
					break;
				} else {
					j++;
				}
			}
		}
		
		return n1 + n2 - anagramList.size() * 2;
	}
	
	public static void main(String[] args) {
		String path = "/media/ritam/Storage/Projects/IdeaProjects/Playground/Hacker Rank/src/ctci_making_anagrams/testcase.txt";
		String[] inputs = InputReader.read(path).split("\n");
		
		String a = inputs[0];
		String b = inputs[1];
		
		System.out.println(makeAnagram(a, b));
	}
}
