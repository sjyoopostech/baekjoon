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

        int[][] cost = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                cost[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        String s = br.readLine();
        int init = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'Y') init += 1 << i;
        }

        int P = Integer.parseInt(br.readLine());

        int min = 100000000;
        int powerN = (int) Math.pow(2, N);
        int[] totalcost = new int[powerN];
        for (int i = 0; i < powerN; i++) {
            if (i == init) totalcost[i] = 0;
            else {
                totalcost[i] = 100000000;

                int a = -1;
                for (int j = 1; j < i; j *= 2) {
                    a++;
                    if ((i & j) != j) continue;

                    int b = -1;
                    for (int k = 1; k < i; k *= 2) {
                        b++;
                        if (j == k) continue;
                        if (((i-j) & k) == 0) continue;
                        totalcost[i] = Math.min(totalcost[i], totalcost[i-j] + cost[b][a]);
                    }
                }
            }
            //System.out.println(totalcost[i]);

            int cnt = 0;
            for (int j = 1; j <= i; j *= 2) {
                if ((i & j) != 0) cnt++;
            }
            if (cnt >= P) min = Math.min(min, totalcost[i]);
        }
        if (min >= 100000000) bw.write("-1");
        else bw.write(Integer.toString(min));

        // flush after program executed
        bw.flush();
        br.close();
        bw.close();
    }
}