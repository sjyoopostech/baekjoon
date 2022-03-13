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

        int[][] array = new int[N+1][N+1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                array[i][j] = 0;
            }
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            array[b][a] = -1;
            array[a][b] = 1;
        }

        int totalcnt = 0;
        for (int i = 1; i <= N; i++) {
            boolean[] find = new boolean[N+1];
            int cnt = -1;

            int[] queue = new int[N+2];
            int a = 0;
            int b = 1;
            queue[0] = i;
            while (a < b) {
                //System.out.printf("%d ", queue[a]);
                cnt++;
                int now = queue[a];
                for (int j = 1; j <= N; j++) {
                    if (find[j]) continue;
                    if (array[now][j] == -1) {
                        find[j] = true;
                        queue[b] = j;
                        b++;
                    }
                }
                a++;
            }
            //System.out.println("");

            queue = new int[N+2];
            a = 0;
            b = 1;
            queue[0] = i;
            while (a < b) {
                //System.out.printf("%d ", queue[a]);
                cnt++;
                int now = queue[a];
                for (int j = 1; j <= N; j++) {
                    if (find[j]) continue;
                    if (array[now][j] == 1) {
                        find[j] = true;
                        queue[b] = j;
                        b++;
                    }
                }
                a++;
            }
            //System.out.println("");
            //System.out.println("");

            if (cnt >= N) totalcnt++;
        }
        bw.write(Integer.toString(totalcnt));

        // flush after program executed
        bw.flush();
        br.close();
        bw.close();
    }
}