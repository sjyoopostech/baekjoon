import java.io.*;
import java.math.BigInteger;
import java.util.*;

class Node {
    public int idx;
    public int val;

    public Node(int idx, int val) {
        this.idx = idx;
        this.val = val;
    }
}

public class Main {
    static long calc (long xb, long yb, long nb) {
        long a = xb + nb;
        long b = yb + nb;
        return b*100/a;
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
        int L = Integer.parseInt(st.nextToken());

        int[] array = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) array[i] = Integer.parseInt(st.nextToken());

        Deque<Node> deq = new ArrayDeque<>();

        for (int i = 0; i < N; i++) {
            if (!deq.isEmpty()) {
                if (deq.peekFirst().idx <= i-L) deq.pollFirst();
            }
            while(!deq.isEmpty()) {
                if (deq.peekLast().val >= array[i]) deq.pollLast();
                else break;
            }
            deq.add(new Node(i, array[i]));
            bw.write(Integer.toString(deq.peekFirst().val) + " ");
        }

        // flush after program executed
        bw.flush();
        br.close();
        bw.close();
    }
}
