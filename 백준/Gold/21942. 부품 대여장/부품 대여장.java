import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;
import java.util.TreeMap;

/*
 * 1. 대여 정보를 하나씩 읽으면서 hashmap에 없으면 추가하고, 있으면 뽑아서 시간 비교한다.
 * 2. 벌금을 내야하면 pq에 저장하고 마지막에 사전순으로 뽑는다.
 * */
public class Main {

    static int n, l, f;
    static HashMap<String, Long> hm;
    static TreeMap<String, Long> tm;
    static int[] days = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        String tmp = st.nextToken();
        int day = Integer.parseInt(tmp.substring(0, 3));
        int hour = Integer.parseInt(tmp.substring(4, 6));
        int min = Integer.parseInt(tmp.substring(7, 9));
        l = day * 60 * 24 + hour * 60 + min;
        f = Integer.parseInt(st.nextToken());
        hm = new HashMap<>();
        tm = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            long curDate = convertToMin(input[0], input[1]);
            String p = input[2];
            String m = input[3];
            String key = p + "_" + m;
            if (hm.containsKey(key)) {
                long rentalDate = hm.get(key);
                long dateDiff = curDate - rentalDate;
                if (dateDiff > l) {
//                    System.out.println(curDate);
//                    System.out.println(rentalDate);
//                    System.out.println(key + " " + (dateDiff / 60 / 24));
                    tm.put(m, tm.getOrDefault(m, 0L) + (dateDiff - l) * f);
                }
                hm.remove(key);
            } else {
                hm.put(key, curDate);
            }
        }

        StringBuilder sb = new StringBuilder();
        if (tm.isEmpty()) {
            sb.append(-1);
        } else {
            for (String x : tm.keySet()) {
                sb.append(x).append(' ').append(tm.get(x)).append('\n');
            }
        }

        System.out.println(sb);

        br.close();
    }

    static long convertToMin(String dateString, String timeString) {
        String[] date = dateString.split("-");
        String[] time = timeString.split(":");
        long month = Integer.parseInt(date[1]);
        long day = Integer.parseInt(date[2]);
        long totalDays = 0;
        for (int i = 0; i < month - 1; i++) {
            totalDays += days[i];
        }
        totalDays += day - 1;

        long hour = Integer.parseInt(time[0]);
        long min = Integer.parseInt(time[1]);

        return totalDays * 24 * 60 + hour * 60L + min;
    }

}