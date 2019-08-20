// https://www.hackerrank.com/challenges/new-year-chaos/problem

package new_year_chaos;

import input_reader.InputReader;

public class Main {
    
    private static void minimumBribes(int[] arr) {
        int swapCount = 0;
        
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] != (i + 1)) {
                if (i > 0 && arr[i - 1] == (i + 1)) {
                    swapCount++;
                    swap(arr, i - 1, i);
                } else if (i > 1 && arr[i - 2] == (i + 1)) {
                    swapCount += 2;
                    swap(arr, i - 2, i - 1);
                    swap(arr, i - 1, i);
                } else {
                    System.out.println("Too chaotic");
                    return;
                }
            }
        }
    
        System.out.println(swapCount);
    }

    private static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
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
