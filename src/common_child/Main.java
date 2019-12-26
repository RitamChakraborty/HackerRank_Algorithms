// https://www.hackerrank.com/challenges/common-child/problem
// FIXME: 11/1/19
package common_child;

import input_reader.InputReader;

import java.util.HashSet;

public class Main {
    private static int commonChild(String s1, String s2) {
        HashSet<Character> set1 = new HashSet<>();
        HashSet<Character> set2 = new HashSet<>();
        for (char ch: s1.toCharArray()) {
            set1.add(ch);
        }

        for (char ch: s2.toCharArray()) {
            set2.add(ch);
        }

        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();

        for (char ch: s1.toCharArray()) {
            if (set2.contains(ch)) {
                sb1.append(ch);
            }
        }

        for (char ch: s2.toCharArray()) {
            if (set1.contains(ch)) {
                sb2.append(ch);
            }
        }

        char[] ch1 = sb1.toString().toCharArray();
        char[] ch2 = sb2.toString().toCharArray();
        int n1 = ch1.length;
        int n2 = ch2.length;
        int size = 0;

        for (int i = 0; i < n1; i++) {
//            System.out.println("i: " + i);
            StringBuilder sb = new StringBuilder();
            int m = 0;
            for (int j = i; j < n1; j++) {
                int k = m;
                while (k < n2 && j < n1) {
                    if (ch1[j] == ch2[k]) {
                        sb.append(ch1[j++]);
                        m = ++k;
                    } else {
                        k++;
                    }
                }
            }

//            System.out.println(sb.toString());
            size = Integer.max(size, sb.length());
        }

        return size;
    }

    public static void main(String[] args) {
        String path = "/media/ritam/Storage/Projects/IdeaProjects/Playground/Hacker Rank/src/common_child/testcase.txt";
        String input = InputReader.read(path);

        String[] inputs = input.split("\n");
        String str1 = inputs[0];
        String str2 = inputs[1];

        System.out.println(commonChild(str1, str2));
    }
}
