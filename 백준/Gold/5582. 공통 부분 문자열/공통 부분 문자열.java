import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {

        // input & output buffer class
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // String Classes
        // StringBuilder, String Tokenizer
        StringTokenizer st;

        String a = br.readLine();
        String b = br.readLine();

        int alen = a.length();
        int blen = b.length();

        int max = 0;
        int[][] ab = new int[alen][blen];
        for (int i = 0; i < alen; i++) {
            for (int j = 0; j < blen; j++) {
                if (a.charAt(i) == b.charAt(j)) {
                    if (i>0 && j>0) ab[i][j] = ab[i-1][j-1] + 1;
                    else ab[i][j] = 1;
                    max = Math.max(ab[i][j], max);
                }
            }
        }

        bw.write(Integer.toString(max));



        // flush after program executed
        bw.flush();
        br.close();
        bw.close();
    }
}