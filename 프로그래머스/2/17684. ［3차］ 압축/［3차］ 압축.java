import java.util.*;


class Solution {
    public int[] solution(String msg) {

        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < 26; i++) {
            map.put(Character.toString('A' + i), i + 1);
        }

        List<Integer> list = new ArrayList<>();

        int idx = 27;
        int j = 0;

        while (j < msg.length()) {
            int len = 1;
            boolean flag = false;

            String cur = msg.substring(j, j + len);
            while (map.containsKey(cur) && j + len <= msg.length()) {
                len++;
                if (j + len > msg.length()) {
                    flag = true;
                    break;
                }

                cur = msg.substring(j, j + len);
            }
            if (flag) {
                list.add(map.get(cur));
            } else {
                list.add(map.get(cur.substring(0, cur.length() - 1)));
            }
            map.put(cur, idx++);

            j += --len;
        }

        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }
}