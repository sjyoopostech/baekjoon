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

        int T = Integer.parseInt(br.readLine());

        int xn = Integer.parseInt(br.readLine());
        int[] xarray = new int[xn];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < xn; i++) xarray[i] = Integer.parseInt(st.nextToken());

        int yn = Integer.parseInt(br.readLine());
        int[] yarray = new int[yn];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < yn; i++) yarray[i] = Integer.parseInt(st.nextToken());

        int xxn = (xn*(xn+1))/2;
        int [] xxarray = new int[xxn];
        int k = 0;
        for (int i = 0; i < xn; i++) {
            int sum = 0;
            for (int j = i; j < xn; j++) {
                sum += xarray[j];
                xxarray[k] = sum;
                k++;
            }
        }

        int yyn = (yn*(yn+1))/2;
        int [] yyarray = new int[yyn];
        k = 0;
        for (int i = 0; i < yn; i++) {
            int sum = 0;
            for (int j = i; j < yn; j++) {
                sum += yarray[j];
                yyarray[k] = sum;
                k++;
            }
        }

        Arrays.sort(xxarray);
        Arrays.sort(yyarray);

        long cnt = 0;
        int head = 0;
        int tail = yyn-1;
        while (head < xxn && tail >= 0) {
            if (xxarray[head] + yyarray[tail] > T) tail--;
            else if (xxarray[head] + yyarray[tail] < T) head++;
            else {
                int newhead = head+1;
                int newtail = tail-1;
                while (newhead < xxn) {
                    if (xxarray[head] == xxarray[newhead]) newhead++;
                    else break;
                }
                while (newtail >= 0) {
                    if (yyarray[tail] == yyarray[newtail]) newtail--;
                    else break;
                }
                cnt += ((long)(newhead-head)) * ((long)(tail-newtail));
                head = newhead;
                tail = newtail;
            }
        }
        bw.write(Long.toString(cnt));

        // flush after program executed
        bw.flush();
        br.close();
        bw.close();
    }
}
