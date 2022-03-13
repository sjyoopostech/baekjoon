import java.io.*;
import java.util.*;

class Score {
    public long geun;
    public long myeong;

    public Score (long geun, long myeong) {
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

        int N = Integer.parseInt(br.readLine());

        long[] card = new long[N];
        for (int i = 0; i < N; i++) card[i] = Long.parseLong(br.readLine());

        Score[][] scoreboard = new Score[N][N];

        boolean GeunTurn = (N%2 != 0);

        for (int i = 0; i < N; i++) {
            for (int start = 0; start < N; start++) {
                int end = (i + start) % N;

                if (start == end) {
                    if (GeunTurn) scoreboard[start][end] = new Score(card[start], 0);
                    else scoreboard[start][end] = new Score(0, card[start]);
                    continue;
                }

                if (GeunTurn) {
                    long g1 = scoreboard[start][(end+N-1)%N].geun + card[end];
                    long m1 = scoreboard[start][(end+N-1)%N].myeong;
                    long g2 = scoreboard[(start+1)%N][end].geun + card[start];
                    long m2 = scoreboard[(start+1)%N][end].myeong;

                    if (g1 > g2) scoreboard[start][end] = new Score(g1, m1);
                    else scoreboard[start][end] = new Score(g2, m2);
                }
                else {
                    long g1 = scoreboard[start][(end+N-1)%N].geun;
                    long m1 = scoreboard[start][(end+N-1)%N].myeong + card[end];
                    long g2 = scoreboard[(start+1)%N][end].geun;
                    long m2 = scoreboard[(start+1)%N][end].myeong + card[start];

                    if (card[end] > card[start]) scoreboard[start][end] = new Score(g1, m1);
                    else scoreboard[start][end] = new Score(g2, m2);
                }
            }
            GeunTurn = !GeunTurn;
        }

        long max = 0;
        for (int i = 0; i < N; i++) {
            max = Math.max(max, scoreboard[i][(N+i-1)%N].geun);
        }

        bw.write(Long.toString(max));


        // flush after program executed
        bw.flush();
        br.close();
        bw.close();
    }
}