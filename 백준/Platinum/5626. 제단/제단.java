import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {

        // input & output buffer class
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // String Classes
        // StringBuilder, String Tokenizer
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        int[][] dp = new int[N][N/2 + 5];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            if (num != -1) {
                if (num >= N/2 + 5) continue;
                if (i == 0) {
                    if (num == 0) dp[i][num] = 1;
                    else dp[i][num] = 0;
                    continue;
                }

                dp[i][num] = dp[i-1][num];
                if (num > 0) dp[i][num] = (dp[i][num] + dp[i-1][num-1]) % 1000000007;
                if (num < N/2+4) dp[i][num] = (dp[i][num] + dp[i-1][num+1]) % 1000000007;

            }
            else {
                if (i == 0) {
                    dp[i][0] = 1;
                    continue;
                }

                for (int j = 0; j < N/2 + 5; j++) {
                    dp[i][j] = dp[i-1][j];
                    if (j > 0) dp[i][j] = (dp[i][j] + dp[i-1][j-1]) % 1000000007;
                    if (j < N/2+4) dp[i][j] = (dp[i][j] + dp[i-1][j+1]) % 1000000007;
                }
            }
        }

        bw.write(Integer.toString(dp[N-1][0]));







        // flush after program executed
        bw.flush();
        br.close();
        bw.close();
    }
}