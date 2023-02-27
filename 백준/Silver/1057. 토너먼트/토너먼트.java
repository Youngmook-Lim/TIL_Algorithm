import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int kim = Integer.parseInt(st.nextToken()) - 1;
        int lim = Integer.parseInt(st.nextToken()) - 1;

        int cnt = 0;

        while (kim != lim) {
            kim /= 2;
            lim /= 2;
            cnt++;
        }

        System.out.println(cnt);

        br.close();
    }


}


