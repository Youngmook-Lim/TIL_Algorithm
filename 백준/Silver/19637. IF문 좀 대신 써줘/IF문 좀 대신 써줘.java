import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

    static int n, m;
    static int[] categories;
    static String[] categoriesNames;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        categories = new int[n];
        categoriesNames = new String[n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            categoriesNames[i] = st.nextToken();
            categories[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < m; i++) {
            int num = Integer.parseInt(br.readLine());
            int start = 0;
            int end = n - 1;
            int ans = 0;

            while (start <= end) {
                int mid = (start + end) / 2;

                if (categories[mid] >= num) {
                    ans = mid;
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }

            sb.append(categoriesNames[ans]).append('\n');
        }

        System.out.println(sb);

        br.close();

    }


}