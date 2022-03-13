import java.io.*;
import java.math.BigInteger;
import java.util.*;


public class Main {
    public static void main(String[] args) throws Exception {
        // input & output buffer class
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // String Classes
        // StringBuilder, String Tokenizer
        StringTokenizer st;

        int num = Integer.parseInt(br.readLine());

        if (num == 0) bw.write("0");
        else if (num == 1) bw.write("1");
        else if (num == 2) bw.write("1");
        else {
            BigInteger a = BigInteger.valueOf(0);
            BigInteger b = BigInteger.valueOf(1);
            BigInteger c = BigInteger.valueOf(1);
            for (int i = 2; i < num; i++) {
                a = b;
                b = c;
                c = a.add(b);
            }
            bw.write(c.toString());
        }


        // flush after program executed
        bw.flush();
        br.close();
        bw.close();
    }
}
