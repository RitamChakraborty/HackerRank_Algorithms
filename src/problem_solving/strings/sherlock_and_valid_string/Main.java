// https://www.hackerrank.com/challenges/sherlock-and-valid-string/problem

package problem_solving.strings.sherlock_and_valid_string;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	private static String isValid(String s) {
		char[] chars = s.toCharArray();
		HashMap<Character, Integer> map = new HashMap<>();
		
		for (char ch: chars) {
			map.put(ch, map.getOrDefault(ch, 0) + 1);
		}
		
		HashMap<Integer, Integer> frequencyMap = new HashMap<>();
		for (int a: map.values()) {
			frequencyMap.put(a, frequencyMap.getOrDefault(a, 0) + 1);
		}
		
		if (frequencyMap.size() > 2) {
			return "NO";
		} else {
			List<Integer> list = new ArrayList<>(map.values());
			Collections.sort(list);
			int min = list.get(0);
			int max = list.get(list.size() - 1);
			
			if (min == 1 && frequencyMap.get(1) == 1) {
				return "YES";
			} else if (min != 1) {
				if (frequencyMap.get(min) < frequencyMap.get(max)) {
					if (max - min > 1) {
						return "NO";
					}
				} else {
					if (max - min > 1) {
						return "NO";
					}
				}
			} else {
				return "NO";
			}
		}
		
		return "YES";
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		String string = scanner.next();
		System.out.println(isValid(string));
	}
}
