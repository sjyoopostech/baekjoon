import java.io.*;
import java.util.*;

class FrameComparator implements Comparator<Frame> {
    @Override
    public int compare(Frame o1, Frame o2) {
        if (o1.count > o2.count) return 1;
        else if (o1.count < o2.count) return -1;
        else if (o1.last > o2.last) return 1;
        else if (o1.last < o2.last) return -1;
        else return 0;
    }
}

class FrameComparator2 implements Comparator<Frame> {
    @Override
    public int compare(Frame o1, Frame o2) {
        if (o1.picnum > o2.picnum) return 1;
        else if (o1.picnum < o2.picnum) return -1;
        else return 0;
    }
}

class Frame {
    public int picnum, count, last;
    public Frame() {
        this.picnum = -1;
        this.count = 0;
        this.last = -1;
    };
}


public class Main {
    public static void main(String[] args) throws Exception {

        // input & output buffer class
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // String Classes
        // StringBuilder, String Tokenizer
        StringTokenizer st;

        int numFrame = Integer.parseInt(br.readLine());
        int num = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");

        List<Frame> frameList = new ArrayList<>();
        for (int i = 0; i < numFrame; i++) {
            frameList.add(new Frame());
        }

        for (int i = 0; i < num; i++) {
            int present = Integer.parseInt(st.nextToken());

            boolean isfound = false;
            for (int j = 0; j < numFrame; j++) {
                if (frameList.get(j).picnum == present) {
                    frameList.get(j).count++;
                    //frameList.get(j).last = i;
                    isfound = true;
                    break;
                }
            }
            if (!isfound) {
                Collections.sort(frameList, new FrameComparator());
                frameList.get(0).picnum = present;
                frameList.get(0).count = 1;
                frameList.get(0).last = i;
            }
        }

        Collections.sort(frameList, new FrameComparator2());
        for (int i = 0; i < numFrame; i++) {
            if (frameList.get(i).picnum == -1) continue;
            bw.write(Integer.toString(frameList.get(i).picnum) + " ");
        }

        // flush after program executed
        bw.flush();
        br.close();
        bw.close();
    }
}
