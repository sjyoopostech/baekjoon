import java.io.*;
import java.util.*;

class Number {
    public int val;

    public Number(int val) {
        this.val = val;
    }
}

class Pair {
    public int a;
    public int b;

    public Pair(int a, int b) {
        this.a = a;
        this.b = b;
    }
}

class PairComp implements Comparator<Pair> {

    @Override
    public int compare(Pair o1, Pair o2) {
        if (o1.a != o2.a) return o1.a - o2.a;
        else return o1.b - o2.b;
    }
}

public class Main {
    static int dfs(int[] discover,  List<Pair> dList, int now, int prev, int V, Number n, List<Integer>[] edgeList) {
        discover[now] = n.val;
        n.val++;

        int minnumber = discover[now];

        int size = edgeList[now].size();
        for (int i = 0; i < size; i++) {
            int dest = edgeList[now].get(i);
            if (dest == prev) continue;

            if (discover[dest] != 0) {
                minnumber = Math.min(minnumber, discover[dest]);
                continue;
            }

            int min = dfs(discover, dList, dest, now, V, n, edgeList);
            minnumber = Math.min(minnumber, min);

            if (min > discover[now]) {
                dList.add(new Pair(Math.min(dest, now), Math.max(dest, now)));
            }
        }
        return minnumber;
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

        List<Integer>[] edgeList = new List[V+1];
        for (int i = 1; i <= V; i++) edgeList[i] = new ArrayList<>();
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            edgeList[a].add(b);
            edgeList[b].add(a);
        }

        int[] discover = new int[V+1];
        for (int i = 1; i <= V; i++) discover[i] = 0;


        List<Pair> dList = new ArrayList<>();
        for (int i = 1; i <= V; i++) {
            if (discover[i] == 0) {
                Number n = new Number(1);
                dfs(discover, dList, i, 0, V, n, edgeList);
            }
        }

        dList.sort(new PairComp());
        int dsize = dList.size();
        bw.write(Integer.toString(dsize) + "\n");
        for (int i = 0; i < dsize; i++) {
            bw.write(Integer.toString(dList.get(i).a) + " " + Integer.toString(dList.get(i).b) + "\n");
        }


        // flush after program executed
        bw.flush();
        br.close();
        bw.close();
    }
}