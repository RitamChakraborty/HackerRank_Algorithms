// https://www.hackerrank.com/challenges/count-triplets-1
// Todo: Fix the solution

package count_triplets_1;

import input_reader.InputReader;

import java.util.*;
import java.util.stream.IntStream;

public class Main {
	static long countTriplets(List<Long> list, long r) {
		Collections.sort(list);
		int n = list.size();
		long count = 0;
		
		for (int i = 0; i < n - 2; i++) {
			long a = list.get(i);
			
			for (int j = (i + 1); j < n - 1; j++) {
				long b = list.get(j);
				
				if (a * r == b) {
					for (int k = (j + 1); k < n; k++) {
						long c= list.get(k);
						
						if (b * r == c) {
							count++;
						} else if (b != c) {
							break;
						}
					}
				} else if (a != b){
					break;
				}
			}
		}
		
		return count;
	}
	
	static long countTriplets(int[] arr, int r) {
		Map<Integer, List<Integer>> numberToIndices = new HashMap<>();
		for (int i = 0; i < arr.length; i++) {
			if (!numberToIndices.containsKey(arr[i])) {
				numberToIndices.put(arr[i], new ArrayList<>());
			}
			
			numberToIndices.get(arr[i]).add(i);
		}
		
		long result = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] % r != 0) {
				continue;
			}
			
			int firstNumber = arr[i] / r;
			
			if ((long) arr[i] * r > Integer.MAX_VALUE) {
				continue;
			}
			
			int lastNumber = arr[i] * r;
			
			result += (long) findBeforeCount(numberToIndices, firstNumber, i)
				* findAfterCount(numberToIndices, lastNumber, i);
		}
		return result;
	}
	
	static int findBeforeCount(Map<Integer, List<Integer>> numberToIndices, int number, int index) {
		if (!numberToIndices.containsKey(number)) {
			return 0;
		}
		
		List<Integer> indices = numberToIndices.get(number);
		int position = Collections.binarySearch(indices, index);
		if (position < 0) {
			position = -1 - position;
		}
		
		return position;
	}
	
	static int findAfterCount(Map<Integer, List<Integer>> numberToIndices, int number, int index) {
		if (!numberToIndices.containsKey(number)) {
			return 0;
		}
		
		List<Integer> indices = numberToIndices.get(number);
		int position = Collections.binarySearch(indices, index);
		if (position < 0) {
			position = -1 - position - 1;
		}
		
		return indices.size() - 1 - position;
	}
	
	public static void main(String[] args) {
		String path = "/media/ritam/Storage/Projects/IdeaProjects/Playground/Hacker Rank/src/count_triplets_1/testcase.txt";
		String input = InputReader.read(path);
		
		int n = Integer.parseInt(input.split("\n")[0].split(" ")[0]);
		int r = Integer.parseInt(input.split("\n")[0].split(" ")[1]);
		List<Long> list = new ArrayList<>();
		
		IntStream.range(0, n).boxed().forEach(i -> {
			list.add(Long.parseLong(input.split("\n")[1].split(" ")[i]));
		});
		
//		System.out.println(list);
		
		System.out.println(countTriplets(list, r));
		
//		System.out.println(countTriplets(list.stream().mapToInt(Long::intValue).toArray(), r));
		
	}
}
