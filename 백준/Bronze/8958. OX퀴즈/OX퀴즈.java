import java.io.*;

public class Main {

    static int n;
    static int score;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            score = 0;
            int streak = 1;
            String ox = br.readLine();
            for (int j = 0; j < ox.length(); j++) {
                if (ox.charAt(j) == 'O') {
                    score += streak++;
                } else {
                    streak = 1;
                }
            }

            bw.write(score + "\n");
        }

        bw.flush();
        bw.close();
        br.close();

    }
}

