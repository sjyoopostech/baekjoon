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

        int NN = Integer.parseInt(br.readLine());

        int[] array = new int[NN];
        int max = 0;
        for (int i = 0; i < NN; i++) {
            int N = Integer.parseInt(br.readLine());
            array[i] = N;
            max = Math.max(max, N);
        }

        int[] ar = new int[max+1];

        int cnt = 0;
        for (int j = 1; j <= max; j++) {
            for (int k = 1; k < j; k++) {
                if (gcd(j,k) == 1) cnt++;
            }
            ar[j] = cnt;
        }

        for (int i = 0; i < NN; i++) {
            bw.write(Integer.toString(ar[array[i]]*2+3) + "\n");
        }

        // flush after program executed
        bw.flush();
        br.close();
        bw.close();
    }
}