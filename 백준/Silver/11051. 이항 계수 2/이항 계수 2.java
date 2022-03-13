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
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        BigInteger[] array = new BigInteger[N+1];
        array[0] = BigInteger.ONE;
        for (int j = 1; j < N+1; j++) {
            array[j] = array[j-1].multiply(BigInteger.valueOf(j));
        }

        BigInteger result = array[N].divide(array[K]).divide(array[N-K]);
        result = result.mod(BigInteger.valueOf(10007));

        bw.write(result.toString());


        // flush after program executed
        bw.flush();
        br.close();
        bw.close();
    }
}