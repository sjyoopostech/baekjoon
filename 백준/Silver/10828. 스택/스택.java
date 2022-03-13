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

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String task = st.nextToken();

            if (task.equals("push")) {
                stack.push(Integer.parseInt(st.nextToken()));
            }
            else if (task.equals("pop")) {
                if (stack.isEmpty()) bw.write("-1\n");
                else bw.write(Integer.toString(stack.pop()) + "\n");
            }
            else if (task.equals("size")) {
                bw.write(Integer.toString(stack.size()) + "\n");
            }
            else if (task.equals("empty")) {
                if (stack.isEmpty()) bw.write("1\n");
                else bw.write("0\n");
            }
            else if (task.equals("top")) {
                if (stack.isEmpty()) bw.write("-1\n");
                else bw.write(Integer.toString(stack.peek()) + "\n");
            }
        }
        
        // flush after program executed
        bw.flush();
        br.close();
        bw.close();
    }
}
