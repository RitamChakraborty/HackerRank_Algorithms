// https://www.hackerrank.com/challenges/picking-numbers/problem

package problems.picking_numbers;

import problems.input_reader.InputReader;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Main {
	public static int pickingNumbers(List<Integer> list) {
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i : list) {
			map.put(i, map.getOrDefault(i, 0) + 1);
		}
		
		int max = Integer.MIN_VALUE;
		for (int i : map.keySet()) {
			if (map.keySet().contains(i + 1)) {
				int n = map.get(i) + map.get(i + 1);
				if (n > max) {
					max = n;
				}
			} else {
				if (map.get(i) > max) {
					max = map.get(i);
				}
			}
		}
		
		return max;
	}
	
	public static void main(String[] args) {
		String path = "/media/ritam/Storage/Projects/IdeaProjects/Playground/Hacker Rank/src/problems.picking_numbers/testcase.txt";
		String input = InputReader.read(path);
		String[] inputs = input.split("\n");
		
		int n = Integer.parseInt(inputs[0]);
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			list.add(Integer.parseInt(inputs[1].split(" ")[i]));
		}
		
		System.out.println(pickingNumbers(list));
	}
}
