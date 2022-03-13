import java.io.*;
import java.util.*;

class Node {
    int idx;
    int val;

    public Node (int idx, int val) {
        this.idx = idx;
        this.val = val;
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

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        int[] number = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) number[i] = Integer.parseInt(st.nextToken());

        Node[] lis = new Node[N];
        lis[0] = new Node(0, number[0]);
        int size = 1;

        List<Node>[] past = new List[N];
        past[0] = new ArrayList<>();
        past[0].add(lis[0]);


        for (int i = 1; i < N; i++) {
            int start = 0;
            int end = size-1;
            while (start <= end) {
                int mid = (start+end)/2;
                if (number[i] < lis[mid].val) end = mid-1;
                else if (number[i] > lis[mid].val) start = mid+1;
                else {
                    start = mid;
                    break;
                }
            }
            if (start == size) {
                past[start] = new ArrayList<>();
                size++;
            }
            lis[start] = new Node(i, number[i]);
            past[start].add(lis[start]);
        }

        for (int i = size-2; i >= 0; i--) {
            int isize = past[i].size();
            for (int j = isize-1; j >= 0; j--) {
                if (past[i].get(j).idx < lis[i+1].idx) {
                    lis[i] = past[i].get(j);
                    break;
                }
            }
        }

        bw.write(Integer.toString(size) + "\n");
        for (int i = 0; i < size; i++) {
            bw.write(Integer.toString(lis[i].val) + " ");
        }


        // flush after program executed
        bw.flush();
        br.close();
        bw.close();
    }
}