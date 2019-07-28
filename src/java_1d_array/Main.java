// https://www.hackerrank.com/challenges/java-1d-array/problem
// Todo: Reduce time complexity

package java_1d_array;

import input_reader.InputReader;

public class Main {
	
	private static boolean canWin(int leap, int[] arr) {
		int i = 0;
		int n = arr.length;
		
		while (true) {
			if (i + leap >= n) {
				return true;
			} else if (arr[i + leap] == 0) {
				i += leap;
			} else if (arr[i + 1] == 0) {
				i++;
			} else if ((i - 1) > 0) {
				if (arr[i - 1] == 0) {
					i--;
				}
			} else {
				break;
			}
		}
		
		return false;
	}
	
	public static void main(String[] args) {
		String path = "/media/ritam/Storage/Projects/IdeaProjects/Playground/Hacker Rank/src/java_1d_array/testcase.txt";
		String[] inputs = InputReader.read(path).split("\n");
		
		int t = Integer.parseInt(inputs[0]);
		int j = 1;
		for (int i = 0; i < t; i++) {
			int n = Integer.parseInt(inputs[j].split(" ")[0]);
			int leap = Integer.parseInt(inputs[j].split(" ")[1]);
			int[] arr = new int[n];
			j++;
			
			for (int k = 0; k < n; k++) {
				arr[k] = Integer.parseInt(inputs[j].split(" ")[k]);
			}
			j++;
			
			System.out.println(canWin(leap, arr) ? "YES" : "NO");
		}
		
	}
}
