import java.io.*;
import java.util.*;

class Point {
    public int x;
    public int y;

    public Point (int x, int y) {
        this.x = x;
        this.y = y;
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
        int M = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][N];
        List<Point> houseList = new ArrayList<>();
        List<Point> chickenList = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) houseList.add(new Point(i,j));
                else if (map[i][j] == 2) chickenList.add(new Point(i,j));
            }
        }

        int totalmin = 10000;

        int houseSize = houseList.size();
        int chickenSize = chickenList.size();

        int end = (int) Math.pow(2,chickenSize);

        for (int i = 0; i < end; i++) {
            int cntChicken = 0;
            boolean[] isChicken = new boolean[chickenSize];
            for (int j = 0; j < chickenSize; j++) {
                isChicken[j] = (i & (int)Math.pow(2,j)) != 0;
                if (isChicken[j]) cntChicken++;
            }
            if (cntChicken != M) continue;

            int sum = 0;
            for (int j = 0; j < houseSize; j++) {
                int min = 10000;
                for (int k = 0; k < chickenSize; k++) {
                    if (!isChicken[k]) continue;
                    int distance = Math.abs(houseList.get(j).x - chickenList.get(k).x);
                    distance += Math.abs(houseList.get(j).y - chickenList.get(k).y);
                    if (min > distance) min = distance;
                }
                sum += min;
            }
            if (totalmin > sum) totalmin = sum;

        }
        bw.write(Integer.toString(totalmin));

        // flush after program executed
        bw.flush();
        br.close();
        bw.close();
    }
}