// https://www.hackerrank.com/challenges/java-comparator/problem

package problems.java_comparator;

import problems.input_reader.InputReader;

import java.util.Arrays;
import java.util.Comparator;

public class Main {
	
	static class Checker implements Comparator {
		@Override
		public int compare(Object o1, Object o2) {
			if (((Player) o1).score > ((Player) o2).score) {
				return -1;
			} else if (((Player) o1).score < ((Player) o2).score) {
				return 1;
			} else {
				return ((Player) o1).name.compareTo(((Player) o2).name);
			}
		}
		
		@Override
		public boolean equals(Object o) {
			return false;
		}
		
	}
	
	private static class Player {
		String name;
		int score;
		
		Player(String name, int score) {
			this.name = name;
			this.score = score;
		}
		
		@Override
		public String toString() {
			return name + " " + Integer.toString(score);
		}
	}
	
	public static void main(String[] args) {
		String path = "/media/ritam/Storage/Projects/IdeaProjects/Playground/Hacker Rank/src/problems.java_comparator/testcase.txt";
		String[] inputs = InputReader.read(path).split("\n");
		
		int n = Integer.parseInt(inputs[0]);
		Player[] players = new Player[n];
		Checker checker = new Checker();
		
		for (int i = 0; i < n; i++) {
			String name = inputs[i + 1].split(" ")[0];
			int score = Integer.parseInt(inputs[i + 1].split(" ")[1]);
			players[i] = new Player(name, score);
		}
		
		System.out.println(Arrays.toString(players));
		Arrays.sort(players, checker);
		System.out.println(Arrays.toString(players));
	}
}
