import java.io.*;
import java.util.*;


public class Main {

    public static void main(String[] args) throws Exception {
        // input & output buffer class
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // String Classes
        // StringBuilder, String Tokenizer
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        Deque<Integer> queue = new ArrayDeque<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String task = st.nextToken();

            if (task.equals("push")) {
                queue.add(Integer.parseInt(st.nextToken()));
            }
            else if (task.equals("pop")) {
                if (queue.isEmpty()) bw.write("-1\n");
                else bw.write(Integer.toString(queue.poll()) + "\n");
            }
            else if (task.equals("size")) {
                bw.write(Integer.toString(queue.size()) + "\n");
            }
            else if (task.equals("empty")) {
                if (queue.isEmpty()) bw.write("1\n");
                else bw.write("0\n");
            }
            else if (task.equals("front")) {
                if (queue.isEmpty()) bw.write("-1\n");
                else bw.write(Integer.toString(queue.peekFirst()) + "\n");
            }
            else if (task.equals("back")) {
                if (queue.isEmpty()) bw.write("-1\n");
                else bw.write(Integer.toString(queue.peekLast()) + "\n");
            }
        }

        // flush after program executed
        bw.flush();
        br.close();
        bw.close();
    }
}
