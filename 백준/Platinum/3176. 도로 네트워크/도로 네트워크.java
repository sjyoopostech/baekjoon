import java.io.*;
import java.util.*;

class Node {
    public int value;
    public int depth;
    public List<Ances> ancestor;

    public Node (int value, int depth) {
        this.value = value;
        this.depth = depth;
        this.ancestor = new ArrayList<>();
    }
}

class Edge {
    public int num;
    public int value;

    public Edge (int num, int value) {
        this.num = num;
        this.value = value;
    }
}

class Ances {
    public int node;
    public int max;
    public int min;

    public Ances (int node, int max, int min) {
        this.node = node;
        this.max = max;
        this.min = min;
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

        List<Edge>[] edgeList = new List[N+1];
        for (int i = 1; i <= N; i++) edgeList[i] = new ArrayList<>();

        for (int i = 0; i < N-1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            edgeList[a].add(new Edge(b, v));
            edgeList[b].add(new Edge(a, v));
        }

        Node[] nodeList = new Node[N+1];
        nodeList[1] = new Node(1, 0);

        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(1);

        while (!queue.isEmpty()) {
            int num = queue.poll();

            int size = edgeList[num].size();
            int parent = 0;
            int weight = -1;
            for (int i = 0; i < size; i++) {
                int adj = edgeList[num].get(i).num;
                if (nodeList[adj] != null) {
                    parent = adj;
                    weight = edgeList[num].get(i).value;
                }
                else queue.add(adj);
            }
            if (num != 1) {
                int depth = nodeList[parent].depth + 1;
                nodeList[num] = new Node(num, depth);

                int ancestor = 1;
                int idx = 0;
                while (depth-ancestor >= 0) {
                    if (ancestor == 1) {
                        nodeList[num].ancestor.add(new Ances(parent, weight, weight));
                    }
                    else {
                        Ances aaa = nodeList[nodeList[num].ancestor.get(idx).node].ancestor.get(idx);

                        int min = nodeList[num].ancestor.get(idx).min;
                        int max = nodeList[num].ancestor.get(idx).max;

                        nodeList[num].ancestor.add(new Ances(aaa.node, Math.max(aaa.max, max), Math.min(aaa.min, min)));
                        idx++;
                    }
                    ancestor *= 2;
                }
            }
        }

        int M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (nodeList[a].depth > nodeList[b].depth) {
                int t = a;
                a = b;
                b = t;
            }

            int min = 10000001;
            int max = -1;

            while (nodeList[a].depth < nodeList[b].depth) {
                int size = nodeList[b].ancestor.size();
                for (int j = size-1; j >= 0; j--) {
                    int now = nodeList[b].ancestor.get(j).node;

                    if (nodeList[now].depth >= nodeList[a].depth) {
                        min = Math.min(min, nodeList[b].ancestor.get(j).min);
                        max = Math.max(max, nodeList[b].ancestor.get(j).max);

                        b = now;
                        break;
                    }
                }
            }

            while (a != b) {
                int size = nodeList[a].ancestor.size();

                int change = size-1;
                for (int j = 0; j < size; j++) {
                    if (nodeList[a].ancestor.get(j).node == nodeList[b].ancestor.get(j).node) {
                        change = j-1;
                        break;
                    }
                }
                if (change == -1) {
                    min = Math.min(min, nodeList[a].ancestor.get(0).min);
                    max = Math.max(max, nodeList[a].ancestor.get(0).max);

                    min = Math.min(min, nodeList[b].ancestor.get(0).min);
                    max = Math.max(max, nodeList[b].ancestor.get(0).max);

                    a = nodeList[a].ancestor.get(0).node;
                    b = nodeList[b].ancestor.get(0).node;



                }
                else {
                    min = Math.min(min, nodeList[a].ancestor.get(change).min);
                    max = Math.max(max, nodeList[a].ancestor.get(change).max);

                    min = Math.min(min, nodeList[b].ancestor.get(change).min);
                    max = Math.max(max, nodeList[b].ancestor.get(change).max);

                    a = nodeList[a].ancestor.get(change).node;
                    b = nodeList[b].ancestor.get(change).node;
                }
            }
            bw.write(Integer.toString(min)+ " " + Integer.toString(max) + "\n");
        }

        // flush after program executed
        bw.flush();
        br.close();
        bw.close();
    }
}