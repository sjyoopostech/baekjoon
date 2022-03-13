import java.io.*;
import java.util.*;

public class Main {

    static void union (int[][] array, int a, int b, int w) {
        while (array[a][0] != a) {
            w -= array[a][2];
            a = array[a][0];
        }
        while (array[b][0] != b) {
            w += array[b][2];
            b = array[b][0];
        }

        if (a != b) {
            if (array[a][1] >= array[b][1]) {
                array[b][0] = a;
                array[b][2] = -w;
                array[a][1] = Math.max(array[a][1], array[b][1]+1);
            }
            else {
                array[a][0] = b;
                array[a][2] = w;
                array[b][1] = Math.max(array[b][1], array[a][1]+1);
            }
        }
    }

    static int find (int[][] array, int a) {
        while (array[a][0] != a) a = array[a][0];
        return a;
    }

    public static void main(String[] args) throws Exception {

        // input & output buffer class
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // String Classes
        // StringBuilder, String Tokenizer
        StringTokenizer st;

        while (true) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            if (N+M == 0) break;

            // 0 : parent node, 1 : tree depth, 2 : weight
            int[][] array = new int[N+1][3];
            for (int i = 0; i <= N; i++) {
                array[i][0] = i;
                array[i][1] = 0;
            }

            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                if (st.nextToken().charAt(0) == '!') {
                    int a = Integer.parseInt(st.nextToken());
                    int b = Integer.parseInt(st.nextToken());
                    int w = Integer.parseInt(st.nextToken());

                    union(array, a, b, w);
                }
                else {
                    int a = Integer.parseInt(st.nextToken());
                    int b = Integer.parseInt(st.nextToken());

                    if (find(array, a) != find(array, b)) bw.write("UNKNOWN\n");
                    else {
                        int sum = 0;
                        while (array[a][0] != a) {
                            sum += array[a][2];
                            a = array[a][0];
                        }
                        while (array[b][0] != b) {
                            sum -= array[b][2];
                            b = array[b][0];
                        }

                        bw.write(Integer.toString(sum) + "\n");
                    }
                }
            }
        }




        // flush after program executed
        bw.flush();
        br.close();
        bw.close();
    }
}