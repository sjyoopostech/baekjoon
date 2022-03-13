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
        int W = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());

        int[][] West = new int[W][H];
        int[][] South = new int[W][H];

        for (int i = 0; i < W; i++) {
            for (int j = 0; j < H; j++) {
                if (i == 0 && j == 0) {
                    West[i][j] = 1;
                    South[i][j] = 1;
                }
                else if (i == 0) {
                    West[i][j] = 0;
                    South[i][j] = 1;
                }
                else if (j == 0) {
                    West[i][j] = 1;
                    South[i][j] = 0;
                }
                else {
                    West[i][j] = (West[i-1][j] + South[i-1][j-1]) % 100000;
                    South[i][j] = (South[i][j-1] + West[i-1][j-1]) % 100000;
                }
            }
        }

        bw.write(Integer.toString((West[W-1][H-1] + South[W-1][H-1])%100000));

        // flush after program executed
        bw.flush();
        br.close();
        bw.close();
    }
}