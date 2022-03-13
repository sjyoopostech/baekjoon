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

        int[] stair = new int[N+1];
        for (int i = 1; i <= N; i++) stair[i] = Integer.parseInt(br.readLine());

        int[][] dp = new int[N+1][2];
        for (int i = 1; i <= N; i++) {
            if (i >= 2) dp[i][0] = Math.max(dp[i-2][0], dp[i-2][1]) + stair[i];
            else dp[i][0] = stair[i];
            dp[i][1] = dp[i-1][0] + stair[i];
        }

        bw.write(Integer.toString(Math.max(dp[N][0], dp[N][1])));



        // flush after program executed
        bw.flush();
        br.close();
        bw.close();
    }
}