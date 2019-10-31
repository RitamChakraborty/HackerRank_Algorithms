// https://www.hackerrank.com/challenges/minimum-absolute-difference-in-an-array/problem

package minimum_absolute_difference_in_an_array;

import input_reader.InputReader;

import java.util.Arrays;

public class Main {
    private static int minimumAbsoluteDifference(int[] arr) {
        Arrays.sort(arr);
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < arr.length - 1; i++) {
            min = Math.min(min, Math.abs(arr[i] - arr[i + 1]));
        }

        return min;
    }
    public static void main(String[] args) {
        String path = "/media/ritam/Storage/Projects/IdeaProjects/Playground/Hacker Rank/src/minimum_absolute_difference_in_an_array/testcase.txt";
        String input = InputReader.read(path);

        int n = Integer.parseInt(input.split("\n")[0]);
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(input.split("\n")[1].split(" ")[i]);
        }

        System.out.println(minimumAbsoluteDifference(arr));
    }
}
