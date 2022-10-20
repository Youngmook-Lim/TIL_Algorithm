import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
 * LVR 회회
 * */
public class Main {

    static int k, size, idx;
    static int[] answer;
    static StringTokenizer st;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        k = Integer.parseInt(br.readLine());
        size = (int) Math.pow(2, k) - 1;
        answer = new int[size + 1];
        idx = 1;

        st = new StringTokenizer(br.readLine());

        inOrderTreeTraversal(1);

        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= size; i++) {
            sb.append(answer[i]).append(' ');
            if (i == (int) Math.pow(2, idx) - 1) {
                sb.append('\n');
                idx++;
            }
        }

        System.out.println(sb);

        br.close();
    }

    static void inOrderTreeTraversal(int start) {
        if (start * 2 < size) {
            inOrderTreeTraversal(start * 2);
        }
        answer[start] = Integer.parseInt(st.nextToken());
        if (start * 2 < size) {
            inOrderTreeTraversal(start * 2 + 1);
        }
    }


}

