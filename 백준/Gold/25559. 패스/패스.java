import java.io.*;
import java.util.*;

public class Main {

    static int n;
    static List<Integer> list;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(br.readLine());
        list = new ArrayList<>();

        if (n != 1 && n % 2 != 0) {
            bw.write(-1 + "\n");
        } else {
            list.add(n);
            int tmp = n - 1;
            int op = -1;
            for (int i = 0; i < n - 1; i++) {
                list.add(list.get(list.size() - 1) + tmp * op);
                tmp -= 2;
                op *= -1;
            }
            for (int i = 0; i < n; i++) {
                sb.append(list.get(i)).append(' ');
            }
            bw.write(sb.toString());
        }

        bw.flush();
        bw.close();
        br.close();
    }


}