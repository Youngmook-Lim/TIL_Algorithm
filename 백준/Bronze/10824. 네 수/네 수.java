import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;


        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            if (i == 2) {
                sb.append(' ');
            }
            sb.append(st.nextToken());
        }

        String[] ㅋㅋㅋ = sb.toString().split(" ");

        System.out.println(Long.parseLong(ㅋㅋㅋ[0]) + Long.parseLong(ㅋㅋㅋ[1]));

        br.close();
    }


}














