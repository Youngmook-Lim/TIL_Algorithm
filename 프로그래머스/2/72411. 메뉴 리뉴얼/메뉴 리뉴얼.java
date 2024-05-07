import java.util.*;

class Solution {
    
    Set<Character>[] setArr;
    List<Character> list;
    int cnt;
    String[] orders;
    int[] course;
    int max;
    List<String> maxWords;
    List<String> result;
    
    public String[] solution(String[] orders, int[] course) {
        
        for (int i = 0; i < orders.length; i++) {
            char[] tmp = orders[i].toCharArray();
            Arrays.sort(tmp);
            StringBuilder sb = new StringBuilder();
            for (char x : tmp) {
                sb.append(x);
            }
            orders[i] = sb.toString();
        }
        this.orders = orders;
        this.course = course;
    
        result = new ArrayList<>();
        maxWords = new ArrayList<>();
        list = new ArrayList<>();
        setArr = new Set[orders.length];
        for (int i = 0; i < orders.length; i++) {
            setArr[i] = new HashSet<>();
            for (int j = 0; j < orders[i].length(); j++) {
                setArr[i].add(orders[i].charAt(j));
            }
        }
        
        for (int i = 0; i < course.length; i++) {
            cnt = course[i];
            max = 1;
            maxWords.clear();
            for (int j = 0; j < orders.length; j++) {
                if (orders[j].length() < cnt) continue;
                dfs(j, 0);
            }
            for (String x : maxWords) {
                result.add(x);
            }
        }
        
        Collections.sort(result);
        String[] res = new String[result.size()];
        for (int i = 0; i < result.size(); i++) {
            res[i] = result.get(i);
        }
        return res;
    }
    
    void check(int orderNum) {
        
        StringBuilder sb = new StringBuilder();
        for (char x : list) {
            sb.append(x);
        }
        
        if (maxWords.contains(sb.toString())) return;
        
        int cnt = 1;
        
        for (int i = 0; i < orders.length; i++) {
            if (i == orderNum) continue;
            // if (orders[i].length() < cnt) continue;
            boolean flag = false;
            for (char x : list) {
                if (!setArr[i].contains(x)) {
                    flag = true;
                    break;
                }
            }
            if (flag) continue;
            // System.out.println(list + " " + orders[i]);
            cnt++;
        }
        if (cnt >= 2 && cnt >= max) {
            if (cnt > max) {
                maxWords.clear();
            }
            
            maxWords.add(sb.toString());
            max = cnt;
        }
    }
    
    void dfs(int orderNum, int idx) {
        
        if (list.size() == cnt) {
            // System.out.println(list);
            check(orderNum);
            return;
        }
        
        for (int i = idx; i < orders[orderNum].length(); i++) {
            list.add(orders[orderNum].charAt(i));
            dfs(orderNum, i + 1);
            list.remove(list.size() - 1);
        }
    }
}