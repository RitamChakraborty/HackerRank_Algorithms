// https://www.hackerrank.com/challenges/mark-and-toys/problem

package mark_and_toys;

import input_reader.InputReader;

import java.util.Arrays;

public class Main {
	
	static int maximumToys(int[] prices, int k) {
		Arrays.sort(prices);
		int count = 0;
		int totalPrice = 0;
		
		for (int price: prices) {
			totalPrice += price;
			if (totalPrice > k) {
				break;
			}
			
			count++;
		}
		
		return count;
	}
	
	public static void main(String[] args) {
		String path = "/media/ritam/Storage/Projects/IdeaProjects/Playground/Hacker Rank/src/mark_and_toys/testcase.txt";
		String[] inputs = InputReader.read(path).split("\n");
		
		int n = Integer.parseInt(inputs[0].split(" ")[0]);
		int k = Integer.parseInt(inputs[0].split(" ")[1]);
		int[] prices = Arrays.stream(inputs[1].split(" ")).mapToInt(Integer::parseInt).toArray();
		
		System.out.println(maximumToys(prices, k));
	}
}
