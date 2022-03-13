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

        st = new StringTokenizer(br.readLine());

        BigInteger P = new BigInteger(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        BigInteger ii = BigInteger.TWO;

        boolean isbad = false;
        for (int i = 2; i < K; i++) {
            if (P.mod(ii).equals(BigInteger.ZERO)) {
                isbad = true;
                bw.write("BAD " + ii.toString());
                break;
            }
            ii = ii.add(BigInteger.ONE);
        }

        if (!isbad) bw.write("GOOD");

        // flush after program executed
        bw.flush();
        br.close();
        bw.close();
    }
}