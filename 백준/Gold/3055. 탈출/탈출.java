import java.io.*;
import java.util.*;


public class Main {
    public static int[][] deepCopy(int[][] array, int R, int C) {
        int[][] newArray = new int[R][C];
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                newArray[i][j] = array[i][j];
            }
        }
        return newArray;
    }


    public static void main(String[] args) throws Exception {

        // input & output buffer class
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // String Classes
        // StringBuilder, String Tokenizer
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        int[][] map = new int[R][C];

        // . : 0
        // * : 1
        // S : 2
        // D : 3
        // X : -1
        for (int i = 0; i < R; i++) {
            String line = br.readLine();
            for (int j = 0; j < C; j++) {
                if (line.charAt(j) == '.') map[i][j] = 0;
                else if (line.charAt(j) == '*') map[i][j] = 1;
                else if (line.charAt(j) == 'S') map[i][j] = 2;
                else if (line.charAt(j) == 'D') map[i][j] = 3;
                else if (line.charAt(j) == 'X') map[i][j] = -1;
            }
        }

        int time = 0;
        while (true) {
            time++;

            int[][] oldmap = deepCopy(map, R, C);;
            int[][] newmap = deepCopy(map, R, C);;
            boolean Dfound = false;
            // S time (2)
            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    if (map[i][j] != 2) continue;
                    if (i >= 1) {
                        if (map[i-1][j] == 0) newmap[i-1][j] = 2;
                        if (map[i-1][j] == 3) Dfound = true;
                    }
                    if (j >= 1) {
                        if (map[i][j-1] == 0) newmap[i][j-1] = 2;
                        if (map[i][j-1] == 3) Dfound = true;
                    }
                    if (i <= R-2) {
                        if (map[i+1][j] == 0) newmap[i+1][j] = 2;
                        if (map[i+1][j] == 3) Dfound = true;
                    }
                    if (j <= C-2) {
                        if (map[i][j+1] == 0) newmap[i][j+1] = 2;
                        if (map[i][j+1] == 3) Dfound = true;
                    }
                }
            }
            map = newmap;
            if (Dfound) {
                bw.write(Integer.toString(time));
                break;
            }

            newmap = deepCopy(map, R, C);
            // * time (1)
            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    if (map[i][j] != 1) continue;
                    if (i >= 1) {
                        if (map[i-1][j] == 0 || map[i-1][j] == 2) newmap[i-1][j] = 1;
                    }
                    if (j >= 1) {
                        if (map[i][j-1] == 0 || map[i][j-1] == 2) newmap[i][j-1] = 1;
                    }
                    if (i <= R-2) {
                        if (map[i+1][j] == 0 || map[i+1][j] == 2) newmap[i+1][j] = 1;
                    }
                    if (j <= C-2) {
                        if (map[i][j+1] == 0 || map[i][j+1] == 2) newmap[i][j+1] = 1;
                    }
                }
            }
            map = newmap;

            boolean diff = false;
            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    if (oldmap[i][j] != newmap[i][j]) diff = true;
                }
            }
            if (!diff) {
                bw.write("KAKTUS");
                break;
            }
        }

        // flush after program executed
        bw.flush();
        br.close();
        bw.close();
    }
}
