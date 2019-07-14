// https://www.hackerrank.com/challenges/minimum-distances/problem

package minimum_distances;

import input_reader.InputReader;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {

    private static int minimumDistances(int[] a) {
        int n = a.length;
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < n - 1; i++) {
            for (int j = (i + 1); j < n; j++) {
                if (a[i] == a[j]) {
                    list.add(Math.abs(i - j));
                }
            }
        }

        return list.size() == 0 ? - 1 : Collections.min(list);
    }

    public static void main(String[] args) {
        String path = "/media/ritam/Storage/Projects/IdeaProjects/Playground/Hacker Rank/src/minimum_distances/testcase.txt";
        String input = InputReader.read(path);

        int n = Integer.parseInt(input.split("\n")[0]);

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(input.split("\n")[1].split(" ")[i]);
        }

        System.out.println(minimumDistances(arr));
    }
}
