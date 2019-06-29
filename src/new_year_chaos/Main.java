// https://www.hackerrank.com/challenges/new-year-chaos/problem
// Todo: Reduce time complexity

package new_year_chaos;

import input_reader.InputReader;

public class Main {

    private static void minimumBribes(int[] arr) {
        int count = 0;
        int n = arr.length - 1;

        for (int i = n; i >= 0; i--) {
            int step = 0;

            for (int j = i; j < n; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    step++;
                }
            }

            if (step > 2) {
                System.out.println("Too chaotic");
                return;
            }

            count += step;
        }

        System.out.println(count);
    }

    public static void main(String[] args) {
        String path = "/media/ritam/Storage/Projects/IdeaProjects/Playground/Hacker Rank/src/new_year_chaos/testcase.txt";
        String input = InputReader.read(path);

        int t = Integer.parseInt(input.split("\n")[0]);

        int j = 0;
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(input.split("\n")[++j]);
            int[] arr = new int[n];
            String[] nums = input.split("\n")[++j].split(" ");

            for (int k = 0; k < n; k++) {
                arr[k] = Integer.parseInt(nums[k]);
            }

            minimumBribes(arr);
        }
    }
}
