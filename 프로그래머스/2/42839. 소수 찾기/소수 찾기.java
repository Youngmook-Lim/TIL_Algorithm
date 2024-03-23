import java.util.*;

class Solution {
    
    List<Character> list = new ArrayList<>();
    Set<Integer> set = new HashSet<>();
    boolean[] visited;
    String numbers;
    int answer = 0;
    int n;
    
    public int solution(String numbers) {
        
        this.n = numbers.length();
        this.numbers = numbers;
        visited = new boolean[n];
        
        dfs(0); 
        
        return answer;
    }
    
    public boolean isPrime(int num) {
        if (num < 2) return false;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) return false;
        }
        return true;
    }
    
    public void check() {
        StringBuilder sb = new StringBuilder();
        for (char x : list) {
            sb.append(x);
        }
        int num = Integer.parseInt(sb.toString());
        if (!set.contains(num)) {
            set.add(num);
            System.out.println(num);
            if (isPrime(num)) this.answer++;
        }
        
    }
    
    public void dfs(int idx) {
        
        if (!list.isEmpty()) {
            check();
        }
        
        for (int i = 0; i < n; i++) {
            if (visited[i]) continue;
            
            list.add(numbers.charAt(i));
            visited[i] = true;
            dfs(i + 1);
            visited[i] = false;
            list.remove(list.size() - 1);
        }
    }
}