import com.sun.source.tree.BinaryTree;

import java.io.*;
import java.math.BigInteger;
import java.util.*;

class Btree {
    public int val;
    public Btree left;
    public Btree right;
    public int size;

    public Btree (int val, Btree left, Btree right) {
        this.val = val;
        this.size = 0;

        this.left = left;
        this.right = right;
    }
}

public class Main {
    static Btree makeTree(List<Integer> list, int start, int end) {
        if (start > end) return null;

        int mid = (start+end)/2;
        Btree t = new Btree(list.get(mid), makeTree(list, start, mid-1), makeTree(list, mid+1, end));
        return t;
    }

    public static void main(String[] args) throws Exception {
        // input & output buffer class
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // String Classes
        // StringBuilder, String Tokenizer
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] array = new int[N];
        int[] sarray = new int[N];
        for (int i = 0; i < N; i++) {
            array[i] = Integer.parseInt(br.readLine());
            sarray[i] = array[i];
        }

        Arrays.sort(sarray);
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            if (list.isEmpty()) list.add(sarray[i]);
            else if (list.get(list.size()-1) == sarray[i]) continue;
            else list.add(sarray[i]);
        }
        Btree top = makeTree(list, 0, list.size()-1);

        for (int i = 0; i < N; i++) {
            Btree now = top;
            int cnt = 0;
            while (true) {
                now.size++;
                if (now.val > array[i]) {
                    cnt += now.size - now.left.size - 1;
                    now = now.left;
                }
                else if (now.val < array[i]) {
                    now = now.right;
                }
                else {
                    cnt += now.size;
                    if (now.left != null) cnt -= now.left.size;
                    break;
                }
            }
            bw.write(Integer.toString(cnt) + "\n");
        }



        // flush after program executed
        bw.flush();
        br.close();
        bw.close();
    }
}
