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

        String line = br.readLine();
        int len = line.length();

        Stack<Integer> stringstack = new Stack<>();
        Stack<Integer> valuestack = new Stack<>();
        valuestack.push(0);

        boolean error = false;
        for (int i = 0; i < len; i++) {
            if (line.charAt(i) == '(') {
                stringstack.push(0);
                valuestack.push(0);
            }
            else if (line.charAt(i) == '[') {
                stringstack.push(1);
                valuestack.push(0);
            }
            else if (line.charAt(i) == ')') {
                if (stringstack.isEmpty()) {
                    error = true;
                    break;
                }
                else if (stringstack.pop() != 0) {
                    error = true;
                    break;
                }
                int val = 2 * valuestack.pop();
                if (val == 0) val = 2;
                val += valuestack.pop();
                valuestack.push(val);
            }
            else if (line.charAt(i) == ']') {
                if (stringstack.isEmpty()) {
                    error = true;
                    break;
                }
                else if (stringstack.pop() != 1) {
                    error = true;
                    break;
                }
                int val = 3 * valuestack.pop();
                if (val == 0) val = 3;
                val += valuestack.pop();
                valuestack.push(val);
            }
        }
        if (error) bw.write("0");
        else if (!stringstack.isEmpty()) bw.write("0");
        else bw.write(Integer.toString(valuestack.pop()));

        // flush after program executed
        bw.flush();
        br.close();
        bw.close();
    }
}
