import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static int[] arr;
    static int[] chess = {1, 1, 2, 2, 2, 8};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        arr = new int[6];
        for (int i = 0; i < 6; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < 6; i++) {
            chess[i] -= arr[i];
        }

        for (int i = 0; i < 6; i++) {
            System.out.print(chess[i] + " ");
        }


        bw.flush();
        bw.close();
        br.close();
    }


}