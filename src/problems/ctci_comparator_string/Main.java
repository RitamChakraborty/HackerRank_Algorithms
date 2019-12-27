// https://www.hackerrank.com/challenges/ctci-comparator-sorting/problem

package problems.ctci_comparator_string;

import problems.input_reader.InputReader;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Player {
	String name;
	int score;
	
	public Player(String name, int score) {
		this.name = name;
		this.score = score;
	}
}

class Checker implements Comparator<Player> {
	@Override
	public int compare(Player a, Player b) {
		if (a.score < b.score) {
			return 1;
		} else if (a.score > b.score) {
			return -1;
		} else {
			return a.name.compareTo(b.name);
		}
	}
}

class Main {
	public static void main(String[] args) {
		String path = "/media/ritam/Storage/Projects/IdeaProjects/Playground/Hacker Rank/src/problems.ctci_comparator_string/testcase.txt";
		String[] inputs = InputReader.read(path).split("\n");
		int n = Integer.parseInt(inputs[0]);
		List<Player> players = new ArrayList<>();
		
		for (int i = 0; i < n; i++) {
			players.add(
				new Player(
					inputs[i + 1].split(" ")[0],
					Integer.parseInt(inputs[i + 1].split(" ")[1])
				)
			);
		}
		
		Collections.sort(players, new Checker());
		players.forEach(player -> System.out.println(player.name + " " + player.score));
	}
}
