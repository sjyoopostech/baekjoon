import java.io.*;
import java.util.*;

public class Main {
    static int gcd (int j, int k) {
        if (j < k) {
            int l = k;
            k = j;
            j = l;
        }
        int l;
        while ((l = j % k) != 0) {
            j = k;
            k = l;
        }
        return k;
    }

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
        st = new StringTokenizer(br.readLine());
        int[] aArray = new int[N];
        for (int i = 0; i < N; i++) {
            aArray[i] = Integer.parseInt(st.nextToken());
        }

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int[] bArray = new int[M];
        for (int i = 0; i < M; i++) {
            bArray[i] = Integer.parseInt(st.nextToken());
        }

        boolean isover = false;
        long yaksu = 1;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                int g = gcd(aArray[i], bArray[j]);
                yaksu *= g;
                aArray[i] /= g;
                bArray[j] /= g;
                if (yaksu >= 1000000000) {
                    isover = true;
                    yaksu %= 1000000000;
                }
                if (aArray[i] == 1) break;
            }
        }
        if (isover) {
            yaksu += 1000000000;
            String s = Long.toString(yaksu);
            bw.write(s.substring(1));
        }
        else bw.write(Long.toString(yaksu));



        // flush after program executed
        bw.flush();
        br.close();
        bw.close();
    }
}