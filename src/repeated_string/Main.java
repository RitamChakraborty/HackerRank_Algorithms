// https://www.hackerrank.com/challenges/repeated-string/problem

package repeated_string;

import input_reader.InputReader;

public class Main {

    private static int countA(String string) {
        int count = 0;
        char[] chars = string.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == 'a') {
                count++;
            }
        }

        return count;
    }

    private static long repeatedString(String s, long n) {
        int aCount = countA(s);
        int size = s.length();
        boolean dividable = n % size == 0;

        long iteration = n / size;
        long count =  aCount * iteration;

        if (!dividable) {
            long rem = n % size;
            String subString = s.substring(0, (int) rem);
            count += countA(subString);
        }

        return count;
    }

    public static void main(String[] args) {
        String path = "/media/ritam/Storage/Projects/IdeaProjects/Playground/Hacker Rank/src/repeated_string/testcase.txt";
        String input = InputReader.read(path);

        String string = input.split("\n")[0];
        long n = Long.parseLong(input.split("\n")[1]);

        System.out.println(repeatedString(string, n));
    }
}
