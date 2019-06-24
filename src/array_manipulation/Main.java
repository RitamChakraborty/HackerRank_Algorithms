// https://www.hackerrank.com/challenges/crush/problem
// Todo: Reduce the time complexity

package array_manipulation;

import input_reader.InputReader;

import java.util.Arrays;
import java.util.Collections;

public class Main {

    private static long arrayManipulation(int n, int[][] queries) {
        Long[] arr = new Long[n];
        Arrays.fill(arr, 0L);

        for (int[] query : queries) {
            int a = query[0] - 1;
            int b = query[1] - 1;
            int k = query[2];

            for (int j = a; j <= b; j++) {
                arr[j] += k;
            }
        }

        return Collections.max(Arrays.asList(arr));
    }

    public static void main(String[] args) {
        String path = "/media/ritam/Storage/Projects/IdeaProjects/Playground/Hacker Rank/src/array_manipulation/testcase.txt";
        String input = InputReader.read(path);

        String[] strings = input.split("\n");
        int n = Integer.parseInt(strings[0].split(" ")[0]);
        int d = Integer.parseInt(strings[0].split(" ")[1]);
        int[][] queries = new int[d][3];

        for (int i = 0; i < d; i++) {
            String[] queriesRowItems = strings[i + 1].split(" ");

            for (int j = 0; j < 3; j++) {
                queries[i][j] = Integer.parseInt(queriesRowItems[j]);
            }
        }

        System.out.println(arrayManipulation(n, queries));
    }
}
