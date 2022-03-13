import java.io.*;
import java.math.BigInteger;
import java.util.*;


public class Main {
    static int calc(List<Integer> treeList, int num) {
        BigInteger sum = new BigInteger("0");
        for (int t : treeList) {
            if (t > num) sum = sum.add(BigInteger.valueOf(t-num));
        }

        if (sum.max(BigInteger.valueOf(2000000001)).equals(BigInteger.valueOf(2000000001))) return sum.intValue();
        else return 2000000001;
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
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        List<Integer> treeList = new ArrayList<>();
        for (int i = 0; i < N; i++) treeList.add(Integer.parseInt(st.nextToken()));
        Collections.sort(treeList);

        int start = 0;
        int end = treeList.get(N-1);
        int max = 0;
        while (start <= end) {
            int mid = (start + end)/2;
            int result = calc(treeList, mid);
            if (result >= M) {
                start = mid + 1;
                max = mid;
            }
            else if (result < M) end = mid - 1;
        }

        bw.write(Integer.toString(max));

        // flush after program executed
        bw.flush();
        br.close();
        bw.close();
    }
}
