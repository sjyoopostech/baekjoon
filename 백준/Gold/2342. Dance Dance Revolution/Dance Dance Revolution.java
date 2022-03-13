import java.io.*;
import java.util.*;

public class Main {

    static int min(int... num) {
        int min = 100000000;
        for (int a : num) {
            min = Math.min(min, a);
        }
        return min;
    }


    public static void main(String[] args) throws Exception {

        // input & output buffer class
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // String Classes
        // StringBuilder, String Tokenizer
        StringTokenizer st;

        int[] dp = new int[50];
        int[] newdp = new int[50];

        st = new StringTokenizer(br.readLine());

        boolean isfirst = true;
        int num;
        while ((num = Integer.parseInt(st.nextToken())) != 0) {

            for (int i = 0; i < 50; i++) newdp[i] = 100000000;

            // 1
            if (num == 1) {
                if (isfirst) {
                    newdp[1] = 2;
                    isfirst = false;
                }
                else {
                    newdp[1] = min(dp[1]+1, dp[2]+3, dp[3]+4, dp[4]+3);
                    newdp[12] = min(dp[2]+2, dp[12]+1, dp[23]+4, dp[24]+3);
                    newdp[13] = min(dp[3]+2, dp[13]+1, dp[23]+3, dp[34]+3);
                    newdp[14] = min(dp[4]+2, dp[14]+1, dp[24]+3, dp[34]+4);
                }
            }

            // 2
            else if (num == 2) {
                if (isfirst) {
                    newdp[2] = 2;
                    isfirst = false;
                }
                else {
                    newdp[2] = min(dp[2]+1, dp[3]+3, dp[4]+4, dp[1]+3);
                    newdp[23] = min(dp[3]+2, dp[23]+1, dp[34]+4, dp[13]+3);
                    newdp[24] = min(dp[4]+2, dp[24]+1, dp[34]+3, dp[14]+3);
                    newdp[12] = min(dp[1]+2, dp[12]+1, dp[13]+3, dp[14]+4);
                }
            }

            // 3
            else if (num == 3) {
                if (isfirst) {
                    newdp[3] = 2;
                    isfirst = false;
                }
                else {
                    newdp[3] = min(dp[3]+1, dp[4]+3, dp[1]+4, dp[2]+3);
                    newdp[34] = min(dp[4]+2, dp[34]+1, dp[14]+4, dp[24]+3);
                    newdp[13] = min(dp[1]+2, dp[13]+1, dp[14]+3, dp[12]+3);
                    newdp[23] = min(dp[2]+2, dp[23]+1, dp[24]+3, dp[12]+4);
                }
            }

            // 4
            else {
                if (isfirst) {
                    newdp[4] = 2;
                    isfirst = false;
                }
                else {
                    newdp[4] = min(dp[4]+1, dp[1]+3, dp[2]+4, dp[3]+3);
                    newdp[14] = min(dp[1]+2, dp[14]+1, dp[12]+4, dp[13]+3);
                    newdp[24] = min(dp[2]+2, dp[24]+1, dp[12]+3, dp[23]+3);
                    newdp[34] = min(dp[3]+2, dp[34]+1, dp[13]+3, dp[23]+4);
                }
            }

            for (int i = 0; i < 50; i++) {
                dp[i] = newdp[i];
            }
        }

        int min = 100000000;
        for (int i = 0; i < 50; i++) {
            min = Math.min(min, dp[i]);
        }
        bw.write(Integer.toString(min));

        // flush after program executed
        bw.flush();
        br.close();
        bw.close();
    }
}