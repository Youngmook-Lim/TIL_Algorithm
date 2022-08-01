import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            
            Map<Integer, Boolean> hm = new HashMap<>();
            for (int i = 0; i < n; i++) {
                hm.put(Integer.parseInt(st.nextToken()), true);
            }

            int m = Integer.parseInt(br.readLine());

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < m; i++) {
                if (hm.containsKey(Integer.parseInt(st.nextToken()))) {
                    bw.write("1\n");
                } else {
                    bw.write("0\n");
                }
            }

        }
        bw.flush();
        bw.close();
        br.close();
    }
}



