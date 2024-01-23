import java.util.*;

class Solution {
    public int solution(int[] topping) {
        Set<Integer> setLeft = new HashSet<>();
        Set<Integer> setRight = new HashSet<>();
        int[] arrRight = new int[1000001];
        
        for (int i = 0; i < topping.length; i++) {
            setRight.add(topping[i]);
            arrRight[topping[i]]++;
        }
        
        int answer = 0;
        
        for (int i = 0; i < topping.length - 1; i++) {
            int cur = topping[i];
            setLeft.add(cur);
            arrRight[cur]--;            
            if (arrRight[cur] == 0) {
                setRight.remove(cur);
            }
            if (setLeft.size() == setRight.size()) answer++;    
        }
        
        return answer;
    }
}