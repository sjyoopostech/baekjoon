import java.io.*;
import java.util.*;


public class Main {

    static void search(List<Integer> list, int start, int end) {
        if (start > end) return;
        if (start == end) {
            System.out.println(list.get(start));
            return;
        }

        int val = list.get(start);

        int nstart = start+1;
        int nend = end;
        while(nstart <= nend) {
            int mid = (nstart+nend)/2;
            if (list.get(mid) > val) nend = mid-1;
            else nstart = mid+1;
        }
        search(list, start+1, nend);
        search(list, nstart, end);

        System.out.println(val);
    }

    public static void main(String[] args) throws Exception {
        // input & output buffer class
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // String Classes
        // StringBuilder, String Tokenizer
        StringTokenizer st;

        List<Integer> list = new ArrayList<>();

        String line;
        while ((line = br.readLine()) != null && !line.equals("")) {
            int number = Integer.parseInt(line);
            list.add(number);
        }
        if (!list.isEmpty()) search(list, 0, list.size()-1);


        // flush after program executed
        bw.flush();
        br.close();
        bw.close();
    }
}
