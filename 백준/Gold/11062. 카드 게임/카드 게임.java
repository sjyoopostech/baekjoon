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

        int T = Integer.parseInt(br.readLine());
        for (int test = 0; test < T; test++) {
            int N = Integer.parseInt(br.readLine());

            int[] card = new int[N];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) card[i] = Integer.parseInt(st.nextToken());

            Score[][] scoreboard = new Score[N][N];

            boolean GeunTurn = (N%2 != 0);

            for (int i = 0; i < N; i++) {
                for (int start = 0; start < N-i; start++) {
                    int end = i + start;

                    if (start == end) {
                        if (GeunTurn) scoreboard[start][end] = new Score(card[start], 0);
                        else scoreboard[start][end] = new Score(0, card[start]);
                        continue;
                    }

                    if (GeunTurn) {
                        int g1 = scoreboard[start][end-1].geun + card[end];
                        int m1 = scoreboard[start][end-1].myeong;
                        int g2 = scoreboard[start+1][end].geun + card[start];
                        int m2 = scoreboard[start+1][end].myeong;

                        if (g1 > g2) scoreboard[start][end] = new Score(g1, m1);
                        else scoreboard[start][end] = new Score(g2, m2);
                    }
                    else {
                        int g1 = scoreboard[start][end-1].geun;
                        int m1 = scoreboard[start][end-1].myeong + card[end];
                        int g2 = scoreboard[start+1][end].geun;
                        int m2 = scoreboard[start+1][end].myeong + card[start];

                        if (m1 > m2) scoreboard[start][end] = new Score(g1, m1);
                        else scoreboard[start][end] = new Score(g2, m2);
                    }
                }
                GeunTurn = !GeunTurn;
            }

            bw.write(Integer.toString(scoreboard[0][N-1].geun) + "\n");
        }



        // flush after program executed
        bw.flush();
        br.close();
        bw.close();
    }
}