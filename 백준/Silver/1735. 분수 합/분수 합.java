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
        int xu = Integer.parseInt(st.nextToken());
        int xd = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int yu = Integer.parseInt(st.nextToken());
        int yd = Integer.parseInt(st.nextToken());

        int u = xu*yd + yu*xd;
        int d = xd*yd;

        int a = Math.max(u,d);
        int b = Math.min(u,d);
        while (a % b != 0) {
            int c = a % b;
            a = b;
            b = c;
        }

        bw.write(Integer.toString(u/b) + " " + Integer.toString(d/b));
        

        // flush after program executed
        bw.flush();
        br.close();
        bw.close();
    }
}