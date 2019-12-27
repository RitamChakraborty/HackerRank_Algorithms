package problems.array_left_rotation;

import problems.input_reader.InputReader;

public class Main {

    private static void printArray(int[] arr) {
        for (int aInt: arr) {
            System.out.print(aInt + " ");
        }
    }

    private static int[] rotLeft(int[] a, int d) {
        int n = a.length;

        if (d % n == 0) {
            return a;
        } else {
            int[] arr = new int[n];
            if (d > n) {
                d %= n;
            }

            for (int i = 0; i < n; i++) {
                if ((d + i) < n) {
                    arr[i] = a[d + i];
                } else {
                    arr[i] = a[d + i - n];
                }
            }

            return arr;
        }
    }


    public static void main(String[] args) {
        String path = "/media/ritam/Storage/Projects/IdeaProjects/Playground/Hacker Rank/src/problems.ctci_array_left_rotation/testcase.txt";
        String input = InputReader.read(path);

        String[] strings = input.split("\n");

        int n = Integer.parseInt(strings[0].split(" ")[0]);
        int d = Integer.parseInt(strings[0].split(" ")[1]);
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(strings[1].split(" ")[i]);
        }

        printArray(rotLeft(arr, d));
    }
}
