import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
    static BigInteger gcd (BigInteger j, BigInteger k) {
        if (j.equals(BigInteger.ZERO) || k.equals(BigInteger.ZERO)) return BigInteger.ONE;
        if (!j.max(k).equals(j)) {
            BigInteger l = k;
            k = j;
            j = l;
        }
        BigInteger l;
        while (!(l = j.mod(k)).equals(BigInteger.ZERO)) {
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

        for (int pp = 0; pp < N; pp++) {
            String line = br.readLine();
            int len = line.length();

            int cnt1 = -1;
            int cnt2 = -1;

            for (int j = 0; j < len; j++) {
                if (line.charAt(j) == '(') cnt1 = j;
                else if (line.charAt(j) == ')') cnt2 = j;
            }

            BigInteger ja1 = BigInteger.ZERO;
            BigInteger mo1 = BigInteger.ONE;
            BigInteger ja2 = BigInteger.ZERO;
            BigInteger mo2 = BigInteger.ONE;

            if (cnt1 != 2) {
                if (cnt1 != -1) {
                    ja1 = new BigInteger(line.substring(2, cnt1));
                    for (int i = 2; i < cnt1; i++) {
                        mo1 = mo1.multiply(BigInteger.TEN);
                    }
                }
                else {
                    ja1 = new BigInteger(line.substring(2));
                    for (int i = 2; i < len; i++) {
                        mo1 = mo1.multiply(BigInteger.TEN);
                    }

                }

            }

            if (cnt1 != -1) {
                ja2 = new BigInteger(line.substring(cnt1+1, cnt2));
                for (int i = cnt1+1; i < cnt2; i++) {
                    mo2 = mo2.multiply(BigInteger.TEN);
                }
                mo2 = mo2.subtract(BigInteger.ONE);
                mo2 = mo2.multiply(mo1);
            }

            BigInteger gg1 = gcd(ja1, mo1);
            ja1 = ja1.divide(gg1);
            mo1 = mo1.divide(gg1);

            BigInteger gg2 = gcd(ja2, mo2);
            ja2 = ja2.divide(gg2);
            mo2 = mo2.divide(gg2);

            BigInteger ja = ja1.multiply(mo2).add(ja2.multiply(mo1));
            BigInteger mo = mo1.multiply(mo2);
            BigInteger gg = gcd(ja, mo);
            ja = ja.divide(gg);
            mo = mo.divide(gg);

            bw.write(ja.toString() + "/" + mo.toString() + "\n");
        }


        // flush after program executed
        bw.flush();
        br.close();
        bw.close();
    }
}