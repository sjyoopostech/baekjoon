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

        int[][] triangle = new int[N+1][N];
        int[] num = new int[N];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < i; j++) {
                num[j] = Integer.parseInt(st.nextToken());
            }

            if (i == 1) {
                triangle[1][0] = num[0];
            }
            else {
                for (int j = 0; j < i; j++) {
                    if (j == 0) triangle[i][j] = num[j] + triangle[i-1][j];
                    else if (j == i-1) triangle[i][j] = num[j] + triangle[i-1][j-1];
                    else triangle[i][j] = num[j] + Math.max(triangle[i-1][j-1], triangle[i-1][j]);
                }
            }
        }

        int max = 0;
        for (int j = 0; j < N; j++) {
            max = Math.max(triangle[N][j], max);
        }
        bw.write(Integer.toString(max));


        // flush after program executed
        bw.flush();
        br.close();
        bw.close();
    }
}