import java.io.*;
import java.util.*;

class Score {
    public int geun;
    public int myeong;

    public Score (int geun, int myeong) {
        this.geun = geun;
        this.myeong = myeong;
    }
}

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
        int K = Integer.parseInt(st.nextToken());


        List<Integer> lightbulb = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        int size = 0;
        for (int i = 0; i < N; i++) {
            int input = Integer.parseInt(st.nextToken());

            if (size == 0) {
                lightbulb.add(input);
                size++;
            }
            else if (input != lightbulb.get(size-1)){
                lightbulb.add(input);
                size++;
            }
        }

        int[][] cnt = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int start = 0; start < size-i; start++) {
                int end = start+i;
                if (i == 0) cnt[start][end] = 0;
                else if (i == 1) cnt[start][end] = 1;
                else {
                    cnt[start][end] = 10000;
                    for (int mid = start; mid < end; mid++) {
                        cnt[start][end] = Math.min(cnt[start][mid] + cnt[mid+1][end], cnt[start][end]);
                    }
                    if (lightbulb.get(start) != lightbulb.get(end)) cnt[start][end]++;
                }
            }
        }
        bw.write(Integer.toString(cnt[0][size-1]));


        // flush after program executed
        bw.flush();
        br.close();
        bw.close();
    }
}