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
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] array = new int[M];
        int N = 0;
        for (int i = 0; i < M; i++) {
            array[i] = Integer.parseInt(st.nextToken());
            N += array[i];
        }

        st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken());

        BigInteger sum = BigInteger.ZERO;

        for (int i = 0; i < M; i++) {
            if (array[i] < K) continue;
            sum = sum.add(factorial[array[i]].divide(factorial[array[i]-K]));
        }

        BigInteger bunmo = factorial[N].divide(factorial[N-K]);
        double a = sum.multiply(new BigInteger("100000000000")).divide(bunmo).doubleValue();
        a /= Math.pow(10,11);
        bw.write(Double.toString(a));



        // flush after program executed
        bw.flush();
        br.close();
        bw.close();
    }
}