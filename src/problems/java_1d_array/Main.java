// https://www.hackerrank.com/challenges/java-1d-array/problem

package problems.java_1d_array;

import problems.input_reader.InputReader;

public class Main {
	
	private static boolean canWin(int leap, int[] arr, int i) {
		if (i < 0 || arr[i] != 0) {
			return false;
		} else if (i + leap >= arr.length || i == arr.length - 1) {
			return true;
		} else {
			arr[i] = 1;
			return canWin(leap, arr, i + leap) || canWin(leap, arr, i + 1) || canWin(leap, arr, i - 1);
		}
	}
	
	private static boolean canWin(int leap, int[] arr) {
		return canWin(leap, arr, 0);
	}
	
	public static void main(String[] args) {
		String path = "/media/ritam/Storage/Projects/IdeaProjects/Playground/Hacker Rank/src/problems.java_1d_array/testcase.txt";
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
