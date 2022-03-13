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

        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int W = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());


            // nPk 다리놓기

            BigInteger[] array = new BigInteger[E+1];
            array[0] = BigInteger.ONE;

            for (int j = 1; j < E+1; j++) {
                array[j] = array[j-1].multiply(BigInteger.valueOf(j));
            }

            BigInteger result = array[E].divide(array[W]).divide(array[E-W]);
            bw.write(result.toString() + "\n");
        }



        // flush after program executed
        bw.flush();
        br.close();
        bw.close();
    }
}