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
        int K = Integer.parseInt(st.nextToken());

        boolean[] che = new boolean[N+1];
        for (int i = 2; i <= N; i++) {
            che[i] = true;
        }

        boolean isfound = false;
        int cnt = 0;
        for (int i = 2; i <= N; i++) {
            if (!che[i]) continue;
            for (int j = i; j <= N; j += i) {
                if (che[j]) {
                    che[j] = false;
                    cnt++;
                    if (cnt == K) {
                        isfound = true;
                        bw.write(Integer.toString(j));
                        break;
                    }
                }
            }
            if (isfound) break;
        }

        // flush after program executed
        bw.flush();
        br.close();
        bw.close();
    }
}