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

        int N = Integer.parseInt(br.readLine());

        int[] a = new int[N];
        int[] b = new int[N];
        int[] c = new int[N];
        int[] d = new int[N];
        int[] ab = new int[N*N];
        int[] cd = new int[N*N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            a[i] = Integer.parseInt(st.nextToken());
            b[i] = Integer.parseInt(st.nextToken());
            c[i] = Integer.parseInt(st.nextToken());
            d[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                ab[i*N+j] = a[i] + b[j];
                cd[i*N+j] = c[i] + d[j];
            }
        }
        Arrays.sort(ab);
        Arrays.sort(cd);

        long cnt = 0;
        int start = 0;
        int end = N*N - 1;
        while (start < N*N && end >= 0) {
            if (ab[start] + cd[end] > 0) {
                end--;
            }
            else if (ab[start] + cd[end] < 0) {
                start++;
            }
            else {
                int newstart = start+1;
                int newend = end-1;
                while (newstart < N*N && ab[newstart] == ab[start]) newstart++;
                while (newend >= 0 && cd[newend] == cd[end]) newend--;
                cnt += ((long)(newstart-start)) * ((long)(end-newend));
                start = newstart;
                end = newend;
            }
        }

        bw.write(Long.toString(cnt));






        // flush after program executed
        bw.flush();
        br.close();
        bw.close();
    }
}
