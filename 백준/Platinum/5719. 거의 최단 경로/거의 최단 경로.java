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

        while (true) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            if (N+M == 0) break;

            st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken());
            int D = Integer.parseInt(st.nextToken());

            int[][] edge = new int[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    edge[i][j] = -1;
                }
            }

            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());
                int weight = Integer.parseInt(st.nextToken());
                edge[start][end] = weight;
            }

            int[] dist = new int[N];
            boolean[] visit = new boolean[N];
            for (int i = 0; i < N; i++) {
                if (i == S) dist[i] = 0;
                else dist[i] = 100000000;

                visit[i] = false;
            }

            PriorityQueue<Node> pq = new PriorityQueue<>(new NodeComp());
            pq.add(new Node(S, 0));
            while (!pq.isEmpty()) {
                Node node = pq.poll();

                if (visit[node.number]) continue;
                visit[node.number] = true;

                for (int i = 0; i < N; i++) {
                    if (edge[node.number][i] == -1) continue;
                    else {
                        if (dist[i] > dist[node.number] + edge[node.number][i]) {
                            dist[i] = dist[node.number] + edge[node.number][i];
                            pq.add(new Node(i, dist[i]));
                        }
                    }
                }
            }

            if (dist[D] == 100000000) {
                bw.write("-1\n");
                continue;
            }

            visit = new boolean[N];
            Queue<Integer> queue = new ArrayDeque<>();
            queue.add(D);
            while (!queue.isEmpty()) {
                int now = queue.poll();

                if(visit[now]) continue;
                visit[now] = true;

                for (int i = 0; i < N; i++) {
                    if (edge[i][now] == -1) continue;
                    else {
                        if (dist[i] + edge[i][now] == dist[now]) {
                            edge[i][now] = -1;
                            queue.add(i);
                        }
                    }
                }
            }

            dist = new int[N];
            visit = new boolean[N];
            for (int i = 0; i < N; i++) {
                if (i == S) dist[i] = 0;
                else dist[i] = 100000000;

                visit[i] = false;
            }

            pq = new PriorityQueue<>(new NodeComp());
            pq.add(new Node(S, 0));
            while (!pq.isEmpty()) {
                Node node = pq.poll();

                if (visit[node.number]) continue;
                visit[node.number] = true;

                for (int i = 0; i < N; i++) {
                    if (edge[node.number][i] == -1) continue;
                    else {
                        if (dist[i] > dist[node.number] + edge[node.number][i]) {
                            dist[i] = dist[node.number] + edge[node.number][i];
                            pq.add(new Node(i, dist[i]));
                        }
                    }
                }
            }

            if (dist[D] == 100000000) {
                bw.write("-1\n");
                continue;
            }

            bw.write(Integer.toString(dist[D]) + "\n");

        }



        // flush after program executed
        bw.flush();
        br.close();
        bw.close();
    }
}