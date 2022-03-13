import java.io.*;
import java.util.*;

class Node {
    public Node child1;
    public Node child2;
    public int min;
    public int max;
    public long sum;

    public Node (int min, int max, Node child1, Node child2) {
        this.child1 = child1;
        this.child2 = child2;
        this.min = min;
        this.max = max;
        this.sum = 0;
    }
}


public class Main {
    static Node makeNode(int min, int max) {
        Node n;
        if (min == max) {
            n = new Node(min, max, null, null);
        }
        else {
            int mid = (min+max)/2;
            n = new Node(min, max, makeNode(min,mid), makeNode(mid+1,max));
        }
        return n;
    }

    static void changesum(Node n, int idx, long changeval) {
        if (n == null) return;
        if (idx < n.min || idx > n.max) return;

        n.sum += changeval;
        changesum(n.child1, idx, changeval);
        changesum(n.child2, idx, changeval);
    }

    static long calc(Node n, int head, int tail) {
        if (n.min >= head && n.max <= tail) {
            return n.sum;
        }
        else if (n.min > tail || n.max < head) {
            return 0;
        }
        else {
            return calc(n.child1, head, tail) + calc(n.child2, head, tail);
        }
    }

    public static void main(String[] args) throws Exception {
        // input & output buffer class
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // input without line number
        // while ((line = br.readLine()) != null && !line.equals(""))

        // String Classes
        // StringBuilder, String Tokenizer
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());

        long[] array = new long[N+1];
        Node root = makeNode(1,N);

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            long num = Long.parseLong(st.nextToken());

            array[i] = num;
            changesum(root, i, num);
        }

        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());

            int head = Integer.parseInt(st.nextToken());
            int tail = Integer.parseInt(st.nextToken());

            long sum = calc(root, Math.min(head,tail), Math.max(head,tail));
            bw.write(Long.toString(sum) + "\n");

            int target = Integer.parseInt(st.nextToken());
            long newval = Long.parseLong(st.nextToken());
            changesum(root, target, newval-array[target]);
            array[target] = newval;
        }

        // flush after program executed
        bw.flush();
        br.close();
        bw.close();
    }
}