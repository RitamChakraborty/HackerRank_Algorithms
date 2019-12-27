// https://www.hackerrank.com/challenges/ctci-bubble-sort

package problems.ctci_bubble_sort;

import problems.input_reader.InputReader;

import java.util.Arrays;

public class Main {
	static void countSwaps(int[] a) {
		int count = 0;
		int n = a.length;
		
		for (int i = 0; i < n - 1; i++) {
			for (int j = (i + 1); j < n; j++) {
				if (a[j] < a[i]) {
					swap(i, j, a);
					count++;
				}
			}
		}
		
		System.out.println("Array is sorted in " + count + " swaps.");
		System.out.println("First Element: " + a[0]);
		System.out.println("Last Element: " + a[n - 1]);
	}
	
	static void swap(int i, int j, int[] arr) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	public static void main(String[] args) {
		String path = "/media/ritam/Storage/Projects/IdeaProjects/Playground/Hacker Rank/src/problems.ctci_bubble_sort/testcase.txt";
		String[] inputs = InputReader.read(path).split("\n");
		
		int n = Integer.parseInt(inputs[0]);
		int[] arr = Arrays.stream(inputs[1].split(" ")).map(Integer::parseInt).mapToInt(Integer::intValue).toArray();
		
		countSwaps(arr);
	}
}
