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


        boolean[] sosu = new boolean[1000001];
        for (int i = 2; i < 1000001; i++) sosu[i] = true;
        for (int i = 2; i < 1000001; i++) {
            if (sosu[i]) {
                for (int j = i*2; j < 1000001; j += i) {
                    sosu[j] = false;
                }
            }
        }

        String line;
        while (!(line = br.readLine()).equals("0")) {
            int num = Integer.parseInt(line);

            for (int i = 3; i <= num/2; i++) {
                if (sosu[i] && sosu[num-i]) {
                    bw.write(Integer.toString(num) + " = " + Integer.toString(i) + " + " + Integer.toString(num-i) + "\n");
                    break;
                }
            }
        }


        // flush after program executed
        bw.flush();
        br.close();
        bw.close();
    }
}