import java.io.*;
import java.util.*;

public class Main {
    static int gcd (int j, int k) {
        if (j < k) {
            int l = k;
            k = j;
            j = l;
        }
        int l;
        while ((l = j % k) != 0) {
            j = k;
            k = l;
        }
        return k;
    }


    public static void main(String[] args) throws Exception {
        // input & output buffer class
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // input without line number
        // while ((line = br.readLine()) != null && !line.equals(""))

        // String Classes
        // StringBuilder, String Tokenizer
        StringTokenizer st;

        boolean[] sosu = new boolean[1000];
        for (int i = 2; i < 1000; i++) sosu[i] = true;
        for (int i = 2; i < 1000; i++) {
            if (sosu[i]) {
                for (int j = i*2; j < 1000; j += i) {
                    sosu[j] = false;
                }
            }
        }

        List<Integer> sosuList = new ArrayList<>();
        for (int i = 2; i < 1000; i++) {
            if (sosu[i]) sosuList.add(i);
        }
        int S = sosuList.size();

        int N = Integer.parseInt(br.readLine());
        int[][] sosutable = new int[N][S];

        boolean islargesosu = true;
        int largesosu = 1;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            for (int j = 0; j < S; j++) {
                sosutable[i][j] = 0;
                while (num % sosuList.get(j) == 0) {
                    num /= sosuList.get(j);
                    sosutable[i][j]++;
                }
            }
            if (islargesosu) {
                if (num == 1) {
                    islargesosu = false;
                    largesosu = 1;
                }
                else if (largesosu == 1) {
                    largesosu = num;
                }
                else if (largesosu != num) {
                    islargesosu = false;
                    largesosu = 1;
                }
            }
        }

        int yaksu = largesosu;
        int change = 0;
        for (int j = 0; j < S; j++) {
            int cnt = 0;
            for (int i = 0; i < N; i++) {
                cnt += sosutable[i][j];
            }
            cnt /= N;
            for (int i = 0; i < N; i++) {
                if (sosutable[i][j] < cnt) change += cnt - sosutable[i][j];
            }
            for (int i = 0; i < cnt; i++) yaksu *= sosuList.get(j);
        }

        bw.write(Integer.toString(yaksu) + " " + Integer.toString(change));

        // flush after program executed
        bw.flush();
        br.close();
        bw.close();
    }
}