import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static long sol;
    static P[] arr;

    static class P {
        int start, increase;

        P() {
        }

        @Override
        public String toString() {
            return "P{" +
                    "start=" + start +
                    ", increase=" + increase +
                    '}';
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        arr = new P[n];
        sol = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = new P();
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i].start = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i].increase = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr, new Comparator<P>() {
            @Override
            public int compare(P o1, P o2) {
                return o1.increase - o2.increase;
            }
        });


        for (int i = 0; i < n; i++) {
            sol += arr[i].start + arr[i].increase * i;
        }

        bw.write(sol + "\n");

        bw.flush();
        bw.close();
        br.close();
    }


}