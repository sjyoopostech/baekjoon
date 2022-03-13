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

        String number = br.readLine();

        int len = number.length();
        List<Character> jari = new ArrayList<>();

        int sum = 0;
        boolean iszero = false;
        for (int i = 0; i < len; i++) {
            char c = number.charAt(i);
            jari.add(c);

            int a = c-48;
            sum += a;
            if (a == 0) iszero = true;
        }

        if (sum % 3 == 0 && iszero) {
            Collections.sort(jari, Collections.reverseOrder());
            for (int i = 0; i < len; i++) {
                bw.write(jari.get(i));
            }
        }
        else {
            bw.write("-1");
        }


        // flush after program executed
        bw.flush();
        br.close();
        bw.close();
    }
}