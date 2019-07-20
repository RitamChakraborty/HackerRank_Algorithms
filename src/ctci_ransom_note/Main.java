// https://www.hackerrank.com/challenges/ctci-ransom-note/problem

package ctci_ransom_note;

import input_reader.InputReader;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        String path = "/media/ritam/Storage/Projects/IdeaProjects/Playground/Hacker Rank/src/ctci_ransom_note/testcase.txt";
        String input = InputReader.read(path);
        String[] inputs = input.split("\n");

        checkMagazine(inputs[1].split(" "), inputs[2].split(" "));
    }

    static void checkMagazine(String[] magazine, String[] note) {
        Map<String, Integer> magazineMap = new HashMap<>();
        Map<String, Integer> noteMap = new HashMap<>();

        Arrays.asList(magazine).forEach(x -> {
            if (magazineMap.containsKey(x)) {
                magazineMap.put(x, magazineMap.get(x) + 1);
            } else {
                magazineMap.put(x, 1);
            }
        });

        Arrays.asList(note).forEach(x -> {
            if (noteMap.containsKey(x)) {
                noteMap.put(x, noteMap.get(x) + 1);
            } else {
                noteMap.put(x, 1);
            }
        });

        for (String x : noteMap.keySet()) {
            if (magazineMap.containsKey(x)) {
                if (magazineMap.get(x) < noteMap.get(x)) {
                    System.out.println("No");
                    return;
                }
            } else {
                System.out.println("No");
                return;
            }
        }

        System.out.println("Yes");
    }
}
