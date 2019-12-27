// https://www.hackerrank.com/challenges/ctci-merge-sort/problem
// FIXME: 8/20/19 

package problems.ctci_merge_sort;

import problems.input_reader.InputReader;

public class Main {
	private static int inversionCount;
	
	static {
		inversionCount = 0;
	}
	
	private static void merge(int[] arr, int start, int mid, int end) {
		int m = (mid - start) + 1;
		int n = (end - mid);
		int[] arr1 = new int[m];
		int[] arr2 = new int[n];
		int i, j, k = start;
		
		for (i = 0; i < m; i++) {
			arr1[i] = arr[k++];
		}
		
		for (j = 0; j < n; j++) {
			arr2[j] = arr[k++];
		}
		
		i = 0;
		j = 0;
		k = start;
		
		while (i < m && j < n) {
			if (arr1[i] <= arr2[j]) {
				arr[k++] = arr1[i++];
			} else {
				inversionCount++;
				arr[k++] = arr2[j++];
			}
		}
		
		while (i < m) {
			arr[k++] = arr1[i++];
		}
		
		while (j < n) {
			arr[k++] = arr2[j++];
		}
	}
	
	private static void mergeSort(int[] arr, int start, int end) {
		if (start < end) {
			int mid = (end + start) / 2;
			
			mergeSort(arr, start, mid);
			mergeSort(arr, mid + 1, end);
			
			merge(arr, start, mid, end);
		}
	}
	
	private static long countInversions(int[] arr) {
		inversionCount = 0;
		mergeSort(arr, 0, arr.length - 1);
		
		return inversionCount;
	}
	
	public static void main(String[] args) {
		String path = "/media/ritam/Storage/Projects/IdeaProjects/Playground/Hacker Rank/src/problems.ctci_merge_sort/testcase.txt";
		String[] inputs = InputReader.read(path).split("\n");
		
		int t = Integer.parseInt(inputs[0]);
		int j = 1;
		
		for (int i = 0; i < t; i++) {
			int n = Integer.parseInt(inputs[j++]);
			int[] arr = new int[n];
			String[] arrString = inputs[j++].split(" ");
			
			for (int k = 0; k < n; k++) {
				arr[k] = Integer.parseInt(arrString[k]);
			}
			
			System.out.println(countInversions(arr));
		}
	}
}
