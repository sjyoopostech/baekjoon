import java.io.*;
import java.util.*;


public class Main {

    static void printpreorder(char[][] array, int N, int pos) {
        System.out.printf("%c", array[pos][0]);
        for (int i = 0; i < N; i++) {
            if (array[pos][1] == array[i][0]) printpreorder(array, N, i);
        }
        for (int i = 0; i < N; i++) {
            if (array[pos][2] == array[i][0]) printpreorder(array, N, i);
        }
    }

    static void printinorder(char[][] array, int N, int pos) {
        for (int i = 0; i < N; i++) {
            if (array[pos][1] == array[i][0]) printinorder(array, N, i);
        }
        System.out.printf("%c", array[pos][0]);
        for (int i = 0; i < N; i++) {
            if (array[pos][2] == array[i][0]) printinorder(array, N, i);
        }
    }

    static void printpostorder(char[][] array, int N, int pos) {
        for (int i = 0; i < N; i++) {
            if (array[pos][1] == array[i][0]) printpostorder(array, N, i);
        }
        for (int i = 0; i < N; i++) {
            if (array[pos][2] == array[i][0]) printpostorder(array, N, i);
        }
        System.out.printf("%c", array[pos][0]);
    }

    public static void main(String[] args) throws Exception {
        // input & output buffer class
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // String Classes
        // StringBuilder, String Tokenizer
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        char[][] array = new char[N][3];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                array[i][j] = st.nextToken().charAt(0);
            }
        }

        printpreorder(array, N, 0);
        System.out.println("");
        printinorder(array, N, 0);
        System.out.println("");
        printpostorder(array, N, 0);


        // flush after program executed
        bw.flush();
        br.close();
        bw.close();
    }
}
