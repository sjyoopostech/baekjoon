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

        int[][] board = new int[N+1][M+1];
        for (int i = 1; i <= N; i++) {
            String line = br.readLine();
            for (int j = 1; j <= M; j++) {
                if (line.charAt(j-1) == '1') {
                    board[i][j] = 1;
                }
                else board[i][j] = 0;
            }
        }

        int max = 0;
        int[][] dp = new int[N+1][M+1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                if(board[i][j] == 1) {
                    dp[i][j] = Math.min(dp[i][j-1], dp[i-1][j]);
                    dp[i][j] = Math.min(dp[i][j], dp[i-1][j-1]);
                    dp[i][j]++;
                    max = Math.max(dp[i][j], max);
                }
            }
        }
        bw.write(Integer.toString(max*max));


        // flush after program executed
        bw.flush();
        br.close();
        bw.close();
    }
}