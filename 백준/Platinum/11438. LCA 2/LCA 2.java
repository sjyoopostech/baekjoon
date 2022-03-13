import java.io.*;
import java.util.*;

class Node {
    public int value;
    public int depth;
    public List<Integer> ancestor;

    public Node (int value, int depth) {
        this.value = value;
        this.depth = depth;
        this.ancestor = new ArrayList<>();
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

        List<Integer>[] edgeList = new List[N+1];
        for (int i = 1; i <= N; i++) edgeList[i] = new ArrayList<>();

        for (int i = 0; i < N-1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            edgeList[a].add(b);
            edgeList[b].add(a);
        }

        Node[] nodeList = new Node[N+1];
        nodeList[1] = new Node(1, 0);

        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(1);

        while (!queue.isEmpty()) {
            int num = queue.poll();

            int size = edgeList[num].size();
            int parent = 0;
            for (int i = 0; i < size; i++) {
                int adj = edgeList[num].get(i);
                if (nodeList[adj] != null) parent = adj;
                else queue.add(adj);
            }
            if (num != 1) {
                int depth = nodeList[parent].depth + 1;
                nodeList[num] = new Node(num, depth);

                int ancestor = 1;
                int idx = 0;
                while (depth-ancestor >= 0) {
                    if (ancestor == 1) nodeList[num].ancestor.add(parent);
                    else {
                        nodeList[num].ancestor.add(nodeList[nodeList[num].ancestor.get(idx)].ancestor.get(idx));
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

            while (nodeList[a].depth < nodeList[b].depth) {
                int size = nodeList[b].ancestor.size();
                for (int j = size-1; j >= 0; j--) {
                    int now = nodeList[b].ancestor.get(j);
                    if (nodeList[now].depth >= nodeList[a].depth) {
                        b = now;
                        break;
                    }
                }
            }

            while (a != b) {
                int size = nodeList[a].ancestor.size();

                int change = size-1;
                for (int j = 0; j < size; j++) {
                    if (nodeList[a].ancestor.get(j) == nodeList[b].ancestor.get(j)) {
                        change = j-1;
                        break;
                    }
                }
                if (change == -1) {
                    a = nodeList[a].ancestor.get(0);
                    b = nodeList[b].ancestor.get(0);
                }
                else {
                    a = nodeList[a].ancestor.get(change);
                    b = nodeList[b].ancestor.get(change);
                }
            }
            bw.write(Integer.toString(a) + "\n");
        }

        // flush after program executed
        bw.flush();
        br.close();
        bw.close();
    }
}