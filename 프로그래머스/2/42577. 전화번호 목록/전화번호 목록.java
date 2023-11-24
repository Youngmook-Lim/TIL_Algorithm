import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        
        Arrays.sort(phone_book);
        
        Set<String> set = new HashSet();
        
        for (int i = phone_book.length - 1; i >= 0; i--) {
            String cur = phone_book[i];
            if (set.contains(cur)) return false;
            for (int j = 1; j <= cur.length(); j++) {
                set.add(cur.substring(0, j));
            }
        }
        
        return true;
        
    }
}