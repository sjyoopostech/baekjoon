import java.io.*;
import java.util.*;

class Edge {
    public int a;
    public int b;
    public int value;

    public Edge (int a, int b, int value) {
        this.a = a;
        this.b = b;
        this.value = value;
    }
}

class EdgeComparator implements Comparator<Edge> {

    @Override
    public int compare(Edge o1, Edge o2) {
        return o1.value - o2.value;
    }
}

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

class Ances {
    public int node;
    public int first;
    public int second;

    public Ances (int node, int first, int second) {
        this.node = node;
        this.first = first; // first maximum
        this.second = second; // second maximum
    }
}

public class Main {

    static void union (int[][] array, int a, int b) {
        while (array[a][0] != a) a = array[a][0];
        while (array[b][0] != b) b = array[b][0];

        if (a != b) {
            if (array[a][1] >= array[b][1]) {
                array[b][0] = a;
                array[a][1] = Math.max(array[a][1], array[b][1]+1);
            }
            else {
                array[a][0] = b;
                array[b][1] = Math.max(array[b][1], array[a][1]+1);
            }
        }
    }

    static boolean find (int[][] array, int a, int b) {
        while (array[a][0] != a) a = array[a][0];
        while (array[b][0] != b) b = array[b][0];
        return a == b;
    }

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

        int[][] array = new int[V+1][2];
        for (int i = 1; i <= V; i++) {
            array[i][0] = i;
            array[i][1] = 0;
        }

        List<Edge> edgeList = new ArrayList<>();

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            edgeList.add(new Edge(a,b,v));
        }

        Collections.sort(edgeList, new EdgeComparator());

        int sum = 0;
        int cnt = 1;
        if (V == 1) {
            bw.write("-1");
        }
        else {

            List<Edge>[] mstEdgeList = new List[V+1];
            for (int i = 1; i <= V; i++) {
                mstEdgeList[i] = new ArrayList<>();
            }


            List<Edge> sstEdgeList = new ArrayList<>();

            boolean mstMade = false;
            for (int i = 0; i < E; i++) {
                Edge e = edgeList.get(i);
                if (mstMade) {
                    sstEdgeList.add(e);
                    continue;
                }
                if (find(array, e.a, e.b)) {
                    sstEdgeList.add(e);
                    continue;
                }

                mstEdgeList[e.a].add(e);
                mstEdgeList[e.b].add(e);

                union(array, e.a, e.b);
                cnt++;
                sum += e.value;

                if (cnt == V) {
                    mstMade = true;
                }
            }

            if (mstMade) {
                Node[] nodeList = new Node[V+1];
                nodeList[1] = new Node(1, 0);

                Queue<Integer> queue = new ArrayDeque<>();
                queue.add(1);

                while (!queue.isEmpty()) {
                    int num = queue.poll();

                    int size = mstEdgeList[num].size();
                    int parent = 0;
                    int weight = -1;
                    for (int i = 0; i < size; i++) {
                        int adj = mstEdgeList[num].get(i).a;
                        if (adj == num) adj = mstEdgeList[num].get(i).b;
                        if (nodeList[adj] != null) {
                            parent = adj;
                            weight = mstEdgeList[num].get(i).value;
                        }
                        else queue.add(adj);
                    }
                    if (num != 1) {
                        int depth = nodeList[parent].depth + 1;
                        nodeList[num] = new Node(num, depth);

                        int ancestor = 1;
                        int idx = 0;
                        while (depth-ancestor >= 0) {
                            if (ancestor == 1) nodeList[num].ancestor.add(new Ances(parent, weight, -1));
                            else {
                                Ances aaa = nodeList[nodeList[num].ancestor.get(idx).node].ancestor.get(idx);

                                int[] compare = new int[4];

                                compare[0] = aaa.first;
                                compare[1] = aaa.second;
                                compare[2] = nodeList[num].ancestor.get(idx).first;
                                compare[3] = nodeList[num].ancestor.get(idx).second;

                                Arrays.sort(compare);

                                boolean firstfound = false;
                                int first = -1;
                                int second = -1;

                                for (int i = 3; i >= 0; i--) {
                                    if (!firstfound) {
                                        if (compare[i] != -1) {
                                            first = compare[i];
                                            firstfound = true;
                                        }
                                    }
                                    else {
                                        if (compare[i] != -1 && compare[i] != first) {
                                            second = compare[i];
                                            break;
                                        }
                                    }
                                }
                                nodeList[num].ancestor.add(new Ances(aaa.node, first, second));
                                idx++;
                            }
                            ancestor *= 2;
                        }
                    }
                }

                //////////////////////////////////
                int mstresult = sum;
                int sstresult = -1;

                int otherEdgeSize = sstEdgeList.size();
                for (int i = 0; i < otherEdgeSize; i++) {
                    int a = sstEdgeList.get(i).a;
                    int b = sstEdgeList.get(i).b;

                    if (nodeList[a].depth > nodeList[b].depth) {
                        int t = a;
                        a = b;
                        b = t;
                    }

                    int first = -1;
                    int second = -1;

                    while (nodeList[a].depth < nodeList[b].depth) {
                        int size = nodeList[b].ancestor.size();
                        for (int j = size - 1; j >= 0; j--) {
                            int now = nodeList[b].ancestor.get(j).node;
                            if (nodeList[now].depth >= nodeList[a].depth) {

                                int[] compare = new int[4];

                                compare[0] = first;
                                compare[1] = second;
                                compare[2] = nodeList[b].ancestor.get(j).first;
                                compare[3] = nodeList[b].ancestor.get(j).second;

                                Arrays.sort(compare);

                                boolean firstfound = false;
                                int fff = -1;
                                int sss = -1;

                                for (int k = 3; k >= 0; k--) {
                                    if (!firstfound) {
                                        if (compare[k] != -1) {
                                            fff = compare[k];
                                            firstfound = true;
                                        }
                                    }
                                    else {
                                        if (compare[k] != -1 && compare[k] != fff) {
                                            sss = compare[k];
                                            break;
                                        }
                                    }
                                }

                                first = fff;
                                second = sss;

                                b = now;
                                break;
                            }
                        }
                    }

                    while (a != b) {
                        int size = nodeList[a].ancestor.size();

                        int change = size - 1;
                        for (int j = 0; j < size; j++) {
                            if (nodeList[a].ancestor.get(j).node == nodeList[b].ancestor.get(j).node) {
                                change = j - 1;
                                break;
                            }
                        }
                        if (change == -1) {

                            int[] compare = new int[6];

                            compare[0] = first;
                            compare[1] = second;
                            compare[2] = nodeList[a].ancestor.get(0).first;
                            compare[3] = nodeList[a].ancestor.get(0).second;
                            compare[4] = nodeList[b].ancestor.get(0).first;
                            compare[5] = nodeList[b].ancestor.get(0).second;

                            Arrays.sort(compare);

                            boolean firstfound = false;
                            int fff = -1;
                            int sss = -1;

                            for (int k = 5; k >= 0; k--) {
                                if (!firstfound) {
                                    if (compare[k] != -1) {
                                        fff = compare[k];
                                        firstfound = true;
                                    }
                                }
                                else {
                                    if (compare[k] != -1 && compare[k] != fff) {
                                        sss = compare[k];
                                        break;
                                    }
                                }
                            }

                            first = fff;
                            second = sss;


                            a = nodeList[a].ancestor.get(0).node;
                            b = nodeList[b].ancestor.get(0).node;

                        } else {

                            int[] compare = new int[6];

                            compare[0] = first;
                            compare[1] = second;
                            compare[2] = nodeList[a].ancestor.get(change).first;
                            compare[3] = nodeList[a].ancestor.get(change).second;
                            compare[4] = nodeList[b].ancestor.get(change).first;
                            compare[5] = nodeList[b].ancestor.get(change).second;

                            Arrays.sort(compare);

                            boolean firstfound = false;
                            int fff = -1;
                            int sss = -1;

                            for (int k = 5; k >= 0; k--) {
                                if (!firstfound) {
                                    if (compare[k] != -1) {
                                        fff = compare[k];
                                        firstfound = true;
                                    }
                                }
                                else {
                                    if (compare[k] != -1 && compare[k] != fff) {
                                        sss = compare[k];
                                        break;
                                    }
                                }
                            }

                            first = fff;
                            second = sss;

                            a = nodeList[a].ancestor.get(change).node;
                            b = nodeList[b].ancestor.get(change).node;
                        }
                    }
                    int result = sstEdgeList.get(i).value - first;
                    if (result == 0) {
                        if (second == -1) {
                            result = -1;
                        }
                        else result = sstEdgeList.get(i).value - second;
                    }

                    if (result != -1) {
                        if (sstresult == -1) sstresult = result+mstresult;
                        else sstresult = Math.min(sstresult, result+mstresult);
                    }

                }
                bw.write(Integer.toString(sstresult));
            }
            else bw.write("-1");

        }

        // flush after program executed
        bw.flush();
        br.close();
        bw.close();
    }
}