// https://www.hackerrank.com/challenges/compare-the-triplets/problem

package problem_solving.warmup.compare_the_triplets;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Solution {
	
	// Complete the compareTriplets function below.
	static List<Integer> compareTriplets(List<Integer> a, List<Integer> b) {
		int alice = 0;
		int bob = 0;
		
		for (int i = 0; i < a.size(); ++i) {
			int x = a.get(i);
			int y = b.get(i);
			
			if (x > y) {
				++alice;
			} else if (x < y) {
				bob++;
			}
		}
		
		return Arrays.asList(alice, bob);
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		String[] alice = scanner.nextLine().split(" ");
		String[] bob = scanner.nextLine().split(" ");
		
		List<Integer> a = Arrays.stream(alice).mapToInt(Integer::valueOf).boxed().collect(Collectors.toList());
		List<Integer> b = Arrays.stream(bob).mapToInt(Integer::valueOf).boxed().collect(Collectors.toList());
		
		compareTriplets(a, b).forEach(x -> System.out.print(x + " "));
	}
}