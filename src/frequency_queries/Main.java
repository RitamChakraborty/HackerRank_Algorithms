// https://www.hackerrank.com/challenges/frequency-queries/problem
// FIXME: 8/20/19 

package frequency_queries;

import input_reader.InputReader;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Main {
	
	private static List<Integer> freqQuery(List<List<Integer>> queries) {
		HashMap<Integer, Integer> map = new HashMap<>();
		HashMap<Integer, Integer> frequencyMap = new HashMap<>();
		List<Integer> result = new ArrayList<>();
		
		queries.forEach((query) -> {
			int queryType = query.get(0);
			int a = query.get(1);
			
			switch (queryType) {
				case 1:
					if (map.containsKey(a)) {
						map.put(a, map.get(a) + 1);
						
						int frequency = map.get(a);
						
						if (frequencyMap.containsKey(frequency)) {
							frequencyMap.put(frequency, frequencyMap.get(frequency) + 1);
						} else {
							frequencyMap.put(frequency, 1);
						}
						
						if (frequencyMap.containsKey(frequency - 1)) {
							if (frequencyMap.get(frequency - 1) > 0) {
								frequencyMap.put(frequency - 1, frequencyMap.get(frequency - 1) - 1);
							}
						} else {
							frequencyMap.put(frequency - 1, 0);
						}
					} else {
						map.put(a, 1);
						
						if (frequencyMap.containsKey(1)) {
							frequencyMap.put(1, frequencyMap.get(1) + 1);
						} else {
							frequencyMap.put(1, 1);
						}
					}
					
					break;
				case 2:
					if (map.containsKey(a)) {
						if (map.get(a) == 1) {
							map.put(a, 0);
							
							if (frequencyMap.containsKey(1)) {
								if (frequencyMap.get(1) == 1) {
									frequencyMap.put(1, 0);
								} else if (frequencyMap.get(1) > 0) {
									frequencyMap.put(1, frequencyMap.get(1) - 1);
								}
							}
						} else if (map.get(a) > 0) {
							map.put(a, map.get(a) - 1);
							
							int frequency = map.get(a);
							
							if (frequency > 0) {
								if (frequencyMap.containsKey(frequency)) {
									frequencyMap.put(frequency, frequencyMap.get(frequency) + 1);
								} else {
									frequencyMap.put(frequency, 1);
								}
								
								if (frequencyMap.containsKey(frequency + 1)) {
									if (frequencyMap.get(frequency + 1) > 0) {
										frequencyMap.put(frequency + 1, frequencyMap.get(frequency + 1) - 1);
									}
								}
							}
						}
					}
					
					break;
				case 3:
					if (frequencyMap.containsKey(a)) {
						if (frequencyMap.get(a) > 0) {
							result.add(1);
						} else {
							result.add(0);
						}
					} else {
						result.add(0);
					}
					
					break;
			}
		});
		
		return result;
	}
	
	public static void main(String[] args) {
		String path = "/media/ritam/Storage/Projects/IdeaProjects/Playground/Hacker Rank/src/frequency_queries/testcase.txt";
		String[] inputs = InputReader.read(path).split("\n");
		
		int n = Integer.parseInt(inputs[0]);
		List<List<Integer>> queries = new ArrayList<>();
		
		for (int i = 0; i < n; i++) {
			List<Integer> query = new ArrayList<>();
			int queryType = Integer.parseInt(inputs[i + 1].split(" ")[0]);
			int a = Integer.parseInt(inputs[i + 1].split(" ")[1]);
			query.add(queryType);
			query.add(a);
			queries.add(query);
		}
		
		freqQuery(queries).forEach(System.out::println);
	}
}
