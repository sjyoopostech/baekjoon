import java.io.*;
import java.util.*;

class Number {
    public int val;

    public Number(int val) {
        this.val = val;
    }
}

public class Main {
    static int dfs(int[] discover, boolean[] danjeol, int now, int V, Number n, List<Integer>[] edgeList) {
        discover[now] = n.val;
        n.val++;

        int minnumber = discover[now];
        int child = 0;

        int size = edgeList[now].size();
        for (int i = 0; i < size; i++) {
            int dest = edgeList[now].get(i);
            if (discover[dest] != 0) {
                minnumber = Math.min(minnumber, discover[dest]);
                continue;
            }

            int min = dfs(discover, danjeol, dest, V, n, edgeList);
            minnumber = Math.min(minnumber, min);

            child++;

            if (discover[now] > 1) {
                if (min >= discover[now]) danjeol[now] = true;
            }
            else {
                if (child >= 2) danjeol[now] = true;
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
        boolean[] danjeol = new boolean[V+1];
        for (int i = 1; i <= V; i++) discover[i] = 0;



        for (int i = 1; i <= V; i++) {
            if (discover[i] == 0) {
                Number n = new Number(1);
                dfs(discover, danjeol, i, V, n, edgeList);
            }
        }

        List<Integer> dList = new ArrayList<>();
        for (int i = 1; i <= V; i++) {
            if (danjeol[i]) dList.add(i);
        }

        int dsize = dList.size();
        bw.write(Integer.toString(dsize) + "\n");
        for (int i = 0; i < dsize; i++) {
            bw.write(Integer.toString(dList.get(i)) + " ");
        }


        // flush after program executed
        bw.flush();
        br.close();
        bw.close();
    }
}