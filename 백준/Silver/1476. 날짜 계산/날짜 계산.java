import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int year = 0;

        int e, s, m;
        st = new StringTokenizer(br.readLine());
        e = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        while (true) {
            int calcE = year % 15 + 1;
            int calcS = year % 28 + 1;
            int calcM = year % 19 + 1;

            if (calcE == e && calcS == s && calcM == m) {
                break;
            }

            year++;

        }

        System.out.println(year + 1);

        br.close();
    }


}














