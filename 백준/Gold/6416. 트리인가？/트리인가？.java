import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

class Edge {
    public int node1;
    public int node2;

    public Edge (int node1, int node2) {
        this.node1 = node1;
        this.node2 = node2;
    }
}

public class Main {
    static void determine(List<Edge> edgeList, int num) {
        if (edgeList.size() == 0) {
            System.out.printf("Case %d is a tree.\n", num);
        }
        else {
            int size = edgeList.size();
            List<Integer> vertexList = new ArrayList<>();
            List<Integer> comingList = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                vertexList.add(edgeList.get(i).node1);
                vertexList.add(edgeList.get(i).node2);

                comingList.add(edgeList.get(i).node2);
            }
            Collections.sort(vertexList);
            Collections.sort(comingList);

            int csize = comingList.size();
            for (int i = 1; i < csize; i++) {
                if (comingList.get(i) == comingList.get(i-1)) {
                    System.out.printf("Case %d is not a tree.\n", num);
                    return;
                }
            }

            List<Integer> vList = new ArrayList<>();
            int vsize = vertexList.size();
            vList.add(vertexList.get(0));
            for (int i = 1; i < vsize; i++) {
                if (vertexList.get(i) == vertexList.get(i-1)) continue;
                vList.add(vertexList.get(i));
            }

            if (vList.size() != size+1) System.out.printf("Case %d is not a tree.\n", num);
            else System.out.printf("Case %d is a tree.\n", num);
        }
    }

    public static void main(String[] args) throws Exception {
        // input & output buffer class
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // String Classes
        // StringBuilder, String Tokenizer
        StringTokenizer st;

        List<Edge> edgeList = new ArrayList<>();
        int num = 1;
        boolean finished = false;
        while (!finished) {
            st = new StringTokenizer(br.readLine());
            int cnt = st.countTokens();
            for (int i = 0; i < cnt; i += 2) {
                int node1 = Integer.parseInt(st.nextToken());
                int node2 = Integer.parseInt(st.nextToken());
                if (node1 == 0) {
                    determine(edgeList, num);
                    num++;
                    edgeList = new ArrayList<>();
                }
                else if (node1 == -1) {
                    finished = true;
                    break;
                }
                else {
                    edgeList.add(new Edge(node1, node2));
                }
            }
        }



        // flush after program executed
        bw.flush();
        br.close();
        bw.close();
    }
}
