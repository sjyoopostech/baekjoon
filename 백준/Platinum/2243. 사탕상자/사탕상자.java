import java.io.*;
import java.util.*;

class Node {
    public Node child1;
    public Node child2;
    public int min;
    public int max;
    public int sum;

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

    static void changesum(Node n, int idx, int changeval) {
        if (n == null) return;
        if (idx < n.min || idx > n.max) return;

        n.sum += changeval;
        changesum(n.child1, idx, changeval);
        changesum(n.child2, idx, changeval);
    }

    static int calc(Node n, int sunwi) {
        if (n.sum < sunwi) return -1;

        n.sum--;
        if (n.min == n.max) {
            System.out.println(n.min);
        }
        else if (calc(n.child1, sunwi) == -1) {
            calc(n.child2, sunwi - n.child1.sum);
        }
        return sunwi;
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

        //int[] array = new int[1000000+1];
        //Arrays.fill(array, 0);
        Node root = makeNode(1,1000000);

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int type = Integer.parseInt(st.nextToken());
            if (type == 1) {
                int sunwi = Integer.parseInt(st.nextToken());
                calc(root, sunwi);
            }
            else if (type == 2) {
                int idx = Integer.parseInt(st.nextToken());
                int num = Integer.parseInt(st.nextToken());

                //array[i] += num;
                changesum(root, idx, num);
            }
        }


        // flush after program executed
        bw.flush();
        br.close();
        bw.close();
    }
}