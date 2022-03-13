import java.io.*;
import java.util.*;

class Info {
    public int cost;
    public int visit;
    public int last;

    public Info (int cost, int visit, int last) {
        this.cost = cost;
        this.visit = visit;
        this.last = last;
    }
}

class InfoComp implements Comparator<Info> {

    @Override
    public int compare(Info o1, Info o2) {
        return o2.visit - o1.visit;
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

        int[][] cost = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                cost[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int min = 100000000;

        int[][] board = new int[1<<N][N];
        for (int i = 0; i < (1<<N); i++) {
            for (int j = 0; j < N; j++) {
                board[i][j] = 100000000;
            }
        }
        board[1][0] = 0;

        for (int visit = 1; visit < (1<<N); visit++) {
            for (int last = 0; last < N; last++) {
                if (visit != (1<<N)-1) {
                    for (int i = 0; i < N; i++) {
                        if ((visit & (1<<i)) == 0 && cost[last][i] != 0) {
                            board[visit+(1<<i)][i] = Math.min(board[visit][last] + cost[last][i], board[visit+(1<<i)][i]);
                        }
                    }
                }
                else {
                    if (cost[last][0] != 0) min = Math.min(min, board[visit][last]+ cost[last][0]);
                }
            }
        }
        bw.write(Integer.toString(min));



        // flush after program executed
        bw.flush();
        br.close();
        bw.close();
    }
}