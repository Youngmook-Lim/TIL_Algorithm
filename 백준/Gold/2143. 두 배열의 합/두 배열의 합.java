import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int T, n, m;
    static long ans;
    static int[] arrN, arrM;
    static List<Integer> subsetN, subsetM;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());
        n = Integer.parseInt(br.readLine());
        arrN = new int[n + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < n + 1; i++) {
            int tmp = Integer.parseInt(st.nextToken());
            arrN[i] = arrN[i - 1] + tmp;
        }
        m = Integer.parseInt(br.readLine());
        arrM = new int[m + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < m + 1; i++) {
            int tmp = Integer.parseInt(st.nextToken());
            arrM[i] = arrM[i - 1] + tmp;
        }

        subsetN = new ArrayList<>();
        subsetM = new ArrayList<>();

        for (int i = 1; i < n + 1; i++) {
            for (int j = 0; j < i; j++) {
                subsetN.add(arrN[i] - arrN[j]);
            }
        }
        for (int i = 1; i < m + 1; i++) {
            for (int j = 0; j < i; j++) {
                subsetM.add(arrM[i] - arrM[j]);
            }
        }

        Collections.sort(subsetN);
        Collections.sort(subsetM);

        findPair();

        System.out.println(ans);

        br.close();
    }

    static void findPair() {
        int start = 0;
        int end = subsetM.size() - 1;

        while (start < subsetN.size() && end >= 0) {
            int num = subsetN.get(start) + subsetM.get(end);
            if (num > T) {
                end--;
            } else if (num < T) {
                start++;
            } else {
                long cntStart = 0;
                long cntEnd = 0;
                int startNum = subsetN.get(start);
                int endNum = subsetM.get(end);
                while (start < subsetN.size() && subsetN.get(start) == startNum) {
                    start++;
                    cntStart++;
                }
                while (end >= 0 && subsetM.get(end) == endNum) {
                    end--;
                    cntEnd++;
                }
                ans += cntStart * cntEnd;
            }
        }

    }


}

