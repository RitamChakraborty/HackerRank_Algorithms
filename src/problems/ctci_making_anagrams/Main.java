// https://www.hackerrank.com/challenges/ctci-making-anagrams/problem

package problems.ctci_making_anagrams;

import problems.input_reader.InputReader;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
	
	private static int makeAnagram(String a, String b) {
		char[] ch1 = a.toCharArray();
		char[] ch2 = b.toCharArray();
		Arrays.sort(ch1);
		Arrays.sort(ch2);
		int n1 = ch1.length;
		int n2 = ch2.length;
		int[][] arr = new int[n1 + 1][n2 + 1];
		List<Character> list = new ArrayList<>();
		
		for (int i = 1; i <= n1; i++) {
			for (int j = 1; j <= n2; j++) {
				if (ch1[i - 1] == ch2[j - 1] && arr[i - 1][j] == arr[i][j - 1]) {
					arr[i][j] = 1 + arr[i -1][j];
					list.add(ch1[i - 1]);
				} else {
					arr[i][j] = Integer.max(arr[i - 1][j], arr[i][j - 1]);
				}
			}
		}
		
		System.out.println(list);
		System.out.println(arr[n1][n2]);
		
		return n1 + n2 - 2 * arr[n1][n2];
	}
	
	public static void main(String[] args) {
		String path = "/media/ritam/Storage/Projects/IdeaProjects/Playground/Hacker Rank/src/problems.ctci_making_anagrams/testcase.txt";
		String[] inputs = InputReader.read(path).split("\n");
		
		String a = inputs[0];
		String b = inputs[1];
		
		System.out.println(makeAnagram(a, b));
	}
}
