// https://www.hackerrank.com/challenges/climbing-the-leaderboard/problem
// FIXME: 9/18/19 Just one test case!!!!!!!!!!!!!!!!!!

package climbing_the_leaderboard;

import input_reader.InputReader;

import java.util.Arrays;

public class Main {
	
	private static void binarySeaarch(int[] scores, int[] alice, int[] ranks, int index, int n, int start, int end) {
		if (start < end) {
			if (start == 0 && n > scores[start]) {
				alice[index] = 1;
			} else if (n == scores[start]) {
				alice[index] = ranks[start];
			} else if (n == scores[end]) {
				alice[index] = ranks[end];
			} else {
				int mid = (start + end) / 2;
				
				if (n == scores[mid]) {
					alice[index] = ranks[mid];
				} else {
					if (mid < scores.length - 1 && n < scores[mid] && n > scores[mid + 1]) {
						alice[index] = ranks[mid + 1];
					} else if (mid > 0 && n > scores[mid] && n < scores[mid - 1]) {
						alice[index] = ranks[mid];
					} else {
						if (n > scores[mid]) {
							binarySeaarch(scores, alice, ranks, index, n, start, mid);
						} else {
							binarySeaarch(scores, alice, ranks, index, n, mid + 1, end);
						}
					}
				}
			}
		}
		
	}
	
	private static int[] climbingLeaderboard(int[] scores, int[] alice) {
		int rank = 0;
		int[] ranks = new int[scores.length];
		int score = scores[0];
		
		for (int i = 0; i < scores.length; i++) {
			if (i == 0) {
				ranks[i] = ++rank;
			} else {
				if (scores[i] == score) {
					ranks[i] = rank;
				} else {
					score = scores[i];
					ranks[i] = ++rank;
				}
			}
		}
		int minScore = scores[scores.length - 1];
		
		for (int i = alice.length - 1; i >= 0; i--) {
			if (alice[i] < minScore) {
				alice[i] = ++rank;
			} else {
				binarySeaarch(scores, alice, ranks, i, alice[i], 0, scores.length - 1);
			}
		}
	
		return alice;
	}
	
	public static void main(String[] args) {
		String path = "/media/ritam/Storage/Projects/IdeaProjects/Playground/Hacker Rank/src/climbing_the_leaderboard/testcase.txt";
		String input = InputReader.read(path);
		
		String[] inputs = input.split("\n");
		int m = Integer.parseInt(inputs[0]);
		int[] scores = new int[m];
		
		for (int i = 0; i < m; i++) {
			scores[i] = Integer.parseInt(inputs[1].split(" ")[i]);
		}
		
		int n = Integer.parseInt(inputs[2]);
		int[] alice = new int[n];
		
		for (int j = 0; j < n; j++) {
			alice[j] = Integer.parseInt(inputs[3].split(" ")[j]);
		}
		
		System.out.println(Arrays.toString(climbingLeaderboard(scores, alice)));
	}
}
