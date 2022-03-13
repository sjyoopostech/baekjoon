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
        int E = Integer.parseInt(st.nextToken());

        long[] distance = new long[V+1];
        List<Edge>[] edgeList = new List[V+1];

        for (int i = 1; i <= V; i++) {
            if (i == 1) distance[i] = 0;
            else distance[i] = 100000000;

            edgeList[i] = new ArrayList<>();
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            edgeList[start].add(new Edge(start, end, weight));
        }

        for (int k = 0; k < V+5; k++) {
            for (int i = 1; i <= V; i++) {
                if (distance[i] == 100000000) continue;
                int edgeSize = edgeList[i].size();
                for (int j = 0; j < edgeSize; j++) {
                    Edge e = edgeList[i].get(j);
                    if (distance[e.dest] > distance[i] + e.weight) distance[e.dest] = distance[i] + e.weight;
                }
            }
        }

        boolean negative = false;
        for (int i = 1; i <= V; i++) {
            if (distance[i] == 100000000) continue;
            int edgeSize = edgeList[i].size();
            for (int j = 0; j < edgeSize; j++) {
                Edge e = edgeList[i].get(j);
                if (distance[e.dest] > distance[i] + e.weight) negative = true;
            }
        }

        if (negative) bw.write("-1");
        else {
            for (int i = 2; i <= V; i++) {
                if (distance[i] == 100000000) bw.write("-1\n");
                else bw.write(Long.toString(distance[i]) + "\n");
            }
        }


        // flush after program executed
        bw.flush();
        br.close();
        bw.close();
    }
}