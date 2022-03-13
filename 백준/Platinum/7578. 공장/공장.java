import java.io.*;
import java.util.*;

class Node {
    public int idx;
    public int value;

    public Node (int idx, int value) {
        this.idx = idx;
        this.value = value;
    }
}

class NodeComp implements Comparator<Node> {

    @Override
    public int compare(Node o1, Node o2) {
        return o1.value - o2.value;
    }
}

class Tree {
    public long sum;
    public int min;
    public int max;
    public Tree left;
    public Tree right;

    public Tree (int min, int max, Tree left, Tree right) {
        this.sum = 0;
        this.min = min;
        this.max = max;
        this.left = left;
        this.right = right;
    }
}

public class Main {
    static Tree makeTree(int min, int max) {
        if (min == max) {
            return new Tree(min, max, null, null);
        }
        int mid = (min+max)/2;
        Tree left = makeTree(min, mid);
        Tree right = makeTree(mid+1, max);

        return new Tree(min, max, left, right);
    }

    static void count(Tree t, int val) {
        if (t.left != null) {
            if (val <= t.left.max) count(t.left, val);
            else count(t.right, val);
        }
        t.sum++;
    }

    static long checklarge(Tree t, int val) {
        if (t.left == null) return 0;
        if (val < t.right.min) return t.right.sum + checklarge(t.left, val);
        return checklarge(t.right, val);
    }

    public static void main(String[] args) throws Exception {

        // input & output buffer class
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // String Classes
        // StringBuilder, String Tokenizer
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        List<Node> aList = new ArrayList<>();
        List<Node> bList = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) aList.add(new Node(i, Integer.parseInt(st.nextToken())));
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) bList.add(new Node(i, Integer.parseInt(st.nextToken())));

        Collections.sort(aList, new NodeComp());
        Collections.sort(bList, new NodeComp());

        int[] indexArray = new int[N];
        for (int i = 0; i < N; i++) {
            indexArray[aList.get(i).idx] = bList.get(i).idx;
        }

        Tree root = makeTree(0, N-1);

        long sum = 0;
        for (int i = 0; i < N; i++) {
            sum += checklarge(root, indexArray[i]);
            count(root, indexArray[i]);
        }
        bw.write(Long.toString(sum));

        // flush after program executed
        bw.flush();
        br.close();
        bw.close();
    }
}