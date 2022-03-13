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
    static int min(int a1, int a2, int a3, int a4, int a5, int a6) {
        return Math.min(Math.min(Math.min(a1, a2), a3), Math.min(Math.min(a4, a5), a6));
    }

    public static void main(String[] args) throws Exception {

        // input & output buffer class
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // String Classes
        // StringBuilder, String Tokenizer
        StringTokenizer st;

        String a = br.readLine();
        String b = br.readLine();
        int alen = a.length();
        int blen = b.length();

        int[][] lcs = new int[alen][blen];
        Point[][] past = new Point[alen][blen];

        for (int i = 0; i < alen; i++) {
            for (int j = 0; j < blen; j++) {
                if (a.charAt(i) == b.charAt(j)) {
                    if (i>0 && j>0) {
                        lcs[i][j] = lcs[i-1][j-1] + 1;
                        past[i][j] = new Point(i-1,j-1);
                    }
                    else lcs[i][j] = 1;
                }
                else {
                    if (i>0 && j>0) {
                        if (lcs[i-1][j] > lcs[i][j-1]) {
                            lcs[i][j] = lcs[i-1][j];
                            past[i][j] = new Point(i-1,j);
                        }
                        else {
                            lcs[i][j] = lcs[i][j-1];
                            past[i][j] = new Point(i,j-1);
                        }
                    }
                    else if (i>0) {
                        lcs[i][j] = lcs[i-1][j];
                        past[i][j] = new Point(i-1,j);
                    }
                    else if (j>0) {
                        lcs[i][j] = lcs[i][j-1];
                        past[i][j] = new Point(i,j-1);
                    }
                }
            }
        }

        int common = lcs[alen-1][blen-1];
        char[] charArray = new char[common];
        int x = alen-1;
        int y = blen-1;

        while (true) {
            Point p = past[x][y];

            if (p == null) {
                if (lcs[x][y] == 1) charArray[0] = a.charAt(x);
                break;
            }


            if (common > lcs[p.x][p.y]) {
                common--;
                charArray[common] = a.charAt(x);
            }

            x = p.x;
            y = p.y;
        }

        bw.write(Integer.toString(lcs[alen-1][blen-1]) + "\n");
        for (int i = 0; i < lcs[alen-1][blen-1]; i++) {
            bw.write(Character.toString(charArray[i]));
        }

        // flush after program executed
        bw.flush();
        br.close();
        bw.close();
    }
}