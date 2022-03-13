import java.io.*;
import java.util.*;

public class Main {
    static int gcd (int j, int k) {
        if (j < k) {
            int l = k;
            k = j;
            j = l;
        }
        int l;
        while ((l = j % k) != 0) {
            j = k;
            k = l;
        }
        return k;
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


        int N = Integer.parseInt(br.readLine());


        boolean[] sosu = new boolean[N+1];
        for (int i = 2; i < N+1; i++) sosu[i] = true;
        for (int i = 2; i < N+1; i++) {
            if (sosu[i]) {
                for (int j = i*2; j < N+1; j += i) {
                    sosu[j] = false;
                }
            }
        }

        List<Integer> sosuList = new ArrayList<>();
        for (int i = 2; i < N+1; i++) {
            if (sosu[i]) sosuList.add(i);
        }

        int S = sosuList.size();

        int cnt = 0;
        int sum = 0;
        int head = 0;
        int tail = 0;
        while (true) {
            if (sum > N) {
                sum -= sosuList.get(tail);
                tail++;
            }
            else if (sum < N) {
                if (head == S) break;
                sum += sosuList.get(head);
                head++;
            }
            else {
                if (head == S) {
                    cnt++;
                    break;
                }
                sum += sosuList.get(head);
                head++;
                cnt++;
            }
        }
        bw.write(Integer.toString(cnt));


        // flush after program executed
        bw.flush();
        br.close();
        bw.close();
    }
}