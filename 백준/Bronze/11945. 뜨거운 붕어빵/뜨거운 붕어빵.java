import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());


        StringBuilder sb = new StringBuilder();
        for (int i = n - 1; i >= 0; i--) {
            StringBuilder tmp = new StringBuilder();
            tmp.append(br.readLine());
            sb.append(tmp.reverse()).append('\n');
        }

        System.out.println(sb);

        br.close();
    }


}
