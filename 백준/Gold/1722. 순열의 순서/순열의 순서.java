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

        BigInteger[] factorial = new BigInteger[N+1];
        factorial[0] = BigInteger.ONE;
        for (int i = 1; i <= N; i++) factorial[i] = factorial[i-1].multiply(BigInteger.valueOf(i));


        st = new StringTokenizer(br.readLine());
        int type = Integer.parseInt(st.nextToken());

        if (type == 1) {
            BigInteger num = new BigInteger(st.nextToken());
            num = num.subtract(BigInteger.ONE);

            List<BigInteger> numList = new ArrayList<>();
            for (int i = 1; i <= N; i++) numList.add(BigInteger.valueOf(i));

            for (int i = N-1; i >= 0; i--) {
                BigInteger a = num.divide(factorial[i]);
                num = num.mod(factorial[i]);

               //System.out.printf("%d\n", a.intValue());
                bw.write(numList.get(a.intValue()).toString() + " ");
                numList.remove(a.intValue());
            }
        }
        else {
            List<BigInteger> numList = new ArrayList<>();
            List<BigInteger> inputList = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                numList.add(BigInteger.valueOf(i+1));
                inputList.add(new BigInteger(st.nextToken()));
            }

            BigInteger cnt = BigInteger.ONE;
            for (int i = N-1; i >= 0; i--) {
                BigInteger nowVal = inputList.get(0);
                inputList.remove(0);

                int idx = -1;
                for (int j = 0; j <= i; j++) {
                    if (numList.get(j).equals(nowVal)) {
                        idx = j;
                        break;
                    }
                }
                numList.remove(idx);

                cnt = cnt.add(factorial[i].multiply(BigInteger.valueOf(idx)));

            }
            bw.write(cnt.toString());
        }








        // flush after program executed
        bw.flush();
        br.close();
        bw.close();
    }
}