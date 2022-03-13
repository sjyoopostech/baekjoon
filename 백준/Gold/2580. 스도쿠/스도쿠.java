import java.io.*;
import java.util.*;

class Point {
    public int x;
    public int y;

    public Point (int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {
    public static boolean backtracking (int[][] board, List<Point> zeroList, int zeroNow, int zeroSize) {
        if (zeroNow == zeroSize) {
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    System.out.printf("%d ", board[i][j]);
                }
                System.out.println("");
            }
            return true;
        }

        boolean[] isPossible = new boolean[10];
        for (int i = 1; i <= 9; i++) isPossible[i] = true;

        int x = zeroList.get(zeroNow).x;
        int y = zeroList.get(zeroNow).y;

        for (int i = 0; i < 9; i++) {
            isPossible[board[x][i]] = false;
            isPossible[board[i][y]] = false;

            int a = ((x/3)*3) + (i/3);
            int b = ((y/3)*3) + (i%3);
            isPossible[board[a][b]] = false;
        }

        for (int i = 1; i <= 9; i++) {
            if (isPossible[i]) {
                board[x][y] = i;
                if (backtracking(board, zeroList, zeroNow+1, zeroSize)) {
                    return true;
                }
                board[x][y] = 0;
            }
        }
        return false;
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

        int[][] board = new int[9][9];
        List<Point> zeroList = new ArrayList<>();

        for (int i = 0; i < 9; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                if (board[i][j] == 0) zeroList.add(new Point(i,j));
            }
        }

        backtracking(board, zeroList, 0, zeroList.size());


        // flush after program executed
        bw.flush();
        br.close();
        bw.close();
    }
}