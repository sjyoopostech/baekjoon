import java.io.*;
import java.util.*;

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

        List<Integer>[] outNode = new List[N+1];
        int[] inNode = new int[N+1];

        int[] value = new int[N+1];
        int[] totalvalue = new int[N+1];

        for (int i = 1; i <= N; i++) {
            outNode[i] = new ArrayList<>();
            inNode[i] = 0;

            totalvalue[i] = 0;
        }

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            value[i] = Integer.parseInt(st.nextToken());

            int next = Integer.parseInt(st.nextToken());
            while (next != -1) {
                outNode[next].add(i);
                inNode[i]++;

                next = Integer.parseInt(st.nextToken());
            }
        }


        Queue<Integer> queue = new ArrayDeque<>();
        List<Integer> order = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            if (inNode[i] == 0) queue.add(i);
        }

        while (!queue.isEmpty()) {
            int now = queue.poll();
            order.add(now);

            totalvalue[now] += value[now];

            int size = outNode[now].size();
            for (int i = 0; i < size; i++) {
                int target = outNode[now].get(i);
                inNode[target]--;
                if (inNode[target] == 0) queue.add(target);

                totalvalue[target] = Math.max(totalvalue[target], totalvalue[now]);
            }
        }

        int size = order.size();
        for (int i = 1; i <= size; i++) {
            bw.write(Integer.toString(totalvalue[i]) + " ");
        }

        // flush after program executed
        bw.flush();
        br.close();
        bw.close();
    }
}