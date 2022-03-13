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

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] array = new int[N];
        for (int i = 0; i < N; i++) array[i] = Integer.parseInt(st.nextToken());

        int cnt = 0;
        int sum = 0;
        int start = 0;
        int end = 0;
        while (end <= N) {
            if (sum > M) {
                sum -= array[start];
                start++;
            }
            else if (sum < M) {
                if (end < N) sum += array[end];
                end++;
            }
            else {
                if (end < N) sum += array[end];
                end++;
                cnt++;
            }
        }
        bw.write(Integer.toString(cnt));

        // flush after program executed
        bw.flush();
        br.close();
        bw.close();
    }
}
