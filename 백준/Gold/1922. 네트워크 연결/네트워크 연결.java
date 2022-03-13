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
        int N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());

        int[][] array = new int[N+1][2];
        for (int i = 1; i <= N; i++) {
            array[i][0] = i;
            array[i][1] = 0;
        }

        List<Edge> edgeList = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            edgeList.add(new Edge(a,b,v));
        }

        Collections.sort(edgeList, new EdgeComparator());

        int sum = 0;
        int cnt = 1;
        if (N == 1) {
            bw.write("0");
        }
        else {
            for (int i = 0; i < M; i++) {
                Edge e = edgeList.get(i);
                if (find(array, e.a, e.b)) continue;

                union(array, e.a, e.b);
                cnt++;
                sum += e.value;

                if (cnt == N) {
                    bw.write(Integer.toString(sum));
                    break;
                }
            }
        }

        // flush after program executed
        bw.flush();
        br.close();
        bw.close();
    }
}