import java.util.*;

class Solution {
    
    class N implements Comparable<N>{
        Integer first, second, third, fourth;
        
        @Override
        public int compareTo(N o) {
            if (this.first != o.first) {
                return o.first - this.first;
            }
            
            int cnt1 = 0, cnt2 = 0;
            
            int s1, s2;
            if (this.second == null) {
                s1 = getDigit(++cnt1, this);
            } else {
                s1 = this.second;
            }
            if (o.second == null) {
                s2 = getDigit(++cnt2, o);
            } else {
                s2 = o.second;
            }

            if (s1 != s2 || (this.second == null && o.second == null)) {
                return s2 - s1;
            }
            
            int t1, t2;
            if (this.third == null) {
                t1 = getDigit(++cnt1, this);
            } else {
                t1 = this.third;
            }
            if (o.third == null) {
                t2 = getDigit(++cnt2, o);
            } else {
                t2 = o.third;
            }
            if (t1 != t2 || (this.third == null && o.third == null)) {
                return t2 - t1;
            }
            
            int f1, f2;
            if (this.fourth == null) {
                f1 = getDigit(++cnt1, this);
            } else {
                f1 = this.fourth;
            }
            if (o.fourth == null) {
                f2 = getDigit(++cnt2, o);
            } else {
                f2 = o.fourth;
            }
            return f2 - f1;
           
        }
    }
    
    public int getDigit(int cnt, N n) {
        Integer res = null;
        switch (cnt) {
            case 1: 
                res = n.first;
                break;
            case 2:
                res = n.second;
                break; 
            case 3:
                res = n.third;
                break;
        }
        if (res == null) {
            res = n.first;
        }
        return res;
    }
    
    public String solution(int[] numbers) {
        
        List<N> list = new ArrayList<>();
        
        for (int x : numbers) {
            String cur = Integer.toString(x);
            N n = new N();
            for (int i = 0; i < cur.length(); i++) {
                int digit = cur.charAt(i) - '0';
                switch (i) {
                    case 0:
                        n.first = digit;
                        break;
                    case 1:
                        n.second = digit;
                        break;
                    case 2:
                        n.third = digit;
                        break;
                    default:
                        n.fourth = digit;
                }
            }
            list.add(n);
        }
        
        Collections.sort(list);
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            N n = list.get(i);
            Integer cur = n.first;
            if (sb.length() == 0 && cur == 0) continue;
            
            int idx = 0;
            while (cur != null) {
                sb.append(cur);
                switch (++idx) {
                    case 1:
                        cur = n.second; 
                        break;
                    case 2:
                        cur = n.third;
                        break;
                    default:
                        cur = n.fourth;
                }
                if (idx == 4) break;
            }
        }
        
        return sb.length() == 0 ? "0" : sb.toString();
    }
}