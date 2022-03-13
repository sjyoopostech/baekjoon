import java.io.*;
import java.math.BigInteger;
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

        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());

        String[] numList = new String[N];
        Set<String> resultSet = new HashSet<>();

        for (int i = 0; i < N; i++) {
            numList[i] = br.readLine();
        }

        for (int i = 0; i < N; i++) {
            String a = numList[i];
            for (int j = 0; j < N; j++) {
                if (j == i) continue;
                String b = a + numList[j];
                if (K == 2) {
                    resultSet.add(b);
                    continue;
                }
                for (int k = 0; k < N; k++) {
                    if (k == i || k == j) continue;
                    String c = b + numList[k];
                    if (K == 3) {
                        resultSet.add(c);
                        continue;
                    }
                    for (int l = 0; l < N; l++) {
                        if (l == i || l == j || l == k) continue;
                        String d = c + numList[l];
                        if (K == 4) resultSet.add(d);
                    }
                }
            }
        }

        bw.write(Integer.toString(resultSet.size()));



        // flush after program executed
        bw.flush();
        br.close();
        bw.close();
    }
}