import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int[] sides = new int[3];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 3; i++) {
            sides[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(sides);
        int total = sides[0] + sides[1];
        System.out.println(total + Math.min(total - 1, sides[2]));

        br.close();
    }


}

