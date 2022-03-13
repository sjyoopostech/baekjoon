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

        String line;
        while ((line = br.readLine()) != null && !line.equals("")) {
            long number = Long.parseLong(line);

            if (number == 1) {
                bw.write("1\n");
                continue;
            }

            int cnt = 2;
            long val = 11;
            while (true) {
                if (val % number == 0) {
                    bw.write(Integer.toString(cnt) + "\n");
                    break;
                }
                cnt++;
                val = (val%number)*10 + 1;
            }
        }


        // flush after program executed
        bw.flush();
        br.close();
        bw.close();
    }
}