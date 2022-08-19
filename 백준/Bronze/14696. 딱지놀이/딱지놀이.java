import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int numCardsA = Integer.parseInt(st.nextToken());
            int[] cardsA = new int[5];
            for (int j = 0; j < numCardsA; j++) {
                cardsA[Integer.parseInt(st.nextToken())]++;
            }
            st = new StringTokenizer(br.readLine());
            int numCardsB = Integer.parseInt(st.nextToken());
            int[] cardsB = new int[5];
            for (int j = 0; j < numCardsB; j++) {
                cardsB[Integer.parseInt(st.nextToken())]++;
            }

            for (int j = 4; j > 0; j--) {
                if (cardsA[j] > cardsB[j]) {
                    bw.write('A' + "\n");
                    break;
                } else if (cardsA[j] < cardsB[j]) {
                    bw.write('B' + "\n");
                    break;
                }
                if (j == 1) {
                    bw.write('D' + "\n");
                    break;
                }
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
