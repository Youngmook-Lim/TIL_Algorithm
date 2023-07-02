import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());
            int startH = Integer.parseInt(st.nextToken());
            int startM = Integer.parseInt(st.nextToken());
            int startS = Integer.parseInt(st.nextToken());
            int endH = Integer.parseInt(st.nextToken());
            int endM = Integer.parseInt(st.nextToken());
            int endS = Integer.parseInt(st.nextToken());

            int h, m, s;

            if (endS < startS) {
                endM--;
                endS += 60;
            }
            s = endS - startS;

            if (endM < startM) {
                endH--;
                endM += 60;
            }
            m = endM - startM;

            h = endH - startH;

            sb.append(h).append(' ').append(m).append(' ').append(s).append('\n');
        }

        System.out.println(sb);

        br.close();

    }


}