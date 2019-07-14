// https://www.hackerrank.com/challenges/minimum-distances/problem

package minimum_distances;

import input_reader.InputReader;

import java.util.*;

public class Main {

    private static int minimumDistances(int[] arr) {
        int n = arr.length;
        Integer min = null;
        Map<Integer, Integer> map = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            if (!map.keySet().contains(arr[i])) {
                map.put(arr[i], i);
            } else {
                int dis = Math.abs(i - map.get(arr[i]));
                if (min == null) {
                    min = dis;
                } else {
                    if (dis < min) {
                        min = dis;
                    }
                }
            }
        }

        return min == null ? -1 : min;
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
