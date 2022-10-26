import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 1. 배열을 순회하며 각 요소를 꼭지점으로 가정하고, 그 기준으로 증가하고 감소하는 부분수열의 길이을 합한 것을 구한다.
 * */
public class Main {

    static int n, ans;
    static int[] arr, lis, lds;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        lis = new int[n];
        lds = new int[n];

        calculateLIS();
        calculateLDS();

        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, lis[i] + lds[i] + 1);
        }

        System.out.println(ans);

        br.close();
    }

    static void calculateLIS() {
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j]) {
                    lis[i] = Math.max(lis[i], lis[j] + 1);
                }
            }
        }
    }

    static void calculateLDS() {
        for (int i = n - 2; i >= 0; i--) {
            for (int j = n - 1; j > i; j--) {
                if (arr[i] > arr[j]) {
                    lds[i] = Math.max(lds[i], lds[j] + 1);
                }
            }
        }
    }


}

