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
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        List<Edge>[] edgeList = new List[N+1];
        for (int i = 1; i <= N; i++) edgeList[i] = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            edgeList[start].add(new Edge(start, end, weight));
        }

        int totalcount = 0;
        int[] count = new int[N+1];
        int[] kdist = new int[N+1];

        PriorityQueue<Node> pq = new PriorityQueue<>(new NodeComp());
        pq.add(new Node(1, 0));
        while (!pq.isEmpty()) {
            Node node = pq.poll();

            if (totalcount >= K*N) break;
            if (count[node.number] >= K) {
                continue;
            }

            kdist[node.number] = node.distance;

            count[node.number]++;
            totalcount++;

            int esize = edgeList[node.number].size();
            for (int i = 0; i < esize; i++) {
                Edge e = edgeList[node.number].get(i);
                int newd = node.distance + e.weight;
                pq.add(new Node(e.dest, newd));
            }
        }

        for (int i = 1; i <= N; i++) {
            if (count[i] < K) bw.write("-1\n");
            else bw.write(kdist[i] + "\n");
        }



        // flush after program executed
        bw.flush();
        br.close();
        bw.close();
    }
}