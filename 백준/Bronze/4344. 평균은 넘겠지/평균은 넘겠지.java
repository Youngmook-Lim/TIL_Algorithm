import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int C = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int c = 0; c < C; c++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int[] arr = new int[n];
            double total = 0;
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
                total += arr[i];
            }
            double average = total / n;
            double cnt = 0;
            for (int i = 0; i < n; i++) {
                if (arr[i] > average) {
                    cnt++;
                }
            }
            sb.append(String.format("%.3f", cnt * 100 / n)).append('%').append('\n');

        }
        System.out.println(sb);

        br.close();

    }


}