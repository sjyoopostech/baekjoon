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
        long X = Long.parseLong(st.nextToken());
        long Y = Long.parseLong(st.nextToken());



        // X : game, Y : win
        if (Y*100/X >= 99) bw.write("-1");
        else {
            long n = 1;
            while (calc(X,Y,n) == calc(X,Y,0)) {
                n *= 2;
            }

            long m = n/2;
            while (m < n) {
                long mid = (m+n)/2;
                if (calc(X,Y,mid) == calc(X,Y,0)) m = mid + 1;
                else n = mid;
            }
            bw.write(Long.toString(m));
        }



        // flush after program executed
        bw.flush();
        br.close();
        bw.close();
    }
}
