import java.io.*;
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

        int N = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());

        int[] down = new int[N/2];
        int[] up = new int[N/2];

        for (int i = 0; i < N; i += 2) {
            down[i/2] = Integer.parseInt(br.readLine());
            up[i/2] = H - Integer.parseInt(br.readLine());
        }

        Arrays.sort(down);
        Arrays.sort(up);

        int didx = 0;
        int uidx = 0;

        int min = N+1;
        int cnt = 0;

        for (int i = 1; i <= H; i++) {
            while (didx < N/2) {
                if (down[didx] < i) didx++;
                else break;
            }
            while (uidx < N/2) {
                if (up[uidx] < i) uidx++;
                else break;
            }
            int sum = uidx + (N/2 - didx);
            if (min > sum) {
                min = sum;
                cnt = 1;
            }
            else if (min == sum) {
                cnt++;
            }
        }

        bw.write(Integer.toString(min) + " " + Integer.toString(cnt));


        // flush after program executed
        bw.flush();
        br.close();
        bw.close();
    }
}
