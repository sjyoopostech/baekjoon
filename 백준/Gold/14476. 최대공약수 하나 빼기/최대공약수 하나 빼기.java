import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
    static int gcd (int j, int k) {
        if (j < k) {
            int l = k;
            k = j;
            j = l;
        }
        int l;
        while ((l=j%k) != 0) {
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

        int[] array = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }

        int[] leftgcd = new int[N];
        int[] rightgcd = new int[N];

        leftgcd[0] = array[0];
        for (int i = 1; i < N; i++) {
            leftgcd[i] = gcd(leftgcd[i-1], array[i]);
        }

        rightgcd[N-1] = array[N-1];
        for (int i = N-2; i >= 0; i--) {
            rightgcd[i] = gcd(rightgcd[i+1], array[i]);
        }

        int biggestgcd = leftgcd[N-1];
        int idx = -1;

        for (int i = 1; i < N-1; i++) {
            int nowgcd = gcd(leftgcd[i-1], rightgcd[i+1]);
            if (nowgcd > biggestgcd) {
                biggestgcd = nowgcd;
                idx = i;
            }
        }

        if (rightgcd[1] > biggestgcd) {
            biggestgcd = rightgcd[1];
            idx = 0;
        }
        if (leftgcd[N-2] > biggestgcd) {
            biggestgcd = leftgcd[N-2];
            idx = N-1;
        }

        if (idx == -1) bw.write("-1");
        else bw.write(Integer.toString(biggestgcd) + " " + Integer.toString(array[idx]) + "\n");



        // flush after program executed
        bw.flush();
        br.close();
        bw.close();
    }
}