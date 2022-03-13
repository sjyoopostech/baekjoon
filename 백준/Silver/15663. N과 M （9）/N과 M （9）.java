import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
    static void backtracking (List<Integer> list, String s, int mask, int now, int M, int N) {
        if (now == M) {
            System.out.println(s);
            return;
        }

        int lastused = -1;

        for (int i = 0; i < N; i++) {
            if ((mask & ((int)Math.pow(2,i))) != 0) {
                continue;
            }

            if (i > 0) {
                if (lastused == i-1 && list.get(i) == list.get(i-1)) {
                    lastused = i;
                    continue;
                }
            }
            backtracking(list, s + Integer.toString(list.get(i)) + " ",
                    mask + ((int)Math.pow(2,i)), now+1, M, N);

            lastused = i;
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
        int M = Integer.parseInt(st.nextToken());

        List<Integer> list = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) list.add(Integer.parseInt(st.nextToken()));
        Collections.sort(list);

        backtracking(list, "", 0, 0, M, N);


        // flush after program executed
        bw.flush();
        br.close();
        bw.close();
    }
}