package problems.sparse_arrays;

import problems.input_reader.InputReader;

import java.util.Arrays;

public class Main {

    private static int[] matchingStrings(String[] strings, String[] queries) {
        int n = strings.length;
        int d = queries.length;
        int[] arr = new int[d];

        for (int i = 0; i < d; i++) {
            int count = 0;

            for (String aString: strings) {
                if (aString.equals(queries[i])) {
                    count++;
                }
            }

            arr[i] = count;
        }


        return arr;
    }

    public static void main(String[] args) {
        String path = "/media/ritam/Storage/Projects/IdeaProjects/Playground/Hacker Rank/src/problems.sparse_arrays/testcase.txt";
        String input = InputReader.read(path);

        int n = Integer.parseInt(input.split("\n")[0]);
        String[] strings = new String[n];

        for (int i = 0; i < n; i++) {
            strings[i] = input.split("\n")[i + 1];
        }

        int d = Integer.parseInt(input.split("\n")[n + 1]);
        String[] queries = new String[d];

        for (int i = 0; i < d; i++) {
            queries[i] = input.split("\n")[n + 1 + i + 1];
        }

        System.out.println(Arrays.toString(matchingStrings(strings, queries)));
    }
}
