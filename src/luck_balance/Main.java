// https://www.hackerrank.com/challenges/luck-balance/problem

package luck_balance;

import input_reader.InputReader;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    private static int luckBalance(int k, int[][] arr) {
        int luck = 0;
        int n = arr.length;
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (arr[i][1] == 0) {
                luck += arr[i][0];
            } else {
                list.add(arr[i][0]);
            }
        }

        Collections.sort(list, Collections.reverseOrder());
        for (int i = 0; i < list.size() && i < k; i++) {
            luck += list.get(i);
        }

        for (int i = k; i < list.size(); i++) {
            luck -= list.get(i);
        }

        return luck;
    }

    public static void main(String[] args) {
        String path = "/media/ritam/Storage/Projects/IdeaProjects/Playground/Hacker Rank/src/luck_balance/testcase.txt";
        String input = InputReader.read(path);

        String[] inputs = input.split("\n");
        int n = Integer.parseInt(inputs[0].split(" ")[0]);
        int k = Integer.parseInt(inputs[0].split(" ")[1]);

        int[][] arr = new int[n][2];

        for (int i = 0; i < n; i++) {
            String string = inputs[i + 1];
            arr[i][0] = Integer.parseInt(string.split(" ")[0]);
            arr[i][1] = Integer.parseInt(string.split(" ")[1]);
        }

        System.out.println(luckBalance(k, arr));
    }
}
