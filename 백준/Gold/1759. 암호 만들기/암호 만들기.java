import java.io.*;
import java.util.*;


public class Main {

    static int aeiou(String str) {
        int cnt = 0;

        int len = str.length();
        for (int i = 0; i < len; i++) {
            if (str.charAt(i) == 'a' || str.charAt(i) == 'e' || str.charAt(i) == 'i' || str.charAt(i) == 'o' || str.charAt(i) == 'u') {
                cnt++;
            }
        }
        return cnt;
    }

    static void back(List<Character> charList, String str, int pos, int size) {
        if (pos > charList.size()) return;

        if (str.length() == size) {
            int mo = aeiou(str);
            if (mo >= 1 && str.length() - mo >= 2) {
                System.out.println(str);
            }
        }
        else {
            if (pos < charList.size()) back(charList, str + charList.get(pos), pos+1, size);
            back(charList, str, pos+1, size);
        }


    }

    public static void main(String[] args) throws Exception {
        // input & output buffer class
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // String Classes
        // StringBuilder, String Tokenizer
        StringTokenizer st;
        st = new StringTokenizer(br.readLine(), " ");

        int L = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        List<Character> charList = new ArrayList<>();
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < C; i++) {
            charList.add(st.nextToken().charAt(0));
        }
        Collections.sort(charList);

        back(charList, "", 0, L);





        // flush after program executed
        //bw.flush();
        br.close();
        //bw.close();
    }
}
