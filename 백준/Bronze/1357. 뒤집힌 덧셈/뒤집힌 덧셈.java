import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        System.out.println(getRev(getRev(x) + getRev(y)));

        br.close();
    }

    public static int getRev(int n) {
        StringBuilder sb = new StringBuilder();
        sb.append(n);
        sb.reverse();
        return Integer.parseInt(sb.toString());
    }

}














