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

        int[][] matrix = new int[N][2];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            matrix[i][0] = Integer.parseInt(st.nextToken());
            matrix[i][1] = Integer.parseInt(st.nextToken());
        }

        int[][] dp = new int[N][N];

        for (int i = 1; i < N; i++) {
            for (int j = 0; j < N-i; j++) {
                int k = j+i;

                dp[j][k] = dp[j][j] + dp[j+1][k] + matrix[j][0] * matrix[j][1] * matrix[k][1];

                for (int mid = j+1; mid < k; mid++) {
                    int calc = dp[j][mid] + dp[mid+1][k] + matrix[j][0] * matrix[mid][1] * matrix[k][1];
                    dp[j][k] = Math.min(dp[j][k], calc);
                }
            }
        }
        bw.write(Integer.toString(dp[0][N-1]));



        // flush after program executed
        bw.flush();
        br.close();
        bw.close();
    }
}