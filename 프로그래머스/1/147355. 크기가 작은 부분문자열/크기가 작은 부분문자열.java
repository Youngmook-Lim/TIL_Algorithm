class Solution {
    public int solution(String t, String p) {
        
        int size = p.length();
        long pInt = Long.parseLong(p);
        int cnt = 0;
        
        for (int i = 0; i < t.length() - size + 1; i++) {
            long substr = Long.parseLong(t.substring(i, i + size));
            if (substr <= pInt) cnt++;
        }
        
        return cnt;
    }
}