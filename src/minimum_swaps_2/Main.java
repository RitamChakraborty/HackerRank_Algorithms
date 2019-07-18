package minimum_swaps_2;

import input_reader.InputReader;

import java.util.Arrays;
import java.util.stream.Stream;

public class Main {

    private static int swapCount;

    static {
        swapCount = 0;
    }

    static int minimumSwaps(int[] arr) {
        while (!isSorted(arr)) {
            for (int i = 0; i < arr.length; i++) {
                if ((arr[i] - 1) != i) {
                    swap(arr, i, arr[i] - 1);
                }
            }
        }

        System.out.println(Arrays.toString(arr));

        return swapCount;
    }

    static boolean isSorted(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] - 1 != i) {
                return false;
            }
        }

        return true;
    }

    static void swap(int[] arr, int a, int b) {
        swapCount++;
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public static void main(String[] args) {
        String path = "/media/ritam/Storage/Projects/IdeaProjects/Playground/Hacker Rank/src/minimum_swaps_2/testcase.txt";
        String input = InputReader.read(path);

        int n = Integer.parseInt(input.split("\n")[0]);
        String[] strNums = input.split("\n")[1].split(" ");

        int[] arr = Stream.of(strNums)
                .map(Integer::parseInt)
                .mapToInt(Integer::intValue).toArray();

        System.out.println(minimumSwaps(arr));
    }
}
