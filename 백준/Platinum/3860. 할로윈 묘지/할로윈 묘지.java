import java.io.*;
import java.util.*;

class Edge {
    public int xstart;
    public int xend;
    public int ystart;
    public int yend;
    public int weight;

    public Edge (int xstart, int ystart, int xend, int yend, int weight) {
        this.xstart = xstart;
        this.xend = xend;
        this.ystart = ystart;
        this.yend = yend;
        this.weight = weight;
    }
}

// Overall Time Complexity : O((W^2)(H^2))
public class Main {
    public static void main(String[] args) throws Exception {

        // input & output buffer class
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // String Classes
        // StringBuilder, String Tokenizer
        StringTokenizer st;

        while (true) {

            // O(1), get W, H
            st = new StringTokenizer(br.readLine());
            int W = Integer.parseInt(st.nextToken());
            int H = Integer.parseInt(st.nextToken());
            if (W+H == 0) break;

            // O(WH), initialize map and edgelist
            int[][] map = new int[W][H];
            List<Edge> edgeList = new ArrayList<>();

            // O(G), get graveyard info
            st = new StringTokenizer(br.readLine());
            int G = Integer.parseInt(st.nextToken());
            for (int i = 0; i < G; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                map[x][y] = 1;
            }

            // O(E), get hole info
            st = new StringTokenizer(br.readLine());
            int E = Integer.parseInt(st.nextToken());
            for (int i = 0; i < E; i++) {
                st = new StringTokenizer(br.readLine());
                int x1 = Integer.parseInt(st.nextToken());
                int y1 = Integer.parseInt(st.nextToken());
                int x2 = Integer.parseInt(st.nextToken());
                int y2 = Integer.parseInt(st.nextToken());
                int t = Integer.parseInt(st.nextToken());

                map[x1][y1] = 2;
                edgeList.add(new Edge(x1, y1, x2, y2, t));
            }

            long[][] dist = new long[W][H];

            for (int i = 0; i < W; i++) {
                for (int j = 0; j < H; j++) {
                    if (i+j == 0) dist[i][j] = 0;
                    else dist[i][j] = 100000000;

                    if (map[i][j] != 0) continue;
                    if (i == W-1 && j == H-1) continue;

                    if (i > 0) {
                        if (map[i-1][j] != 1) edgeList.add(new Edge(i,j,i-1,j,1));
                    }
                    if (j > 0) {
                        if (map[i][j-1] != 1) edgeList.add(new Edge(i,j,i,j-1,1));
                    }
                    if (i < W-1) {
                        if (map[i+1][j] != 1) edgeList.add(new Edge(i,j,i+1,j,1));
                    }
                    if (j < H-1) {
                        if (map[i][j+1] != 1) edgeList.add(new Edge(i,j,i,j+1,1));
                    }
                }
            }

            // O((W^2)(H^2)), bellman-ford algorithm
            for (int k = 0; k < W*H + 5; k++) {
                boolean change = false;
                for (Edge e : edgeList) {
                    if (dist[e.xstart][e.ystart] == 100000000) continue;
                    if (dist[e.xend][e.yend] > dist[e.xstart][e.ystart] + e.weight) {
                        dist[e.xend][e.yend] = dist[e.xstart][e.ystart] + e.weight;
                        change = true;
                    }
                }
                if (!change) break;
            }

            // O(WH), check negative loop
            boolean never = false;
            for (Edge e : edgeList) {
                if (dist[e.xstart][e.ystart] == 100000000) continue;
                if (dist[e.xend][e.yend] > dist[e.xstart][e.ystart] + e.weight) {
                    never = true;
                    break;
                }
            }

            // O(1), printing result
            if (never) bw.write("Never\n");
            else if (dist[W-1][H-1] == 100000000) bw.write("Impossible\n");
            else bw.write(Long.toString(dist[W-1][H-1]) + "\n");
        }

        // flush after program executed
        bw.flush();
        br.close();
        bw.close();
    }
}