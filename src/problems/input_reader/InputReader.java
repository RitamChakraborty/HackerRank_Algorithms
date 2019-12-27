package problems.input_reader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class InputReader {
    public static String read(String path) {
        int i = 0;
        BufferedReader bufferedReader;
        StringBuilder stringBuilder = new StringBuilder();

        try {
            bufferedReader = new BufferedReader(new FileReader(path));
            while ((i = bufferedReader.read()) != -1) {
                stringBuilder.append((char) i);
            }

            return stringBuilder.toString();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
