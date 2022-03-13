import java.io.*;
import java.lang.reflect.Array;
import java.util.*;


public class Main {
    public static int nqueen(int size, int pos, int[] board) {

        int sum = 0;
        for (int j = 0; j < size; j++) {
            boolean ispossible = true;
            for (int i = 0; i < pos; i++) {
                int num = board[i];

                if (num == j) {
                    ispossible = false;
                    break;
                }

                if (num-i+pos == j) {
                    ispossible = false;
                    break;
                }

                if (num-pos+i == j) {
                    ispossible = false;
                    break;
                }
            }
            if (ispossible) {
                if (size-pos==1) sum++;
                else {
                    board[pos] = j;
                    sum += nqueen(size,pos+1,board);
                }
            }
        }
        return sum;
    }

    public static void main(String[] args) throws Exception {

        // input & output buffer class
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // String Classes
        // StringBuilder, String Tokenizer
        StringTokenizer st;

        int num = Integer.parseInt(br.readLine());

        if (num == 1) bw.write("1");
        else {
            int[] board = new int[num];
            int sum = 0;
            for (int i = 0; i < num/2; i++) {
                board[0] = i;
                sum += nqueen(num, 1, board);
            }
            sum *= 2;

            if (num % 2 == 1) {
                int i = num/2;
                board[0] = i;
                sum += nqueen(num, 1, board);
            }

            bw.write(Integer.toString(sum));
        }


        // flush after program executed
        bw.flush();
        br.close();
        bw.close();
    }
}
