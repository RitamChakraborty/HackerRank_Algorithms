// https://www.hackerrank.com/challenges/count-triplets-1
// Todo: Fix the solution

package problems.count_triplets_1;

import problems.input_reader.InputReader;

import java.util.*;
import java.util.stream.IntStream;

public class Main {
	// Solution 1
//	static long countTriplets(List<Long> list, long r) {
//		Collections.sort(list);
//		int n = list.size();
//		long count = 0;
//
//		for (int i = 0; i < n - 2; i++) {
//			long a = list.get(i);
//
//			for (int j = (i + 1); j < n - 1; j++) {
//				long b = list.get(j);
//
//				if (a * r == b) {
//					for (int k = (j + 1); k < n; k++) {
//						long c= list.get(k);
//
//						if (b * r == c) {
//							count++;
//						} else if (b != c) {
//							break;
//						}
//					}
//				} else if (a != b){
//					break;
//				}
//			}
//		}
//
//		return count;
//	}
	
	// Solution 2
//	private static long countPrevious(List<Long> list, int index, long r){
//		long n = list.get(index);
//		long count = 0;
//		for (int i = (index - 1); i >= 0; i--) {
//			if (list.get(i) == n / r) {
//				count++;
//			} else if (list.get(i) != r) {
//				break;
//			}
//		}
//
//		return count;
//	}
//
//	private static long countNext(List<Long> list, int index, long r) {
//		long n = list.get(index);
//		long count = 0;
//		for (int i = (index + 1); i < list.size(); i++) {
//			if (list.get(i) == n * r) {
//				count++;
//			} else if (list.get(i) != n) {
//				break;
//			}
//		}
//
//		return count;
//	}
//
//	private static long countTriplets(List<Long> list, long r) {
//		long count = 0;
//		Collections.sort(list);
//
//		for (int i = 1; i < (list.size() - 1); i++) {
//			count += Long.max(countPrevious(list, i, r), countNext(list, i, r));
//		}
//
//		return count;
//	}

	// Solution 3
//	private static long countTriplets(List<Long> list, long r) {
//		SortedMap<Long, Long> hashMap = new TreeMap<>();
//		List<Long> arr = new LinkedList<>();
//		long count = 0;
//
//		for (Long aLong: list) {
//			if (hashMap.containsKey(aLong)) {
//				hashMap.put(aLong, hashMap.get(aLong) + 1);
//			} else {
//				hashMap.put(aLong, 1L);
//				arr.add(aLong);
//			}
//		}
//
//		System.out.println(hashMap);
//		System.out.println(arr);
//
//		int i = 0;
//		int n = arr.size();
//		for (Long aLong: hashMap.keySet()) {
//			if (i != 0 && i != n - 1) {
//				count += Long.max(hashMap.get(arr.get(i - 1)), hashMap.get(arr.get(i + 1))) + hashMap.get(aLong) - 1;
//			}
//
//			i++;
//		}
//
//		return count;
//	}
	
	// Solution 4
	private static long countTriplets(List<Long> arr, long r) {
		long count = 0;
		HashMap<Long, Long> hashMap = new HashMap<>();
		
		arr.forEach(i -> {
			if (hashMap.containsKey(i)) {
				hashMap.put(i, hashMap.get(i) + 1);
			} else {
				hashMap.put(i, 1L);
			}
		});
		
		System.out.println(hashMap);
		
		for (long currentKey: hashMap.keySet()) {
			if (currentKey == 1 || currentKey % r == 0) {
				long previousKey = currentKey / r;
				long nextKey = currentKey * r;
				long previousCount = hashMap.containsKey(previousKey) ? hashMap.get(previousKey) : 0;
				long nextCount = hashMap.containsKey(nextKey) ? hashMap.get((nextKey)) : 0;
				if (previousCount != 0 && nextCount != 0) {
					count += previousCount * nextCount + hashMap.get(currentKey) - 1;
				}
			}
		}
		
		return count;
	}
	
	// Original Solution
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
		String path = "/media/ritam/Storage/Projects/IdeaProjects/Playground/Hacker Rank/src/problems.count_triplets_1/testcase.txt";
		String input = InputReader.read(path);
		
		int n = Integer.parseInt(input.split("\n")[0].split(" ")[0]);
		int r = Integer.parseInt(input.split("\n")[0].split(" ")[1]);
		List<Long> list = new ArrayList<>();
		
		IntStream.range(0, n).boxed().forEach(i -> {
			list.add(Long.parseLong(input.split("\n")[1].split(" ")[i]));
		});
		
//		System.out.println(list);
		
		System.out.println(countTriplets(list, r));
		
		System.out.println(countTriplets(list.stream().mapToInt(Long::intValue).toArray(), r));
		
	}
}
