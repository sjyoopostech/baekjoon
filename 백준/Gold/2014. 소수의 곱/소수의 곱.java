import java.io.*;
import java.util.*;

public class Main {
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
        int K = Integer.parseInt(st.nextToken());

        PriorityQueue<Long>[] queueList = new PriorityQueue[N];
        long[] sosuList = new long[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            long number = Integer.parseInt(st.nextToken());

            PriorityQueue<Long> pqueue = new PriorityQueue<>();
            pqueue.add(number);

            sosuList[i] = number;
            queueList[i] = pqueue;
        }

        long num = 0;
        for (int i = 0; i < K; i++) {
            long min = queueList[0].peek();
            int idx = 0;
            for (int j = 1; j < N; j++) {
                long trg = queueList[j].peek();
                if (trg < min) {
                    min = trg;
                    idx = j;
                }
            }
            num = queueList[idx].poll();
            for (int j = idx; j < N; j++) {
                queueList[j].add(num*sosuList[j]);
            }
        }
        bw.write(Long.toString(num));

        // flush after program executed
        bw.flush();
        br.close();
        bw.close();
    }
}
