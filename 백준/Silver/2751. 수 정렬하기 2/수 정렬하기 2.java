import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int n;
    static int[] arr;
    static int[] sorted;
    static int[] count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        sorted = new int[n];
        
        int max = 0;
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            // 배열에서 최대값 갱신
            if (arr[i] > max) {
                max = arr[i];
            }
            // 배열에서 최소값 갱신
            if (arr[i] < min) {
                min = arr[i];
            }
        }

        // 배열에 음수가 하나라도 있으면 조정이 필요하므로 
        // min이 음수일때 min 규모만큼 배열 요소들을 더해줌 
        if (min < 0) {
            for (int i = 0; i < n; i++) {
                arr[i] += -min;
            }
            // 밑에 사용할 max값도 min 규모만큼 더해줌
            max += -min;
        }

        // 카운팅 배열 생성
        count = new int[max + 1];

        // 기존배열 순회하며 카운팅 배열 인덱스 위치에 하나씩 더해줌
        for (int x : arr) {
            count[x]++;
        }

        // 누적합 구함
        for (int i = 1; i < count.length; i++) {
            count[i] += count[i - 1];
        }

        // 정렬된 값들을 담을 sorted 배열에 담아줌
        for (int i = n - 1; i >= 0; i--) {
            sorted[--count[arr[i]]] = arr[i];
        }

        // 아까와 같이, 음수가 하나라도 있을 경우 offset 작업 해줘야 하므로
        // 아까 더해준 만큼의 값을 빼줌
        if (min < 0) {
            for (int i = 0; i < n; i++) {
                sorted[i] += min;
            }
        }

        // 출력
        StringBuilder sb = new StringBuilder();
        for (int x : sorted) {
            sb.append(x).append("\n");
        }
        System.out.println(sb);

        br.close();

    }

}