import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        while (true) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            if (name.equals("#")) break;
            int age = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            if (age > 17 || weight >= 80) {
                sb.append(name).append(" Senior");
            } else {
                sb.append(name).append(" Junior");
            }
            sb.append('\n');
        }

        System.out.println(sb);

        br.close();
    }


}

