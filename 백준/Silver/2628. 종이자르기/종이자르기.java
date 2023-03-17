import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;


public class Main {


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        List<Integer> horizontal = new ArrayList<>();
        List<Integer> vertical = new ArrayList<>();

        st = new StringTokenizer(br.readLine());

        int w = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());
        horizontal.add(0);
        vertical.add(0);
        horizontal.add(h);
        vertical.add(w);

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int type = Integer.parseInt(st.nextToken());
            int line = Integer.parseInt(st.nextToken());

            if (type == 0) {
                horizontal.add(line);
            } else {
                vertical.add(line);
            }
        }

        Collections.sort(horizontal);
        Collections.sort(vertical);

        int hMax = 0;
        int vMax = 0;

        for (int i = 1; i < vertical.size(); i++) {
            vMax = Math.max(vMax, vertical.get(i) - vertical.get(i - 1));
        }
        for (int i = 1; i < horizontal.size(); i++) {
            hMax = Math.max(hMax, horizontal.get(i) - horizontal.get(i - 1));
        }

        System.out.println(vMax * hMax);


        br.close();
    }


}


