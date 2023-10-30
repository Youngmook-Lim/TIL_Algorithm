import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        
        Map<String, Integer> map = new HashMap<>();
        int[] arr = new int[want.length];
        int answer = 0;
        
        for (int i = 0; i < want.length; i++) {
            map.put(want[i], i);
        }
        
        for (int i = 0; i < 10; i++) {
            if (map.containsKey(discount[i])) {
                number[map.get(discount[i])]--;
            }
        }
        
        if (check(number)) answer++;
        
        for (int i = 0; i < discount.length - 10; i++) {
            if (map.containsKey(discount[i])) {
                number[map.get(discount[i])]++;
            }
            if (map.containsKey(discount[i + 10])) {
                number[map.get(discount[i + 10])]--;
            }
            if (check(number)) answer++;
        }
        
        return answer;
    }
    
    public boolean check(int[] number) {
        for (int i = 0; i < number.length; i++) {
            if (number[i] > 0) return false;
        }
        return true;
    }
}