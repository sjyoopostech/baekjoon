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

        int ax1 = 0;
        int bx1 = 0;
        int cx1 = 0;
        int ay1 = 0;
        int by1 = 0;
        int cy1 = 0;

        int ax2, bx2, cx2;
        int ay2, by2, cy2;
        int av, bv, cv;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            av = Integer.parseInt(st.nextToken());
            bv = Integer.parseInt(st.nextToken());
            cv = Integer.parseInt(st.nextToken());

            ax2 = av + Math.max(ax1, bx1);
            bx2 = bv + Math.max(ax1, Math.max(bx1, cx1));
            cx2 = cv + Math.max(bx1, cx1);

            ay2 = av + Math.min(ay1, by1);
            by2 = bv + Math.min(ay1, Math.min(by1, cy1));
            cy2 = cv + Math.min(by1, cy1);

            ax1 = ax2;
            bx1 = bx2;
            cx1 = cx2;
            ay1 = ay2;
            by1 = by2;
            cy1 = cy2;
        }
        bw.write(Math.max(ax1, Math.max(bx1, cx1)) + " " + Math.min(ay1, Math.min(by1, cy1)));


        // flush after program executed
        bw.flush();
        br.close();
        bw.close();
    }
}
