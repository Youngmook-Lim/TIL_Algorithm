import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        StringBuilder tmp = new StringBuilder();

        while (true) {
            tmp.append(br.readLine()).reverse();
            if (tmp.toString().equals("DNE")) break;
            sb.append(tmp).append('\n');
            tmp.setLength(0);
        }

        System.out.println(sb);

        br.close();
    }


}

