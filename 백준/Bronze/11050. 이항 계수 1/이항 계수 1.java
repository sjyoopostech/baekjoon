import java.io.*;
import java.util.*;

public class Main {
    static long fac(long x) {
        if (x == 0) return 1;
        else if (x == 1) return 1;
        else return fac(x-1) * x;
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

        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());

        long c = a-b;

        bw.write(Long.toString(fac(a) / fac(b) / fac(c)));



        // flush after program executed
        bw.flush();
        br.close();
        bw.close();
    }
}