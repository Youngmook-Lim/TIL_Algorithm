import java.util.*;

class Solution {
    public int solution(int n, int k) {

        // 진수변환
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            sb.append(n % k);
            n /= k;
        }
        String str = sb.reverse().toString();
        
        int answer = 0;
        
        // 파싱
        Long[] arr = Arrays.stream(str.split("0")).map(String::trim)
            .filter(s -> !s.isEmpty()).map(Long::parseLong).toArray(Long[]::new);
        
        for (long x : arr) {
            if (isPrime(x)) answer++;
        }       
        
        return answer;
    }
    
    boolean isPrime(long x) {
        if (x == 1) return false;
        for (int i = 2; i <= Math.sqrt(x); i++) {
            if (x % i == 0) return false;
        }
        return true;
    }
    
}