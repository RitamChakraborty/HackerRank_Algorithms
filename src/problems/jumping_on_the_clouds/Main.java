// https://www.hackerrank.com/challenges/jumping-on-the-clouds/problem

package problems.jumping_on_the_clouds;

import problems.input_reader.InputReader;

import java.io.IOException;

public class Main {

    private static int jumpingOnClouds(int[] arr) {
        int count = 0;
        int i = 0;
        int n = arr.length;

        while (true) {
            if (i + 2 == n) {
                count++;
                break;
            } if (i + 2 > n) {
                break;
            }

            if (arr[i + 2] == 0) {
                i += 2;
                count++;
            } else {
                i++;
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) throws IOException {
        String path = "/media/ritam/Storage/Projects/IdeaProjects/Playground/Hacker Rank/src/problems.jumping_on_the_clouds/testcase.txt";
        String input = InputReader.read(path);

        String[] strings = input.split("\n");

        int n = Integer.parseInt(strings[0]);
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(strings[1].split(" ")[i]);
        }

        System.out.println(jumpingOnClouds(arr));
    }
}
