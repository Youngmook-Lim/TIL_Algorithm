import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.*;

/*
 * 1. 대여 정보를 하나씩 읽으면서 hashmap에 없으면 추가하고, 있으면 뽑아서 시간 비교한다.
 * 2. 벌금을 내야하면 pq에 저장하고 마지막에 사전순으로 뽑는다.
 * */
public class Main {

    static int n, l, f;
    static HashMap<String, Date> hm;
    static TreeMap<String, Long> tm;

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
            st = new StringTokenizer(br.readLine());
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            String dateTmp = st.nextToken().concat(" ").concat(st.nextToken());
            Date curDate = dateFormat.parse(dateTmp);
            String p = st.nextToken();
            String m = st.nextToken();
            String key = p + "_" + m;
            if (hm.containsKey(key)) {
                Date rentalDate = hm.get(key);
                long dateDiff = (curDate.getTime() - rentalDate.getTime()) / 60000;
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

}