// https://www.hackerrank.com/challenges/crush/problem

package problems.array_manipulation;

import problems.input_reader.InputReader;

import java.util.Arrays;

public class Main {

    private static long arrayManipulation(int n, int[][] queries) {
        long[] arr = new long[n + 1];
    
        for (int[] query : queries) {
            int a = query[0] - 1;
            int b = query[1];
            int k = query[2];
        
            arr[a] += k;
            arr[b] -= k;
        }
    
        System.out.println(Arrays.toString(arr));
    
        long max = Long.MIN_VALUE;
        long sum = 0;
        for (int i = 0; i < n + 1; i++) {
            sum += arr[i];
            max = Long.max(sum, max);
        }

        return max;
    }

    public static void main(String[] args) {
        String path = "/media/ritam/Storage/Projects/IdeaProjects/Playground/Hacker Rank/src/problems.array_manipulation/testcase.txt";
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
