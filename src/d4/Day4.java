package d4;

import java.io.*;
import java.util.Arrays;
import java.util.*;

public class Day4 {
    public static void main() throws IOException {
        File dir = new File(".");
        File fin = new File(dir.getCanonicalPath() + File.separator + "src" + File.separator + "d4" + File.separator + "input.txt");
        readFile(fin);
    }

    private static void readFile(File fin) throws IOException {
        FileInputStream fis = new FileInputStream(fin);
        BufferedReader br = new BufferedReader(new InputStreamReader(fis));
        String line;
        int count = 0;
        while ((line = br.readLine()) != null) {
            String splits[] = line.trim().split("\\W");
            StringBuilder sb = new StringBuilder(line.length()-5-splits.length-1);
            for(int i = 0; i < splits.length - 2; i++)
                sb.append(splits[i]);
            String input = sb.toString();
            System.out.println(input);
            for (int j = 0; j < input.length(); j++) {
                char c = input.charAt(j);

            }
        }
    }
}
