import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n, m, idxA, idxB;
    static int[] a, b;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        a = new int[n];
        b = new int[m];


        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            b[i] = Integer.parseInt(st.nextToken());
        }

        while (idxA < n && idxB < m) {
            if (a[idxA] <= b[idxB]) {
                sb.append(a[idxA++]).append(' ');
            } else {
                sb.append(b[idxB++]).append(' ');
            }
        }

        while (idxA < n) {
            sb.append(a[idxA++]).append(' ');
        }
        while (idxB < m) {
            sb.append(b[idxB++]).append(' ');
        }

        System.out.println(sb);

        br.close();
    }


}

