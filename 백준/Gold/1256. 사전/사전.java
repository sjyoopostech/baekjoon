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

        BigInteger[] factorial = new BigInteger[3000];
        factorial[0] = BigInteger.ONE;
        for (int i = 1; i < 3000; i++) factorial[i] = factorial[i-1].multiply(BigInteger.valueOf(i));

        st = new StringTokenizer(br.readLine());
        int numA = Integer.parseInt(st.nextToken());
        int numZ = Integer.parseInt(st.nextToken());
        BigInteger K = new BigInteger(st.nextToken());

        BigInteger gazi = factorial[numA+numZ].divide(factorial[numA]).divide(factorial[numZ]);
        if (!K.min(gazi).equals(K)) bw.write("-1");
        else {
            while (numA+numZ > 0) {
                if (numA == 0) {
                    while (numZ > 0) {
                        bw.write("z");
                        numZ--;
                    }
                    break;
                }
                if (numZ == 0) {
                    while (numA > 0) {
                        bw.write("a");
                        numA--;
                    }
                    break;

                }
                gazi = factorial[numA+numZ-1].divide(factorial[numA-1]).divide(factorial[numZ]);
                if (!K.min(gazi).equals(K)) { // K > gazi
                    bw.write("z");
                    numZ--;
                    K = K.subtract(gazi);
                }
                else { // K <= gazi
                    bw.write("a");
                    numA--;
                }
            }
        }

        // flush after program executed
        bw.flush();
        br.close();
        bw.close();
    }
}