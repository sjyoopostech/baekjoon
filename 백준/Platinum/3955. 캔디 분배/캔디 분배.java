import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {

    static long eegcd (long C, long K) {
        long[] s = new long[3];
        long[] t = new long[3];
        long[] r = new long[3];
        long q;

        s[0] = 1;
        t[0] = 0;
        r[0] = C;

        s[1] = 0;
        t[1] = 1;
        r[1] = K;

        while (r[0] % r[1] != 0) {
            q = r[0]/r[1];

            s[2] = s[0] - s[1]*q;
            t[2] = t[0] - t[1]*q;
            r[2] = r[0] - r[1]*q;

            s[0] = s[1];
            t[0] = t[1];
            r[0] = r[1];

            s[1] = s[2];
            t[1] = t[2];
            r[1] = r[2];
        }

        while (s[2]*C < K+1) {
            s[2] += K;
        }
        return s[2];
    }


    static long gcd (long j, long k) {
        if (j < k) {
            long l = k;
            k = j;
            j = l;
        }
        long l;
        while ((l=j%k) != 0) {
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

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            long K = Long.parseLong(st.nextToken());
            long C = Long.parseLong(st.nextToken());

            if (gcd(C,K) != 1) bw.write("IMPOSSIBLE\n");
            else {
                long noweegcd = eegcd(C,K);
                if (noweegcd > 1000000000) bw.write("IMPOSSIBLE\n");
                else bw.write(Long.toString(noweegcd) + "\n");
            }
        }

        // flush after program executed
        bw.flush();
        br.close();
        bw.close();
    }
}