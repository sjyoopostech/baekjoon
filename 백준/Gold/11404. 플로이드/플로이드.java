import java.io.*;
import java.util.*;

class Edge {
    public int depar;
    public int dest;
    public int weight;

    public Edge (int depar, int dest, int weight) {
        this.depar = depar;
        this.dest = dest;
        this.weight = weight;
    }
}

class Node {
    public int number;
    public int distance;

    public Node (int number, int distance) {
        this.number = number;
        this.distance = distance;
    }
}

class NodeComp implements Comparator<Node> {

    @Override
    public int compare(Node o1, Node o2) {
        return o1.distance - o2.distance;
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
        int V = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int E = Integer.parseInt(st.nextToken());

        int[][] dist = new int[V+1][V+1];
        for (int i = 1; i <= V; i++) {
            for (int j = 1; j <= V; j++) {
                if (i == j) dist[i][j] = 0;
                else dist[i][j] = 100000000;
            }
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            dist[s][d] = Math.min(dist[s][d], value);
        }

        for (int k = 1; k <= V; k++) {
            for (int i = 1; i <= V; i++) {
                for (int j = 1; j <= V; j++) {
                    dist[i][j] = Math.min(dist[i][j], dist[i][k]+dist[k][j]);
                }
            }
        }

        for (int i = 1; i <= V; i++) {
            for (int j = 1; j <= V; j++) {
                if (dist[i][j] == 100000000) bw.write("0 ");
                else bw.write(Integer.toString(dist[i][j]) + " ");
            }
            bw.write("\n");
        }




        // flush after program executed
        bw.flush();
        br.close();
        bw.close();
    }
}