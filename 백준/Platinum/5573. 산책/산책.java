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

        st = new StringTokenizer(br.readLine());
        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        boolean[][] map = new boolean[H][W];
        boolean[][] newmap = new boolean[H][W];
        int[][] change = new int[H][W];
        change[0][0] = N-1;

        for (int i = 0; i < H; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < W; j++) {
                map[i][j] = (st.nextToken().equals("1"));
            }
        }

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                if (i > 0) {
                    change[i][j] += change[i-1][j] / 2;
                    if (change[i-1][j] % 2 == 1 && !map[i-1][j]) change[i][j]++;
                }

                if (j > 0) {
                    change[i][j] += change[i][j-1] / 2;
                    if (change[i][j-1] % 2 == 1 && map[i][j-1]) change[i][j]++;
                }

                if (change[i][j] % 2 == 1) newmap[i][j] = !map[i][j];
                else newmap[i][j] = map[i][j];
            }
        }

        int i = 0;
        int j = 0;
        while (i < H && j < W) {
            if (newmap[i][j]) j++;
            else i++;
        }

        bw.write(Integer.toString(i+1) + " " + Integer.toString(j+1));

        // flush after program executed
        bw.flush();
        br.close();
        bw.close();
    }
}