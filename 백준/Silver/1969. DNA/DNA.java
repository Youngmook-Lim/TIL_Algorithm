import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    static int n, m, cnt;
    static String[] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new String[n];
        for (int i = 0; i < n; i++) {
            arr[i] = br.readLine();
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < m; i++) {
            int A = 0;
            int C = 0;
            int G = 0;
            int T = 0;
            int max = 0;
            for (int j = 0; j < n; j++) {
                char nucleotide = arr[j].charAt(i);
                switch (nucleotide) {
                    case 'A':
                        A++;
                        if (A > max) {
                            max = A;
                        }
                        break;
                    case 'C':
                        C++;
                        if (C > max) {
                            max = C;
                        }
                        break;
                    case 'G':
                        G++;
                        if (G > max) {
                            max = G;
                        }
                        break;
                    case 'T':
                        T++;
                        if (T > max) {
                            max = T;
                        }
                        break;
                }
            }
            if (A == max) {
                sb.append('A');
                cnt += C + G + T;
            } else if (C == max) {
                sb.append('C');
                cnt += A + G + T;
            } else if (G == max) {
                sb.append('G');
                cnt += C + A + T;
            } else {
                sb.append('T');
                cnt += C + G + A;
            }
        }

        System.out.println(sb);
        System.out.println(cnt);

        br.close();
    }


}
