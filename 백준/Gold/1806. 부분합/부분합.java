import java.io.*;
import java.math.BigInteger;
import java.util.*;


public class Main {
    static long calc (long xb, long yb, long nb) {
        long a = xb + nb;
        long b = yb + nb;
        return b*100/a;
    }

    public static void main(String[] args) throws Exception {
        // input & output buffer class
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // String Classes
        // StringBuilder, String Tokenizer
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] array = new int[N];
        for (int i = 0; i < N; i++) array[i] = Integer.parseInt(st.nextToken());

        int min = N+1;
        int sum = 0;
        int start = 0;
        int end = 0;
        while (end <= N) {
            if (sum >= S) {
                sum -= array[start];
                if (min > end-start) min = end-start;
                start++;
            }
            else {
                if (end < N) sum += array[end];
                end++;
            }
        }
        if (min == N+1) bw.write("0");
        else bw.write(Integer.toString(min));


        // flush after program executed
        bw.flush();
        br.close();
        bw.close();
    }
}
