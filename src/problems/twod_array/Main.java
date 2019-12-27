// https://www.hackerrank.com/challenges/2d-array/problem

package problems.twod_array;

import problems.input_reader.InputReader;

import java.util.*;

public class Main {

    private static int singleHourglassSum(Integer[][] arr) {
        int sum = 0;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i == 1) {
                    if (j == 1) {
                        sum += arr[i][j];
                    }
                } else {
                    sum += arr[i][j];
                }
            }
        }

        return sum;
    }

    private static int hourglassSum(int[][] arr) {
        int sum = 0;
        Integer[][][][] hourglassList = new Integer[4][4][3][3];
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                for (int k = 0; k < 3; k++) {
                    for (int l = 0; l < 3; l++) {
                        hourglassList[i][j][k][l] = arr[i + k][j + l];
                    }
                }

                list.add(singleHourglassSum(hourglassList[i][j]));
            }
        }

        return Collections.max(list);
    }

    public static void main(String[] args) {
        String path = "/media/ritam/Storage/Projects/IdeaProjects/Playground/Hacker Rank/src/problems.twod_array/testcase.txt";
        String input = InputReader.read(path);

        int[][] arr = new int[6][6];
        String[] lines = input.split("\n");

        for (int i = 0; i < 6; i++) {
            String[] nums = lines[i].split(" ");
            ArrayList<String> list = new ArrayList<>();

            for (String num: nums) {
                String[] s = num.split(" ");

                for (String s1: s) {
                    if (!s1.equals(" ") && s1.length() != 0) {
                        list.add(s1);
                    }
                }
            }

            for (int j = 0; j < 6; j++) {
                arr[i][j] = Integer.parseInt(list.get(j));
            }
        }

        System.out.println(hourglassSum(arr));
    }
}
