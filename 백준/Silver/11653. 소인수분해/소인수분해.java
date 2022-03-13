import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        // input & output buffer class
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // input without line number
        // while ((line = br.readLine()) != null && !line.equals(""))

        // String Classes
        // StringBuilder, String Tokenizer
        StringTokenizer st;

        int num = Integer.parseInt(br.readLine());

        if (num >= 2) {
            for (int i = 2; i <= num; i++) {
                if (num % i == 0) {
                    bw.write(Integer.toString(i) + "\n");
                    num /= i;
                    i--;
                }
            }
        }

        // flush after program executed
        bw.flush();
        br.close();
        bw.close();
    }
}