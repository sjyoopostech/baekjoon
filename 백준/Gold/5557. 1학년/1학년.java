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

        int N = Integer.parseInt(br.readLine());
        int[] numArray = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) numArray[i] = Integer.parseInt(st.nextToken());

        long[] dp = new long[21];
        long[] newdp = new long[21];
        for (int i = 0; i <= 20; i++) dp[i] = 0;
        dp[numArray[0]] = 1;

        for (int i = 1; i < N-1; i++) {
            for (int j = 0; j <= 20; j++) {
                newdp[j] = 0;
                if (j - numArray[i] >= 0) newdp[j] += dp[j-numArray[i]];
                if (j + numArray[i] <= 20) newdp[j] += dp[j+numArray[i]];
            }
            for (int j = 0; j <= 20; j++) {
                dp[j] = newdp[j];
            }
        }
        bw.write(Long.toString(dp[numArray[N-1]]));

        // flush after program executed
        bw.flush();
        br.close();
        bw.close();
    }
}