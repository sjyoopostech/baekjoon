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

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] memory = new int[N];
        int[] cost = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) memory[i] = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) cost[i] = Integer.parseInt(st.nextToken());

        int[][] dp = new int[100][11000];

        for (int i = 0; i < N; i++) {
            if (i == 0) {
                dp[0][cost[0]] = memory[0];
                continue;
            }
            for (int j = 0; j < 11000; j++) {
                if (i == 0) {
                    if (j >= cost[i]) {
                        dp[i][j] = memory[i];
                    }
                    continue;
                }

                dp[i][j] = dp[i - 1][j];
                if (j >= cost[i]) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - cost[i]] + memory[i]);
                }
            }
        }


        for (int j = 0; j < 11000; j++) {
            boolean b = false;
            for (int i = 0; i < N; i++) {
                if (dp[i][j] >= M) {
                    bw.write(Integer.toString(j));
                    b = true;
                    break;
                }
            }
            if (b) break;
        }



        // flush after program executed
        bw.flush();
        br.close();
        bw.close();
    }
}