import java.io.*;
import java.util.*;

class Bosuk {
    public int weight;
    public int value;

    public Bosuk (int weight, int value) {
        this.weight = weight;
        this.value = value;
    }
}

class BosukWeightComparator implements Comparator<Bosuk> {
    @Override
    public int compare(Bosuk o1, Bosuk o2) {
        return o1.weight - o2.weight;
    }
}

class BosukValueComparator implements Comparator<Bosuk> {
    @Override
    public int compare(Bosuk o1, Bosuk o2) {
        return o2.value - o1.value;
    }
}


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
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        List<Bosuk> bosukList = new ArrayList<>();
        List<Integer> bagList = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int weight = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            bosukList.add(new Bosuk(weight, value));
        }

        for (int i = 0; i < K; i++) {
            int weight = Integer.parseInt(br.readLine());
            bagList.add(weight);
        }

        bosukList.sort(new BosukWeightComparator());
        Collections.sort(bagList);

        PriorityQueue<Bosuk> bosukQueue = new PriorityQueue<>(new BosukValueComparator());

        long sum = 0;
        int num = 0;
        for (int i = 0; i < K; i++) {
            int bagweight = bagList.get(i);
            while (num < N) {
                if (bosukList.get(num).weight <= bagweight) {
                    bosukQueue.offer(bosukList.get(num));
                    num++;
                }
                else break;
            }
            if (!bosukQueue.isEmpty()) sum += bosukQueue.poll().value;
        }
        bw.write(Long.toString(sum));

        // flush after program executed
        bw.flush();
        br.close();
        bw.close();
    }
}