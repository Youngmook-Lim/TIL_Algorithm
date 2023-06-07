import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int m = Integer.parseInt(br.readLine());

        int ten = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            int num = Integer.parseInt(st.nextToken());
            ten += num * Math.pow(a, m - i - 1);
        }

        StringBuilder sb = new StringBuilder();

        while (ten > 0) {
            int mod = ten % b;
            ten /= b;
            sb.insert(0, mod).insert(0, ' ');
        }


        System.out.println(sb.substring(1));

        br.close();
    }


}
